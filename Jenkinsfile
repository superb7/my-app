pipeline {
    agent any

    stages {
        // 감지 = main : push (commit)
        stage('Check Out') {
            steps {
                echo 'Git Checkout'
                checkout scm
            }
        }

        stage('Prepare application.yml') {
            steps {
                withCredentials([file(credentialsId: 'APPLICATION_YML_FILE', variable: 'APP_YML')]) {
                    sh '''
                        mkdir -p src/main/resources
                        cp $APP_YML src/main/resources/application.yml
                    '''
                }
            }
        }
    
        // gradlew 권한 부여
        stage('Gradle Permission') {
            steps {
                sh '''
                    chmod +x gradlew
                '''
            }
        }

        // build 
        stage('Gradle Build') {
            steps {
                sh '''
                    ./gradlew clean build -x test
                '''
            }
        }

        // Docker Build 
        stage('Docker Build') {
            steps {
                sh '''
                    docker build -t spring-my-app
                '''
            }
        }

        // 컨테이너 실행
        stage('Deploy') {
            steps {
                sh '''
                     docker stop spring-my-app || true
                     docker rm spring-my-app || true
                     docker run -d --name spring-my-app -p 9090:9090 spring-my-app
                '''
            }
        }

    }
}
