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
        //node('node1'){
		echo "Test succeeded"
            script {
		    def mailFrom ="sandhiya.2894@gmail.com"
                   def mailRecipients = "dhanadev728@gmail.com"
    		  def jobName = currentBuild.fullDisplayName
			
		    from: "${mailFrom}",
   		 emailext body: '''${SCRIPT, template="groovy-html.template"}''',
        		mimeType: 'text/html',
        subject: "[Jenkins] ${jobName}",
        to: "${mailRecipients}",
        replyTo: "${mailRecipients}",
        recipientProviders: [[$class: 'CulpritsRecipientProvider']]
                	}
             	}
  
	failure {
            echo "Test failed"
            mail(bcc: '',
                body: "Run ${JOB_NAME}-#${BUILD_NUMBER} failed. To get more details, visit the build results page: ${BUILD_URL}.",
                 cc: '',
                 from: 'sandhiya.2894@gmail.com',
                 replyTo: '',
                 subject: "TEST FAILED :: ${JOB_NAME} ${BUILD_NUMBER}",
                 to: 'dhanadev728@gmail.com')
                         }
	unstable  {
            echo "Test Unstable"
            mail(bcc: '',
                body: "Run ${JOB_NAME}-#${BUILD_NUMBER} unstable. To get more details, visit the build results page: ${BUILD_URL}.",
                 cc: '',
                 from: 'sandhiya.2894@gmail.com',
                 replyTo: '',
                 subject: "$TEST UNSTABLE :: {JOB_NAME} ${BUILD_NUMBER}",
                 to: 'dhanadev728@gmail.com')
                         }
	}

}
