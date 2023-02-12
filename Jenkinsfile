pipeline {
    agent any
    tools{
        maven 'maven_3_9_0'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/merhatsidk/jenkins-practice']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t tsidk29/devops-integeration .'
                }
            }
        }
        stage('Push to docker hub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                    sh 'docker login -u tsidk29 -p ${dockerhubpwd}'
                    }
                    sh 'docker push tsidk29/devops-integeration'
                }
            }
        }
    }
}