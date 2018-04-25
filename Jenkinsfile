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
			parallel {
				stage ('Unit') {
					steps {
				    	sh 'mvn clean verify'   
					}
				}   
				stage ('Integration') {
					steps {
						echo "Integration tests"
					}
				}
				stage ('Acceptance') {
					steps {
						echo "Acceptance tests"
					}
				}
			}
		}

		stage ('SonarQube') {
            steps {
				echo "SonarQube analysis"
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn package -DskipTests=true' 
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


