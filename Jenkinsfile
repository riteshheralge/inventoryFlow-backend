pipeline {

    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/riteshheralge/inventoryFlow-backend.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test Project') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deployment Successful!'
            }
        }
    }
}