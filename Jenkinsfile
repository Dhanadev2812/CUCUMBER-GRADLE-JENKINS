pipeline {
  agent {
        label {
            label ""
            customWorkspace "D:/Software/jenkins/Myworkspace/Branches/${BRANCH_NAME}"
        	}
    	}
	options {
		skipDefaultCheckout()
        	skipStagesAfterUnstable()
    	}
	environment {
            RECIPIENT_EMAIL = 'dhanadev728@gmail.com;sandhiya.2894@gmail.com'
	    SENDER_EMAILS = 'sandhiya.2894@gmail.com'
        }
	
	stages {
		 stage('Clean up & SCM Checkout') {
            		steps {
                		script {
					def exists = fileExists "D:/Software/jenkins/Myworkspace/Branches/${BRANCH_NAME}"
					if (exists) {
    						echo 'File Exist'
						cleanWs()
					} 
					else {
    						echo 'Empty dir'
					}
					checkout scm 
                		}
            		}
        	}
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
		 		echo 'Publishing Cucumber report..'          	
				cucumber fileIncludePattern:'**/cucumber.json', 
				jsonReportDirectory:'Report/JenkinsReport/JSON',
				sortingMethod: 'ALPHABETICAL',
				reportTitle: 'ClinaNG Report',
				buildStatus: 'UNSTABLE'			
             		}
           	}
		stage("Deploy") {
        		steps {
          			echo 'Deploy'
        		
  			}	
		}
	}
	post {
		success {  
             		echo 'This will run only if success' 	
			//emailext  attachmentsPattern:'**/overview-features.html',
			//body:body: "<b>Build Status Report</b> <br>Job name : Job ${JOB_NAME} <br>Build No : build ${BUILD_NUMBER} <br>Branch Name :${env.BRANCH_NAME} <br>Build Result : ${currentBuild.currentResult} <br> Check console output at ${BUILD_URL} to view the results.",
        		//mimeType: 'text/html',
        		//subject: "[Jenkins] :: BUILD SUCCESS :: ${currentBuild.fullDisplayName}",
			//from:"${SENDER_EMAILS}",
        		//to: "${RECIPIENT_EMAIL}",
        		//replyTo: ''
        		//recipientProviders: [developers(), requestor()]
			
			emailext  attachLog:true,compressLog:true,
				attachmentsPattern:'**/overview-features.html',
				body : readFile"${env.WORKSPACE}/Template/ClinaNGtemp.html",
				mimeType: 'text/html',
				//body:'$DEFAULT_CONTENT',
				replyTo: '$DEFAULT_REPLYTO', 
				to: "${RECIPIENT_EMAIL}",
				subject: '$PROJECT_NAME: Run: ${TEST_COUNTS,var="total"}',
				//body:'${FILE,path="Report/JenkinsReport/htmlFullReport/cucumber-html-reports/overview-features.html"}',
				recipientProviders: [[$class: 'RequesterRecipientProvider']]
         	}
		failure {  
             		echo 'This will run only if failure' 
			emailext body: "<b>Build Status Report</b> <br>Job name : Job ${JOB_NAME} <br>Build No : build ${BUILD_NUMBER} <br>Branch Name :${env.BRANCH_NAME} <br>Build Result : ${currentBuild.currentResult} <br> Check console output at ${BUILD_URL} to view the results.",
        		mimeType: 'text/html',
        		subject: "[Jenkins] :: BUILD FAILURE :: ${currentBuild.fullDisplayName}",
			from:"${SENDER_EMAILS}",
        		to: "${RECIPIENT_EMAIL}",
        		replyTo: ''
        		//recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         	}
		unstable {  
             		echo 'This will run only if unstable' 
			emailext body: "<b>Build Status Report : Failed to generate cucumber report </b> <br>Job name : Job ${JOB_NAME} <br>Build No : build ${BUILD_NUMBER} <br>Branch Name :${BRANCH_NAME} <br>Build Result : ${currentBuild.currentResult} <br> Check console output at ${BUILD_URL} to view the results.",
        		mimeType: 'text/html',
        		subject: "[Jenkins] :: BUILD UNSTABLE :: ${currentBuild.fullDisplayName}",
			from:"${SENDER_EMAILS}",
        		to: "${RECIPIENT_EMAIL}",
        		replyTo: ''
        		//recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         	}
               aborted {  
             		echo 'This will run only if aborted' 
			emailext body: "<b>Build Status Report</b> <br>Job name : Job ${JOB_NAME} <br>Build No : build ${BUILD_NUMBER} <br>Branch Name :${BRANCH_NAME} <br>Build Result : ${currentBuild.currentResult} <br> Check console output at ${BUILD_URL} to view the results.",
        		mimeType: 'text/html',
        		subject: "[Jenkins] :: BUILD ABORTED :: ${currentBuild.fullDisplayName}",
			from:"${SENDER_EMAILS}",
        		to: "${RECIPIENT_EMAIL}",
        		replyTo: ''
        		//recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         	}
		//always {
			//cleanWs()	
		//}
        }
		
}


