
pipeline {
    agent any
     parameters {
        string(name: 'SERVERIP', defaultValue: '', description: 'Tomcat installation')
     }
    stages{
        stage("checking the file"){
            steps{
                sh "ls -l tomcat.sh"
            }
        }
        stage("copying script to server"){
            steps{
                sh """
                scp -o StrictHostKeyChecking=no -i /tmp/sep15.pem tomcat.sh ec2-user@${SERVERIP}:/tmp
                ssh -o StrictHostKeyChecking=no -i /tmp/sep15.pem ec2-user@${SERVERIP} "ls -l /tmp"
                ssh -o StrictHostKeyChecking=no -i /tmp/sep15.pem ec2-user@${SERVERIP} "sudo bash /tmp/tomcat.sh"
                """
            }
        }
    }
}