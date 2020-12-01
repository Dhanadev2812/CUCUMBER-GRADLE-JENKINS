pipeline {
  agent any 
	stage("Unit & Integration Tests") {
        steps {
          echo 'Started Stage one : Unit & Integration Tests ..'
          bat 'gradle cucumber'
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

