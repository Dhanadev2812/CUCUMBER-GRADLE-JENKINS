@loginfunction @patient @smokeTest
Feature: Feature to test login functionality

  Background: User is Logged In
    Given I open the app

  @login_valid @patient @smokeTest
  Scenario: Login as a patient with valid credentials
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in

  @login_invalidEmail_invalidPassword @patient @smokeTest
  Scenario: Login as a patient with invalid email id/Password
    When Enter the email,password and clinic code
      | email                   | password     | clinic_code |
      | sandhiya.2894@gmail.com | Password112# | LAT002      |
    And click on login button
    But It display Username or Password is Wrong alert message

  @login_invalid_clinic_code @patient @smokeTest
  Scenario: Login as a patient with invalid email id/Password
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT012      |
    And click on login button
    But It display Clinic code is invalid alert message
