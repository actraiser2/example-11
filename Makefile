###################################
# VARIABLES
###################################
ifeq ($(OS),Windows_NT)
BUILD_TOOL := mvnw.cmd
else
BUILD_TOOL  := ./mvnw
endif

TARGET_DIRECTORY:= target
JAR_FILE := $(shell find  ${TARGET_DIRECTORY} -name '*.jar' -not -name '*test*')
# # general
APP_NAME:= $(shell echo '$${project.artifactId}' | ./$(BUILD_TOOL) -N -q -DforceStdout help:evaluate)
PROTOCOL := http
PORT := 8080
METRICS_PORT := 8081
DEBUG_PORT := 5005
NAVIGATOR_TOOL := chrome


# # sonar
SONAR_TOKEN := ${SONAR_TOKEN} # required - change this or set in env variable
SONAR_HOST_URL ?= https://sonarqube-sonarqube.apps.nopro.ocp.santalucia.net/

# # jacoco variables
SPRING_PROFILE ?= default

# # jvm
MEM_OPTS := -Xms150m -Xmx1024m
JMX_OPTS := -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
DEBUG_OPTS := -Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,server=y,suspend=n
OTHER_OPTS :=

# # release variables
RELEASE_VERSION := ${RELEASE_VERSION} # required - change this or set in env variable
POM_VERSION := ${POM_VERSION} # required - change this or set in env variable
SCM_COMMENT_PREFIX ?= fix: [maven-release-plugin] # Default
EXCLUDE_LIST ?= mvnw,mvnw.cmd,.mvn/**,.githooks/**,CHANGELOG.md,.gitmodules/**,.githooks,.gitmodules # Default
GIT_REPO_URL := ${GIT_REPO_URL} # required - change this or set in env variable
GPG_SKIP ?= true # Default

# # makefile
.PHONY: help release release-perform release release-clean release-perform
.DEFAULT_GOAL := help

# FUNCTIONS

###################################
# # building
###################################
dependencies :		## Show dependency tree
	@$(BUILD_TOOL) dependency:tree -Dverbose

clean :		## Clean the application
	@$(BUILD_TOOL) clean

compile :		## Compile the application
	@$(BUILD_TOOL) compile

build :		## Build the application package including unit tests only
	@$(BUILD_TOOL) -Dtest=*Test package

generate-sources :		## Generate resources
	@$(BUILD_TOOL) generate-resources

verify :		## Verify that the code coverage metrics are being met
	@$(BUILD_TOOL) verify

deploy :		## maven clean deploy without test
	@$(BUILD_TOOL)  clean deploy -DskipTests

install :		## Install the application package including all tests and push to artifact repo
	@$(BUILD_TOOL) install

clean-compile :		## Clean and Compile the application including unit tests only
	@$(BUILD_TOOL) clean compile

clean-build :		## Clean and Build the application package including unit tests only
	@$(BUILD_TOOL) clean package

clean-install :		## Clean and Install the application package including all tests and push to artifact repo
	@$(BUILD_TOOL) clean install

clean-install-no-test :		## Clean and Install the application package without launch test
	@$(BUILD_TOOL) clean install -DskipTests

###################################
# # release maven stages
###################################

release-clean: ## maven release:clean
	$(BUILD_TOOL) org.apache.maven.plugins:maven-release-plugin:clean

release-prepare:	## maven release:prepare
	./$(BUILD_TOOL) org.apache.maven.plugins:maven-release-plugin:prepare \
	-DignoreSnapshots=true \
	-DreleaseVersion=$(RELEASE_VERSION) \
	-DdevelopmentVersion=$(POM_VERSION) \
	-DscmCommentPrefix=$(SCM_COMMENT_PREFIX)  \
	-DautoVersionSubmodules=true \
	-DcheckModificationExcludeList=$(EXCLUDE_LIST) \
	-Dtag=$(RELEASE_VERSION) \
	-Dgit.santalucia.url=scm:git:$(GIT_REPO_URL) \
	-Darguments="-Dgpg.skip=$(GPG_SKIP) -Dmaven.javadoc.skip=true" \
	-Dgpg.skip=$(GPG_SKIP)

release-perform :	## maven release:perform
	 ./$(BUILD_TOOL) org.apache.maven.plugins:maven-release-plugin:perform \
	-DignoreSnapshots=true \
	-DreleaseVersion=$(RELEASE_VERSION) \
	-DdevelopmentVersion=$(POM_VERSION) \
	-DscmCommentPrefix=$(SCM_COMMENT_PREFIX) \
	-DautoVersionSubmodules=true \
	-DcheckModificationExcludeList=$(EXCLUDE_LIST) \
	-Dtag=$(RELEASE_VERSION) \
	-Dgit.santalucia.url=scm:git:$(GIT_REPO_URL) \
	-Darguments="-Dgpg.skip=$(GPG_SKIP) -Dmaven.javadoc.skip=true" \
	-Dgpg.skip=$(GPG_SKIP)

release :  release-clean release-prepare release-perform

#######################
# # other maven goals
#######################
maven-version :		## get maven version
	@$(BUILD_TOOL) --version

###################################
# # testinga and validation tools
###################################
test :		## Run all tests
	@$(BUILD_TOOL) test

# unit-test :		## Run Unit tests only
#	$(BUILD_TOOL) -Dtest=*UnitTest test

# integration-test :		## Run Integration tests only
#	$(BUILD_TOOL) -Dtest=*IntegrationTest test

# functional-test :		## Run Web tests only
#	$(BUILD_TOOL) -Dtest=*FunctionalTest test

# smoke-test :		## Run Smoke tests only
#	$(BUILD_TOOL) -Dtest=*SmokeTest test

# contract-test :		## Run Contract tests only
#	$(BUILD_TOOL) -Dtest=*ContractTest test

arch-unit-online : ## arch unit test validation for online applications
	$(BUILD_TOOL) com.societegenerale.commons:arch-unit-maven-plugin:arch-test@ams-online

arch-unit-batch : ## arch unit test validation for batch applications
	$(BUILD_TOOL) com.societegenerale.commons:arch-unit-maven-plugin:arch-test@ams-batch

pre-commit-run :		## run precommit, execute pre-commit-install before
	@pre-commit run --all-files --color always

pre-commit-install :		## run precommit
	@pre-commit install

pre-commit-clean :		## run precommit
	@pre-commit clean && pre-commit gc

sonar :		## Execute sonar analisys. Need SONAR_PROJECT_KEY and SONAR_HOST_URL environment variables or provide as a makefile local variables
	$(BUILD_TOOL) sonar:sonar -Dsonar.login=$(SONAR_TOKEN) -Dsonar.host.url=$(SONAR_HOST_URL)

jacoco :		## Execute sonar analisys. Need SONAR_PROJECT_KEY and SONAR_HOST_URL environment variables or provide as a makefile local variables
	$(BUILD_TOOL) org.jacoco:jacoco-maven-plugin:prepare-agent test org.jacoco:jacoco-maven-plugin:report -Dspring.profiles.active=$(SPRING_PROFILE)

###################################
# # running
###################################
run :		## Run the application through Spring Boot plugin
	$(BUILD_TOOL) spring-boot:run -DskipTests -Dspring-boot.run.jvmArguments='$(MEM_OPTS) $(JMX_OPTS) $(OTHER_OPTS)'

debug :		## Run the application in debug mode through Spring Boot plugin
	$(BUILD_TOOL) spring-boot:run -DskipTests -Dspring-boot.run.jvmArguments='$(MEM_OPTS) $(JMX_OPTS) $(DEBUG_OPTS) $(OTHER_OPTS)'

java-run :		## Run the application through the generated fat-jar
	java $(MEM_OPTS) $(JMX_OPTS) $(OTHER_OPTS) -jar $(JAR_FILE)

java-debug :		## Run the application in debug mode through the generated fat-jar
	java $(MEM_OPTS) $(JMX_OPTS) $(DEBUG_OPTS) $(OTHER_OPTS) -jar $(JAR_FILE)

open :		## Open the browser to the application site
	start $(NAVIGATOR_TOOL) $(PROTOCOL)://localhost:$(PORT)

open-metrics :		## Open the browser to the application metrics page
	start $(NAVIGATOR_TOOL) $(PROTOCOL)://localhost:$(METRICS_PORT)/management/metrics

open-swagger :		## Open the browser to the swagger page
	start $(NAVIGATOR_TOOL) $(PROTOCOL)://localhost:$(PORT)/swagger-ui/index.html

# # pitest - mutation testing

# pitest-describe :		## Describe Pitest plugin
#	$(BUILD_TOOL) help:describe -Dplugin=pitest

# pitest-run :		## Run a mutation testing session based on Pitest
#	$(BUILD_TOOL) pitest:mutationCoverage

# pitest-open-report :		## Open the generated mutation testing report based on Pitest
#	open ./target/pit-reports/index.html


###################################
# # general
###################################

# install-java:
# ifeq ($(OS),Windows_NT)
#	winget install EclipseAdoptium.Temurin.17.JDK
# else
#	apt-get install temurin-17-jdk; // Silent
# endif

help :		## Help
	@echo ""
	@echo "*** $(APP_NAME)  Makefile help ***"
	@echo "************************************************"
	@echo "Note: linux bash required, in Windows use Git bash (MINGW64)"
	@echo "Targets list:"
	@grep -E '^[a-zA-Z_-]+ :.*?## .*$$' $(MAKEFILE_LIST) | sort -k 1,1 | awk 'BEGIN {FS = ":.*?## "}; {printf "\t\033[36m%-30s\033[0m %s\n", $$1, $$2}'
	@echo ""

print-variables :		## Print variables values
	@echo "$(APP_NAME) - - - makefile - - -"
	@echo "MAKE: $(MAKE)"
	@echo "MAKEFILES: $(MAKEFILES)"
# @echo "MAKEFILE_LIST: $(MAKEFILE_LIST)"
	@echo "- - - "
	@echo "- - - general - - -"
	@echo "BUILD_TOOL: $(BUILD_TOOL)"
	@echo "JAR_FILE: $(JAR_FILE)"
	@echo "PROTOCOL: $(PROTOCOL)"
	@echo "PORT: $(PORT)"
	@echo "METRICS_PORT: $(METRICS_PORT)"
	@echo "DEBUG_PORT: $(DEBUG_PORT)"
	@echo "NAVIGATOR_TOOL: $(NAVIGATOR_TOOL)"
	@echo "- - - "
	@echo "- - - jvm - - -"
	@echo "MEM_OPTS: $(MEM_OPTS)"
	@echo "JMX_OPTS: $(JMX_OPTS)"
	@echo "DEBUG_OPTS: $(DEBUG_OPTS)"
	@echo "OTHER_OPTS: $(OTHER_OPTS)"
	@echo "- - - release - - -"
	@echo "RELEASE_VERSION: $(RELEASE_VERSION)"
	@echo "POM_VERSION: $(POM_VERSION)"
	@echo "SCM_COMMENT_PREFIX: $(SCM_COMMENT_PREFIX)"
	@echo "EXCLUDE_LIST: $(EXCLUDE_LIST)"
	@echo "GIT_REPO_URL: $(GIT_REPO_URL)"
	@echo "- - - sonar - - -"
	@echo "SONAR_TOKEN: $(SONAR_TOKEN)"
	@echo "SONAR_HOST_URL: $(SONAR_HOST_URL)"
	@echo "- - - "
	@echo ""

# LINKS

# Makefile manual	https://www.gnu.org/software/make/manual/make.html
# JVM arguments		https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/maven-plugin/run-mojo.html#jvmArguments
