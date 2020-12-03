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
	}
	post {
        success {
        //node('node1'){
		echo "Test succeeded"
            script {
    // configured from using gmail smtp Manage Jenkins-> Configure System -> Email Notification
    // SMTP server: smtp.gmail.com
    // Advanced: Gmail user and pass, use SSL and SMTP Port 465
    // Capitalized variables are Jenkins variables – see https://wiki.jenkins.io/display/JENKINS/Building+a+software+project
                mail(bcc: '',
                     body: "Run ${JOB_NAME}-#${BUILD_NUMBER} succeeded. To get more details, visit the build results page: ${BUILD_URL}.",
                     //cc: '',
                     from: 'sandhiya.2894@gmail.com',
                     //replyTo: 'dhanadev728@gmail.com',
                     subject: "${JOB_NAME} ${BUILD_NUMBER} succeeded",
                     to: 'dhanadev728@gmail.com')
                     if (env.archive_war =='yes')
                     {
             // ArchiveArtifact plugin
                        archiveArtifacts '**/java-calculator-*-SNAPSHOT.jar'
                      }
                       // Cucumber report plugin
                      cucumber fileIncludePattern: '**/java-calculator/target/cucumber-report.json', sortingMethod: 'ALPHABETICAL'
            //publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: '/home/reports', reportFiles: 'reports.html', reportName: 'Performance Test Report', reportTitles: ''])
            }
        //}
        }
}
}
