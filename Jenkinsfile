pipeline {

    agent any
    stages {

        stage('Checkout Codebase'){
            steps{
                cleanWs()
                checkout scm: [$class: 'GitSCM', branches: [[name: '*/master']],userRemoteConfigs:
                [[credentialsId: 'github-ssh-key', url: 'https://github.com/patel436/Testing_Lab3.git']]]
            }
        }

        stage('Build'){
            steps{
                sh 'javac -d bin -cp bin:lib/junit-1.7.jar src/math/TrignometricFunctions.java src/junit/TrignometricFunctionsTest.java src/junit/TestRunner.java '
            }
        }

        stage('Test'){
            steps{
                sh 'java -cp bin:lib/junit-1.7.jar junit.TestRunner'
       
            }
        }
        
    }

}