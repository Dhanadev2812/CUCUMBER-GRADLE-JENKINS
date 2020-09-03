@patientregister
Feature: Feature to done patient registration

  @register-valid
  Scenario: Register with valid details
    Given I open the app
    When Click on registration link
    Then Enter firstname,lastname,email and password
      | firstname | lastname | email          | password    |
      | Arun      | Kumar    | sr1w@gmail.com | Password12# |
    And Click on register button
    Then Check the validation message for success registration

  @register-existingdetails
  Scenario: Register with existing details
    Given I open the app
    When Click on registration link
    Then Enter firstname,lastname,email and password
      | firstname | lastname | email        | password    |
      | Arun      | Kumar    | sr@gmail.com | Password12# |
    And Click on register button
    Then Check the validation message for existing details

  @register-invaliddetails
  Scenario: Register with invalid details
    Given I open the app
    When Click on registration link
    Then Enter firstname,lastname,email and password
      | firstname | lastname | email   | password    |
      |        12 |      123 | arun211 | password12# |
    And Click on register button
    Then Check validation message for invalid details
    
    
    
