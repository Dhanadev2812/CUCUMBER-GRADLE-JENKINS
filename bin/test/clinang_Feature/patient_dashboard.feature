
@Dashboard
Feature: Dashboard Functionality

  @Editprofile-valid
  Scenario: Update profile with valid details
    Given I open the app
    When I login to the app
		And Click on edit profile option
		Then Enter profile details
		  