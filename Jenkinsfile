pipeline {
    agent any

    environment {
      IMAGE_NAME = "my-app"
      APP_YML_FILE = 'APPLICATION_YML_FILE'
      APP_DIR = "${HOME}/app"
    }
    
    stages {
        // 감지 = main : push (commit)
        stage('Check Out') {
            steps {
                echo 'Git Checkout'
                checkout scm
            }
        }
    
        stage('Build with Gradle') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew clean build -x test'
            }
        }

        // Docker Build 
        stage('Build Docker Image') {
            steps {
                sh '''
                    docker build -t $IMAGE_NAME .
                '''
            }
        }

        // 컨테이너 실행
        stage('Run Container') {
            steps {
                withCredentials([file(credentialsId: APP_YML_FILE, variable: 'APP_YML')]) {
                    sh '''
                         cd $APP_DIR

                         export IMAGE_NAME=${IMAGE_NAME}
                         export APP_YML_PATH=${APP_YML}

                         docker compose pull
                         docker compose up -d --remove-orphans
                    '''
                }
            }
        }

    }
}
