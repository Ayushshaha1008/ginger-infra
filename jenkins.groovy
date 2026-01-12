pipeline {
    agent any

    stages {

        stage("Pull") {
            steps {
                git branch: 'Dev',
                    url: 'https://github.com/Ayushshaha1008/ginger-infra.git'
            }
        }

        stage("Plan") {
            steps {
                sh '''
                echo "Cleaning old Terraform cache..."
                rm -rf .terraform
                rm -f .terraform.lock.hcl

                echo "Initializing Terraform backend..."
                terraform init -reconfigure

                echo "Running Terraform plan..."
                terraform plan -var-file=vars/dev.tfvars
                '''
            }
        }

        stage("Approval") {
            steps {
                timeout(time: 10, unit: 'MINUTES') {
                    input message: 'Approve Terraform Apply?'
                }
            }
        }

        stage("Apply") {
            steps {
                sh '''
                terraform apply -var-file=vars/dev.tfvars --auto-approve
                '''
            }
        }
    }
}
