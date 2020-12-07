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
		 		echo 'Publishing Cucumber report..'          	
				cucumber fileIncludePattern:'**/cucumber.json', 
				jsonReportDirectory:'Report/JenkinsReport/JSON',
				sortingMethod: 'ALPHABETICAL',
				reportTitle: 'cucumber',
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
			emailext attachmentsPattern:'**/overview-features.html',
			body: "<b>Build Status Report</b> <br>Job name : Job ${JOB_NAME} <br>Build No : build ${BUILD_NUMBER} <br>Branch Name :${BRANCH_NAME} <br>Build Result : ${currentBuild.currentResult} <br> Console output : ${BUILD_URL} <br> Log File : ${BUILD_LOG}",
        		mimeType: 'text/html',
        		subject: "[Jenkins] :: BUILD SUCCESS :: ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: ''
        		//recipientProviders: [developers(), requestor()]
   
         	}
		failure {  
             		echo 'This will run only if failure' 
			emailext body: "<b>Build Status Report</b> <br>Job name : Job ${JOB_NAME} <br>Build No : build ${BUILD_NUMBER} <br>Branch Name :${BRANCH_NAME} <br>Build Result : ${currentBuild.currentResult} <br> Console output : ${BUILD_URL}",
        		mimeType: 'text/html',
        		subject: "[Jenkins] :: BUILD FAILURE :: ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: ''
        		//recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         }
		unstable {  
             		echo 'This will run only if unstable' 
			emailext body: "<b>Build Status Report</b> <br>Job name : Job ${JOB_NAME} <br>Build No : build ${BUILD_NUMBER} <br>Branch Name :${BRANCH_NAME} <br>Build Result : ${currentBuild.currentResult} <br> Console output : ${BUILD_URL}",
        		mimeType: 'text/html',
        		subject: "[Jenkins] :: BUILD UNSTABLE :: ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: ''
        		//recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         }
               aborted {  
             		echo 'This will run only if aborted' 
			emailext body: "<b>Build Status Report</b> <br>Job name : Job ${JOB_NAME} <br>Build No : build ${BUILD_NUMBER} <br>Branch Name :${BRANCH_NAME} <br>Build Result : ${currentBuild.currentResult} <br> Console output : ${BUILD_URL}",
        		mimeType: 'text/html',
        		subject: "[Jenkins] :: BUILD ABORTED :: ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: ''
        		//recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         	}
		//always {
			//cleanWs()	
		//}
        }
		
}


