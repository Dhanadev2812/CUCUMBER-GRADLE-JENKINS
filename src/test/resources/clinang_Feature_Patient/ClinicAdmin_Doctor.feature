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
    And Go to doctor module

  @createdoctor
  Scenario: Create new doctor
    And Click on create doctor
    When Enter doctor details
      | FirstName | LastName | EmailID             | Speciality   | DomesticConsultingFee | OverseasConsultingFee | DomesticFollowupFee | OverseasFollowupFee | Password    |
      | Sara      | Sri      | sarasri6@doctor.com | Cardiologist |                  1000 |                  2000 |                 500 |                1000 | Password12# |
    And Submit the form
    Then Verify the success message for doctor registration
    Then Validate the new doctor details on doctor without profile screen

  @createdoctor-invalid
  Scenario: Create new doctor with invalid details
    And Click on create doctor
    When Enter doctor details
      | FirstName | LastName | EmailID  | Speciality   | DomesticConsultingFee | OverseasConsultingFee | DomesticFollowupFee | OverseasFollowupFee | Password |
      |         1 |        1 | sarasri3 | Cardiologist | test                  |                     0 |                   0 |                 1.1 | 123#     |
    Then Validate the validation message for invalid details
    
   @createdoctor-mandatory
   Scenario: Create new doctor without the mandatory details
   And Click on create doctor
   When Skip to enter the mandatory details
   Then Validate the mandatory alert message on doctor registration form
   
   @verifyDoctordetails
   Scenario: Verify doctor details
   When Get the doctor details from "src\test\resources\ClinicAdmin_TestData\Watts Health Center\Doctor-details.xlsx"
   Then Verify doctor details on list page
   Then Verify the appointment details on doctor module
   Then Verify doctor personal details on view profile
   Then Verify medical report details on doctor module
   Then Verify my treatment details on doctor module
   
   @Updatefees-valid
   Scenario: Update doctor fee details
   When Get the doctor details from "src\test\resources\ClinicAdmin_TestData\Watts Health Center\Doctor-details.xlsx"
   When Update the doctor fee details
   Then Check the success message for fee update process
   Then Validate the updated details on payment edit screen
   
   @UpdateFee-invalid
   Scenario: Update invalid doctor fee details
   When Get the doctor details from "src\test\resources\ClinicAdmin_TestData\Watts Health Center\Doctor-details.xlsx"
   When Update the payment details with invalid inputs
   Then Validate the validation message for invalid inputs
   
   
