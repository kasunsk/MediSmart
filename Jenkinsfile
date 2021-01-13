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
                            sh './gradlew clean build --no-daemon' //run a gradle task
                        }
                    }
                }
        stage('Unit Test') {
            steps {
                script {
                    try {
                        sh './gradlew clean test --no-daemon' //run a gradle task
                    } finally {
                        junit '**/build/test-results/test/*.xml' //make the junit test results available in any case (success & failure)
                    }
                }
            }
        }
    }
}