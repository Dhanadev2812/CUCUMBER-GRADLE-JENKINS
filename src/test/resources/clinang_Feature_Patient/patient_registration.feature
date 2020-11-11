@patientregister
Feature: Feature to done patient registration

  @Register-valid @patient @smokeTest
  Scenario: Register with valid details
    Given I open the app
    When Click on registration link
    Then Enter firstname,lastname,email and password
      | firstname | lastname | email          | password    |
      | Arun      | Kumar    | arun123@test.com | Password12# |
    And Click on register button
    Then Check the validation message for success registration

  @Register-existingdetails @patient @smokeTest
  Scenario: Register with existing details
    Given I open the app
    When Click on registration link
    Then Enter firstname,lastname,email and password
      | firstname | lastname | email        | password    |
      | Arun      | Kumar    | arun123@test.com | Password12# |
    And Click on register button
    Then Check the validation message for existing details

  @Register-invaliddetails @patient @smokeTest
  Scenario: Register with invalid details
    Given I open the app
    When Click on registration link
    Then Enter firstname,lastname,email and password
      | firstname | lastname | email   | password    |
      |        12 |      123 | arun211 | password12# |
    And Click on register button
    Then Check validation message for invalid details
    
    
    
