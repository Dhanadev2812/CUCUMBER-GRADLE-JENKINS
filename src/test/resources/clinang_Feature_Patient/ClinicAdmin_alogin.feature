@clinicadmin:loginfunction
Feature: Feature to done login process

  @clinicadmin:login_valid
  Scenario: Login with valid credentials
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName              | Password    |
      | watts@clinicadmin.com | Password12# |
    And Click on Login button
    Then Check i am logged in as a clinic admin
    And click on logout button

  @clinicadmin:login_invalid
  Scenario: Login with invalid credentials
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName               | Password    |
      | watts1@clinicadmin.com | Password12# |
    And Click on Login button
    But It display Username or Password is Wrong alert message
