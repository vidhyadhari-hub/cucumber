pipeline {
    agent any

    tools {
            jdk 'Myjava'
            maven 'Mymaven'

        }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/vidhyadhari-hub/cucumber.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Execute Tests') {
            steps {
                sh 'mvn test'
            }
        }


    }
}