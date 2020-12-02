pipeline {
  agent {
        label {
            label ""
            customWorkspace "D:/work/${BRANCH_NAME}"
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
			// post {
                	//always {
                    	//junit(testResults: '**/surefire-reports/*.xml', allowEmptyResults: true)
                    	//junit(testResults: '**/failsafe-reports/*.xml', allowEmptyResults: true)
                //}
            //}
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
        	stage("Generate Cucumber report") {
			when {
                		branch 'dhana'
            		}
          		steps {
		 		echo 'Generating Cucumber report..'          
				//cucumber 'glob'
				cucumber fileIncludePattern:"Report/JunitRepot/cucumberReports/cucumber.json",
                    		jsonReportDirectory:'Report/JunitRepot/cucumberReports/cucumber.json',
				buildStatus: 'FAILURE'
            }
           }
		stage("Deploy") {
        		steps {
          			echo 'Deploy'
          		}
		}
         }
}
