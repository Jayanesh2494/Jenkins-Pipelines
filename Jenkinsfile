
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Tools') {
            steps {
                bat '''
                    "C:\\tools\\apache-maven-3.10.0\\bin\\mvn.cmd" -version
                    java -version
                '''
            }
        }

        stage('Build') {
            steps {
                bat '"C:\\tools\\apache-maven-3.10.0\\bin\\mvn.cmd" clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat '"C:\\tools\\apache-maven-3.10.0\\bin\\mvn.cmd" test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar',
                                 fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'CI Pipeline completed successfully!'
        }
        failure {
            echo 'CI Pipeline failed. Check Console Output.'
        }
    }
}
