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
        		steps {
          			echo 'Started Stage one : Unit & Integration Tests ..'
          			bat 'gradle cucumber -Dcucumber.options="--tags @login_valid and --tags @Clinicadmin'
          		}
		}
        	stage("Generate Cucumber report") {
          		steps {
		 		echo 'Generating Cucumber report..'                             
                           	cucumber fileIncludePattern: '**/JenkinsReport/cucumber.json', buildStatus: 'FAILURE'
            }
           }
		stage("Deploy") {
        		steps {
          			echo 'Deploy'
          		}
		}
         }
}
