@Invoice @Clinicadmin
Feature: Feature to validate invoice details

  Background: User is Logged In
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName              | Password    |
      | watts@clinicadmin.com | Password12# |
    And Click on Login button
    Then Check i am logged in as a clinic admin
    Then Verify if the table is empty
    
    @Validateinvoice @Clinicadmin
    Scenario: Validate invoice details
    And Go to invoice module
    When Get the invoice details from "src\test\resources\ClinicAdmin_TestData\Watts Health Center\Patient-details.xlsx"
    Then Validate and download invoice details
    