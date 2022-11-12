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
                sh 'cd lib/ ; wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.7.0/junit-platform-console-standalone-1.7.0-all.jar'
                sh 'cd src/junit ; javac -cp "../lib/junit-platform-console-standalone-1.7.0-all.jar" TrignometricFunctionsTest.java TestRunner.java'
            }
        }

        stage('Test'){
            steps{
                sh 'cd src/junit ; java -cp ../lib/junit-platform-console-standalone-1.7.0-all.jar TrignometricFunctionsTest'
       
            }
        }

        stage('Deploy'){
            steps{
                sh 'cd src/ ; java TestRunner' 
            }
        }
    }

}