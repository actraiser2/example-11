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
                withMaven{
                    sh 'mvn clean package -DskipTests=true'
                }
                
            }
            
        }
    }
}