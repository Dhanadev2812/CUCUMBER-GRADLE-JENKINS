@loginfunction @Clinicadmin @smokeTest
Feature: Feature to done login process

  @login_valid @Clinicadmin @smokeTest
  Scenario: Login with valid credentials
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName              | Password    |
      | watts@clinicadmin.com | Password12# |
    And Click on Login button
    Then Check i am logged in as a clinic admin

  @login_invalid @Clinicadmin @smokeTest
  Scenario: Login with invalid credentials
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName               | Password    |
      | watts1@clinicadmin.com | Password12# |
    And Click on Login button
    But It display Username or Password is Wrong alert message
