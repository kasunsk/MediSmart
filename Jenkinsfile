pipeline {

    agent any

    stages {
        stage('Checkout') {
            steps { //Checking out the repo
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[url: 'https://github.com/kasunsk/MediSmart.git']]])
            }
        }
        stage('Build') {
                    steps {
                        script {
                            sh './gradlew clean build -x test --no-daemon' //run a gradle task
                        }
                    }
                }
        stage('Unit Test') {
            steps {
                script {
                    try {
                        sh './gradlew test --no-daemon' //run a gradle task
                    } finally {
                        junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                    }
                }
            }
        }
        stage('Docker Image') {
                    steps {
                        script {
                           sh './gradlew docker --no-daemon' //run a gradle task
                        }
                    }
                }
        stage('Docker Push') {
                     steps {
                          script {
                            sh './gradlew dockerPushDockerHub --no-daemon' //run a gradle task
                         }
                     }
                 }
    }
}