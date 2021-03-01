package com.santalucia.example.api.config;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.util.UriComponentsBuilder;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.DefaultPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
@Import(BeanValidatorPluginsConfiguration.class)
@ConditionalOnProperty(value = "springfox.ui.enable", havingValue = "true", matchIfMissing = true)
public class SwaggerConfig {
	
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("hello-world")
            .description("Hello World API")
            .license("")
            .licenseUrl("http://unlicense.org")
            .termsOfServiceUrl("none")
            .version("1.0")
            .contact(new Contact("","", "ignacio.lopezv@santalucia.es"))
            .build();
    }

    @Bean
    public Docket customImplementation(@Value("${openapi.helloWorld.base-path:/hello-world/v1}") String basePath) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.santalucia.example.api.server"))
                    .build()
                .pathProvider(new BasePathAwareRelativePathProvider(basePath))
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.OffsetDateTime.class, java.util.Date.class)
                .genericModelSubstitutes(Optional.class)
                .apiInfo(apiInfo());
    }

    class BasePathAwareRelativePathProvider extends DefaultPathProvider {
        private String basePath;

        public BasePathAwareRelativePathProvider(String basePath) {
            this.basePath = basePath;
        }

        /*
        @Override
        protected String applicationPath() {
            return  Paths.removeAdjacentForwardSlashes(UriComponentsBuilder.fromPath(super.applicationPath()).path(basePath).build().toString());
        }
        */

        @Override
        public String getOperationPath(String operationPath) {
            UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
            return Paths.removeAdjacentForwardSlashes(
                    uriComponentsBuilder.path(operationPath.replaceFirst("^" + basePath, "")).build().toString());
        }
    }
}
