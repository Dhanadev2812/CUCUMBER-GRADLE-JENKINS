pipeline {
  agent any 
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
           	 		cucumber buildStatus:"UNSTABLE",
			 	fileIncludePattern: "Report/JenkinsReport/cucumberReports.html",
			 	jsonReportDirectory:'Report/JenkinsReport/cucumberReports/cucumber.json' 
            }
           }
		stage("Deploy") {
        		steps {
          			echo 'Deploy'
          		}
		}
         }

}
