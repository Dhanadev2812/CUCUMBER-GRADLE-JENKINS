@loginfunction
Feature: Feature to done login process

  @login_valid
  Scenario: Login with valid credentials
    Given I open the app
    When Enter the email,password and clinic code
      | email           | password    | clinic_code |
      | banu@latlon.com | Password12# | ABC025      |
    And click on login button
    Then Check i am logged in
    And click on logout button

  @login_invalidEmail
  Scenario: Login with invalid email id
    Given I open the app
    When Enter the email,password and clinic code
      | email | password    | clinic_code |
      | banu  | Password12# | ABC025      |
    And click on login button
    But It display invalid email alert message