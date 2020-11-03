@Clinic_doctor
Feature: Feature to validate and create new doctor

  Background: User is Logged In
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName              | Password    |
      | watts@clinicadmin.com | Password12# |
    And Click on Login button
    Then Check i am logged in as a clinic admin

  @createdoctor
  Scenario: Create new doctor
    And Go to doctor module
    And Click on create doctor
    When Enter doctor details
      | FirstName | LastName | EmailID             | Speciality   | DomesticConsultingFee | OverseasConsultingFee | DomesticFollowupFee | OverseasFollowupFee | Password    |
      | Richard   | Kims     | richard15@doctor.com | Cardiologist |                  1000 |                  2000 |                 500 |                1000 | Password12# |
    And Submit the form
    Then Verify the success message for doctor registration
    Then Validate the new doctor details on doctor without profile screen
