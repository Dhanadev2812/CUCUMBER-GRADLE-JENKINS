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
             		echo 'This will run only if successful' 
			emailext body: '''${SCRIPT, template="emailTemp.template"}''',
        		mimeType: 'text/html',
        		subject: "[Jenkins] ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: '',
        		recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         }
               
    
	}

}
