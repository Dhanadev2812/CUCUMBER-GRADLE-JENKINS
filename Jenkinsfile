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
             		echo 'This will run only if successful' 
			def BodyTemplate = ("<body>
  						<h3>Using "build" environment variables:</h3>
 						 <p>
   						 <a href="<%= build.absoluteUrl %>"><%= build.fullDisplayName %></a>
  						</p>
  						<h3>List of all available "build" environment variables:</h3>
  						<div>
    						<% println build.properties.collect{it}.join('<br />') %>
  						</div>
						</body>")
			emailext body: "Run ${JOB_NAME}-#${BUILD_NUMBER} succeeded. ${BodyTemplate} \n" + "To get more details, visit the build results page: ${BUILD_URL}.",
        		mimeType: 'text/html',
        		subject: "SUCCESS :: [Jenkins] ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: '',
        		recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         }
		failure {  
             		echo 'This will run only if failed' 
			emailext body: "Run ${JOB_NAME}-#${BUILD_NUMBER} failed . To get more details, visit the build results page: ${BUILD_URL}.",
        		mimeType: 'text/html',
        		subject: "FAILED :: [Jenkins] ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: '',
        		recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         }
		unstable {  
             		echo 'This will run only if unstable' 
			emailext body: "Run ${JOB_NAME}-#${BUILD_NUMBER} unstable. To get more details, visit the build results page: ${BUILD_URL}.",
        		mimeType: 'text/html',
        		subject: "UNSTABLE :: [Jenkins] ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: '',
        		recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         }
               aborted {  
             		echo 'This will run only if aborted' 
			emailext body: "Run ${JOB_NAME}-#${BUILD_NUMBER} aborted. To get more details, visit the build results page: ${BUILD_URL}.",
        		mimeType: 'text/html',
        		subject: "ABORTED :: [Jenkins] ${currentBuild.fullDisplayName}",
			from:'sandhiya.2894@gmail.com',
        		to: "dhanadev728@gmail.com",
        		replyTo: '',
        		recipientProviders: [[$class: 'CulpritsRecipientProvider']]
         }
	}

}
