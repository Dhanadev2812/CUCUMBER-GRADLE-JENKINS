pipeline {
  agent any 
    stages {
    stage("build") {
      steps {
        echo 'building the application'  
        }
    }
	stage("Unit & Integration Tests") {
        steps {
          echo 'testing the application..'
          bat 'gradlew cucumber --no-daemon' //run a gradle task
          }

	}
        stage("deploy") {
          steps {
            echo 'deploying the application..'
            }
           }
         }
}
