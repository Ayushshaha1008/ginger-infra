pipeline{
    agent any
    stages{
        stage("Pull"){
            steps {
                git branch: 'Dev', url: 'https://github.com/Ayushshaha1008/ginger-infra.git'
            }
        }
            stage("Plan"){
            steps {
                sh '''terraform init
                terraform plan -var-file=vars/dev.tfvars'''
            }
        }
            stage("Approval"){
             steps {
                timeout(time: 10, unit: 'MINUTES'){
                input 'wait for approval'
                }
            }
        }

            stage("Apply"){
            steps {
                sh 'terraform apply -var-file=vars/dev.tfvars --auto-approve'
            }
        }
    }
}