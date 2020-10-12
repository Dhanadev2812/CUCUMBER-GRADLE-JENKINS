@loginfunction
Feature: Feature to done login process

  @login_valid
  Scenario: Login with valid credentials
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in
    And click on logout button

  @login_invalidEmail_invalidPassword
  Scenario: Login with invalid email id/Password
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password112# | LAT002      |
    And click on login button
    But It display Username or Password is Wrong alert message
    
    @login_invalid_clinic_code
  Scenario: Login with invalid email id/Password
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT012      |
    And click on login button
    But It display Clinic code is invalid alert message
