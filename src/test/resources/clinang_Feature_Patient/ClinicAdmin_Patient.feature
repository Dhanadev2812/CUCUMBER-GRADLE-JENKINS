@Clinic_patient
Feature: Feature to done patient functionaity

  Background: User is Logged In
    Given I open the app
    And Move to admin login page
    When Enter clinic admin credentials
      | UserName              | Password    |
      | watts@clinicadmin.com | Password12# |
    And Click on Login button
    Then Check i am logged in as a clinic admin
    And Click on patient module

  @CreatePatient
  Scenario: Create new patients
    And Click on create patient button
    When Enter the new patient details
      | firstName | lastName | email                | password    |
      | Kiran     | Rao      | kiran.rt@patient.com | Password12# |
    Then Check the register button is in enable state
    And Click on register option
    Then Check the validation message for new patient creation

  @CreatePatient-Mandatory
  Scenario: Create new patients without mandatory inputs
    And Click on create patient button
    When Skip the mandatory inputs
    Then Check the register button is in disable state
    Then Check the validation message for patient mandatory fields

  @CreatePatient-invalidinputs
  Scenario: Create new patients with invalid inputs
    And Click on create patient button
    When Enter invalid inputs
      | firstName | lastName | email | password |
      |         1 |        1 | kiran | Password |
    Then Check the register button is in disable state
    Then Check the validation message for invalid patient details
    
    @Patientdetails
    Scenario: Verify patient details
    When get the patient details from "src\test\resources\ClinicAdmin_TestData\Watts Health Center\Patient-details.xlsx"
    #Then Verify patient personal details
    #Then Verify medical history details
    Then Verify the appointment details on patient module	
