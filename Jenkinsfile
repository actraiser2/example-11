pipeline{
    agent any
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
                sh 'mvn clean packake -DskipTests=true'
            }
            
        }
    }
}