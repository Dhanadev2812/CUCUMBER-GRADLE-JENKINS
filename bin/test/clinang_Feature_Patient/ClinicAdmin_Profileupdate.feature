@ClinicUpdate @Clinicadmin @smokeTest
Feature: Feature to done clinic update functionaity

  Background: User is Logged In
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName              | Password    |
      | watts@clinicadmin.com | Password12# |
    And Click on Login button
    Then Check i am logged in as a clinic admin
    And Go to clinic admin module

  @Clincupdate-valid @Clinicadmin @smokeTest
  Scenario: Update clinic details 
    And Click on edit option
    And Upload the clinic logo from "src/test/resources/ClinicAdmin_TestData/Watts Health Center/Clinic-Logo.png"
    When Enter clinic details
      | ClinicName    | ClinicAddress | ClinicStreet | ClinicCity | ClinicState | ClinicCountry | ClinicPincode | ClinicEmail   | ClinicPhone |
      | Health Center | 22/300        | Sajra street | Bangalore  | Karnadaka   | India         |        555666 | hc@clinic.com |  8989898989 |
    And Submit the clinic updates
    Then Validation clinic update message
    Then Validate the updated clinic name on grid
    
   @Clinicupdate-mandatory @Clinicadmin @smokeTest
   Scenario: Check the mandatory fields
    And Click on edit option
    When Remove the inputs from mandatory fields
    And Submit the clinic updates
    But It display the alerts for mandatory fields
    
    @Clinicupdate-Invalidemail @Clinicadmin @smokeTest
    Scenario: Check the mandatory fields
    And Click on edit option
    When enter invalid email "@test.com"
    And Submit the clinic updates
    But It display invalid email alert
  
