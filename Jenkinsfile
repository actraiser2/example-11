pipeline{
    agent any
    environment {
      GITHUB_REPOSITORY_URL = 'https://github.com/actraiser2/example-11.git'
    }
    stages{
        stage('Checkout'){
            steps{
                echo 'Checking out code...'
                git branch: 'develop', url: "${GITHUB_REPOSITORY_URL}"
            }
            
        }
        stage('Build'){
            steps{
                echo 'Building...'
                withMaven(maven:'maven 3.9.11', mavenSettingsConfig:'settings'){
                    sh 'mvn clean package -DskipTests=true'
                }
                
            }
            
        }
    }
}