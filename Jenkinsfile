pipeline {
  agent any 
	stages {
		stage("Unit & Integration Tests") {
        		steps {
          			echo 'Started Stage one : Unit & Integration Tests ..'
          			bat 'gradle cucumber -Dcucumber.options="--tags @login_valid and --tags @Clinicadmin'
          		}
		}
        	stage("Generate Cucumber report") {
          		steps {
		 		echo 'Generating Cucumber report..'  
           	 		cucumber buildStatus:"UNSTABLE",
			 	fileIncludePattern: "**/cucumber.json",
			 	jsonReportDirectory:'target'
            }
           }
         }

}
