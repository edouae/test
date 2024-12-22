pipeline {
    agent any

    environment {
        MAVEN_HOME = tool name: 'Maven', type: 'maven'
        DOCKER_REGISTRY = 'docker.io'
        DOCKER_IMAGE = 'test-project'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('Test') {
            steps {
                sh "mvn test"
            }
        }

        stage('Docker Build') {
            steps {
                sh 'sudo docker build -t ${DOCKER_REGISTRY}/${DOCKER_IMAGE}:${BUILD_NUMBER} .'
            }
        }

        stage('Publish Docker Image') {
            steps {
                withDockerRegistry([credentialsId: '0d001dba-f6ae-4ced-bc1a-61ebecf02d63', url: 'https://app.docker.com/']) {
                    sh 'sudo docker push ${DOCKER_REGISTRY}/${DOCKER_IMAGE}:${BUILD_NUMBER}'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and deployment completed successfully.'
        }
        failure {
            echo 'Build or deployment failed.'
        }
    }
}