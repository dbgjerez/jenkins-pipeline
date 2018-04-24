pipeline {    
    agent any
    
    tools {
        maven 'mvn'
        jdk 'jdk8'
    }
    
	options {
    	buildDiscarder(logRotator(numToKeepStr: '5'))
  	}
    
    environment {
    	groupId = readMavenPom().getGroupId()
	    artifactId = readMavenPom().getArtifactId()
	    version = readMavenPom().getVersion()
    }
    
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

		stage ('Tests') {
			steps {
			    sh 'mvn verify'
			}
		          
		}

        stage ('Build') {
            steps {
                sh 'mvn package -DskipTests=true' 
            }
        }

        stage ('Delivery') {
            steps {
				sh "scp target/*.jar $APP_USER@$APP_HOST:$APP_HOME"
            }
        }

        stage ('Deploy') {
            steps {
                sh 'ansible-playbook -i $ANSIBLE_HOME/inventories/dev.ini $ANSIBLE_HOME/main.yml'
            }
        }
        
    }
    
    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
           	junit 'target/surefire-reports/*.xml'
        }
    }

}


