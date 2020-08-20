@loginfunction
Feature: Login, logout the app

  @login_valid
  Scenario: Login with valid credentials
    Given I open the app
    When Enter the email,password and clinic code
      | email           | password    | clinic_code |
      | banu@latlon.com | Password12# | ABC025      |
    And click on login button
    Then Check i am logged in
    Then click on logout button

  @login_invalidEmail
  Scenario: Login with invalid email id
    Given I open the app
    When Enter the email,password and clinic code
      | email | password    | clinic_code |
      | banu  | Password12# | ABC025      |
    And click on login button
    Then Check validation message for invalid email