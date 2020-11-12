@Clinic_appointment @Clinicadmin @smokeTest
Feature: Feature to validate appointment details on appointment module

  Background: User is Logged In
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName              | Password    |
      | watts@clinicadmin.com | Password12# |
    And Click on Login button
    Then Check i am logged in as a clinic admin
    And Click on appointment module
    
    @ValidateAppointment @Clinicadmin @smokeTest
    Scenario: Validate appointment details
    When Get the details from "src\test\resources\ClinicAdmin_TestData\Watts Health Center\Patient-details.xlsx"
    Then Validate the appointment details
    Then Check the total appointment count with dashboard
    
    @Validatemedicalreport @Clinicadmin @smokeTest
    Scenario: Validate and download medical report details
    When Get the details from "src\test\resources\ClinicAdmin_TestData\Watts Health Center\Patient-details.xlsx"
    Then Validate and download the medical report details on appointment module