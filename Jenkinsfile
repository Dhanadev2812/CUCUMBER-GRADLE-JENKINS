pipeline {
  agent {
        label {
            label ""
            customWorkspace "D:/Software/jenkins/Myworkspace/Branches/${BRANCH_NAME}"
        }
    }
	options {
        // When we have test-fails e.g. we don't need to run the remaining steps
        skipStagesAfterUnstable()
    }
	stages {
		stage("Build") {
        		steps {
          			echo 'Build'
          		}
		}
		stage("Unit & Integration Tests") {
			when {
                		branch 'dhana'
            		}
        		steps {
          			echo 'Started Stage one : Unit & Integration Tests ..'
          			bat 'gradle cucumber -Dcucumber.options="--tags @login_valid and --tags @Clinicadmin'
          		}
		}
        	stage("Publishing Cucumber report") {
			when {
                		branch 'dhana'
            		}
          		steps {
		 		echo 'Generating Cucumber report..'          	
				cucumber fileIncludePattern:'**/cucumber.json', 
				jsonReportDirectory:'Report/JenkinsReport/JSON',
				reportTitle: 'cucumber',
				buildStatus: 'UNSTABLE'			
             		}
           	}
		stage("Deploy") {
        		steps {
          			echo 'Deploy'
          		}
		}
		post {
        		failure {
           			 script {
                			if(env.BRANCH_NAME == "dhana") {
                    				emailext(
                        				subject: "[BUILD-FAILURE]: Job '${env.JOB_NAME} [${env.BRANCH_NAME}] [${env.BUILD_NUMBER}]'",
                        				body: """
							BUILD-FAILURE: Job '${env.JOB_NAME} [${env.BRANCH_NAME}] [${env.BUILD_NUMBER}]':
 
							Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BRANCH_NAME}] [${env.BUILD_NUMBER}]</a>"
							""",
                        				to: "dhanadev728@gmail.com",
                        				recipientProviders: [[$class: 'DevelopersRecipientProvider']]
                    					)
                				}
            				}
        			}
        		unstable  {
            			script {
                			if(env.BRANCH_NAME == "dhana") {
                    				emailext(
                        				subject: "[BUILD-UNSTABLE]: Job '${env.JOB_NAME} [${env.BRANCH_NAME}] [${env.BUILD_NUMBER}]'",
                        				body: """
							BUILD-UNSTABLE: Job '${env.JOB_NAME} [${env.BRANCH_NAME}] [${env.BUILD_NUMBER}]':
 
							Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BRANCH_NAME}] [${env.BUILD_NUMBER}]</a>"
							""",
                        				to: "dhanadev728@gmail.com",
                        				recipientProviders: [[$class: 'DevelopersRecipientProvider']]
                    					)
                				}
            				}
        			}
 
        	success {
            		script {
                		if ((env.BRANCH_NAME == "dhana") && (currentBuild.previousBuild != null) && (currentBuild.previousBuild.result != 'SUCCESS')) {
                    			emailext (
                        			subject: "[BUILD-STABLE]: Job '${env.JOB_NAME} [${env.BRANCH_NAME}] [${env.BUILD_NUMBER}]'",
                        			body: """
						BUILD-STABLE: Job '${env.JOB_NAME} [${env.BRANCH_NAME}] [${env.BUILD_NUMBER}]':
 
						Is back to normal.
						""",
                        			to: "dhanadev728@gmail.com",
                        			recipientProviders: [[$class: 'DevelopersRecipientProvider']]
                    			)
                		}
            		}
        	}
    	}
 
         }
	
}
