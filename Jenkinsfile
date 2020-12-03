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
				bat "del index.html"
               			zip zipFile: 'index.html', archive: false, dir:"D:/Software/jenkins/Myworkspace/Branches/${BRANCH_NAME}/Report/JenkinsReport/HTML"
          		}
		}
	}
	post {
        success {
               emailext attachmentsPattern: 'index.html', body: '''${SCRIPT, template="groovy-html.template"}''', 
                    subject: "${env.JOB_NAME} - Build # ${env.BUILD_NUMBER} - Successful", 
                    mimeType: 'text/html',to: "email id"
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
