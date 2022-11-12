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
                sh 'mkdir lib'
                sh 'cd src/junit/ ; javac -cp "../lib/junit-jupiter-5.8.1.jar" TrignometricFunctionsTest.java TestRunner.java'
            }
        }

        stage('Test'){
            steps{
                sh 'cd src/junit/ ; java -jar ../lib/junit-jupiter-5.8.1.jar -cp "." --select-class TrignometricFunctionsTest --reports-dir="reports"'
                junit 'src/reports/*-jupiter.xml'
            }
        }

        stage('Deploy'){
            steps{
                sh 'cd src/ ; java TestRunner' 
            }
        }
    }

}