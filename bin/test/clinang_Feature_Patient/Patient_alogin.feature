@patient:loginfunction
Feature: Feature to test login process

  @patient:login_valid @patient-smokeTest
  Scenario: Login with valid credentials
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in
    And click on logout button

  @patient:login_invalidEmail_invalidPassword @patient-smokeTest
  Scenario: Login with invalid email id/Password
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password112# | LAT002      |
    And click on login button
    But It display Username or Password is Wrong alert message
    
    @patient:login_invalid_clinic_code @patient-smokeTest
  Scenario: Login with invalid email id/Password
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT012      |
    And click on login button
    But It display Clinic code is invalid alert message
