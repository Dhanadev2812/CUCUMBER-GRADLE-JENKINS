pipeline {
  agent {
        label {
            label ""
            customWorkspace "D:/work/${BRANCH_NAME}"
        }
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
        	stage("Generate Cucumber report") {
			when {
                		branch 'dhana'
            		}
          		steps {
		 		echo 'Generating Cucumber report..'          
				//cucumber 'glob'
				fileIncludePattern: "**/cucumber.json",
                    		jsonReportDirectory: 'target',
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
