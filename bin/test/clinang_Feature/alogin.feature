@sanitytest @loginfun
Feature: Login, logout the app

@alogin
  Scenario: Login into the app
    Given I open the app
    When I login to the app  
	  Then close the browser
