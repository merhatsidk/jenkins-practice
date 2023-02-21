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
                    sh 'docker build -t tsidk29/devops-integeration2 .'
                }
            }
        }
        stage('Push to docker hub'){
            steps{
                script{
                   
                    withCredentials([string(credentialsId: 'my-latest-docker-pwd', variable: 'docker-pwd')]) {
                            // some block
                        sh "docker login -u tsidk29 -p ${docker-pwd}"
                        sh "docker push tsidk29/devops-integeration2"
                }
                    
                    //sh 'docker push tsidk29/devops-integeration'
                }
            }
        }
        stage('Deploy to the kubernetes cluster'){
            steps{
                script{
                // i am telling jenkins to read the yaml file from my github project -> in the configs: ''
                    //kubernetesDeploy configs: 'deploymentservice.yaml', kubeConfig: [path: ''], kubeconfigId: 'k8sconfigpwd', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
                    // we only need this
                    kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'k8sconfigpwd')
                }
            }
        }
    }
}
