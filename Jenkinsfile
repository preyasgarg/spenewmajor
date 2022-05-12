pipeline {
    agent any
    stages {
        stage('Stage 1 : Git Clone') {
            steps {
    			git url:'https://github.com/preyasgarg/spenewmajor.git',branch: 'main'
            }
        }
        
        stage('Stage 2 : Maven Build') {
            steps {
            	dir("Mess-management-backend"){
                    sh 'mvn clean package -Dmaven.test.skip'
            	}
            }
        }
        
        stage('Stage 3: Building our backend') {
            steps{
                script {
                    dir('Mess-management-backend'){
                        sh 'pwd' 
                        sh 'docker build -t preyasgarg/messmgmt:v4 .'
                    }
                }
            }
        }
        
        stage('Stage 4 : Building our frontend') {
            steps{
                script {
                    dir('messmanagement-frontent-new-'){
                        sh 'pwd'
                        sh 'npm install'
                        sh 'docker build -t preyasgarg/frontend:v4 .'
                    }
                }
            }
        }
        
        stage('Stage 5 : Publish Docker Image') {
            steps {
                withDockerRegistry([ credentialsId: "docker-login", url: "" ]) {
                    sh 'docker push preyasgarg/frontend:v4'
                    sh 'docker push preyasgarg/messmgmt:v4'
                }
            }
        }
        
        stage('Step 6: Clean Docker Images') {
            steps {
                sh 'docker rmi -f preyasgarg/frontend:v4'
                sh 'docker rmi -f preyasgarg/messmgmt:v4'
                
            }
        }
        
        stage('Stage 7 : Ansible Deploy') {
            steps {
                //ansiblePlaybook colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'inventory', playbook: 'deploy.yml'
                sh 'ansible-playbook deploy.yml -i inventory --extra-vars "ansible_sudo_pass=preyas" -e "ansible_python_interpreter=/usr/bin/python3"'
            }
        }
    }
}
