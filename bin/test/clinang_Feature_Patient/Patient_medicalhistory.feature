@Medicalhistory
Feature: Feature to check medical history functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in
    And Go to medical history

  #Ref Patient-Inputs text file before edit
  @Medicalhistory-Add-Valid @patient-smokeTest
  Scenario: Add medical history with valid details
    When Enter the medical history details
      | Gender | Blood_group | DOB        | Age | Weight | Height | Allergies    | Medical_history                                                                                                                                                                                                                                   |
      | Female | A+          | 28/12/1994 |  22 |     54 |    155 | Dust allergy | As an expecting mother, I was adamant in my view that the body can heal itself without any kind of medical intervention. I was stubborn that my pregnancy should be of the same path. I am a sportsperson since my childhood and active even now. |
    And Click "save"
    Then Check validation message for successful medical history add
    Then Check the added details updated on patient dashboard

  @Medicalhistory-Add_Invalid @patient-smokeTest
  Scenario: Invalid alert message on edit medical history screen
    When Enter invalid details
      | Weight | Height |
      | h      | w      |
    And Click "save"
    But It display alert message - Weight and height must be number

  @Medicalhistory-Add_Mandatory @patient-smokeTest
  Scenario: Mandatory message on add medical history screen
    And Clear the mandatory fields
    And Click "save"
    Then Check the validation message for medical history mandatory fields

  @Medicalhistory-Add_Allergy&medicalhistory_Mandatory @patient-smokeTest
  Scenario: Mandatory message on add medical history screen for allergy and medical history
    When Enter the details except allergy and medical history
      | Gender | Blood_group | DOB        | Age | Weight | Height |
      | Male   | AB+         | 28/12/1994 |  24 |     56 |    155 |
    And Click "save"
    Then Check the validation message on allergy and medical history field

  @Medicalhistory-Edit-valid @patient-smokeTest
  Scenario: Update medical history with valid details
    When Enter the medical history details
      | Gender | Blood_group | DOB        | Age | Weight | Height | Allergies    | Medical_history                                                                                                                                                                                                                                   |
      | Male   | B+          | 28/12/1994 |  27 |     56 |    155 | Dust allergy | As an expecting mother, I was adamant in my view that the body can heal itself without any kind of medical intervention. I was stubborn that my pregnancy should be of the same path. I am a sportsperson since my childhood and active even now. |
    And Click "update"
    Then Check validation message for successful medical history update
    Then Check the added details updated on patient dashboard

  @Medicalhistory-Edit_Invalid @patient-smokeTest
  Scenario: Invalid alert message on edit medical history screen
    When Enter invalid details
      | Weight | Height |
      | h      | w      |
    And Click "update"
    But It display alert message - Weight and height must be number

  @Medicalhistory-Edit_Mandatory @patient-smokeTest
  Scenario: Mandatory message on edit medical history screen
    And Clear the mandatory fields on edit screen
    And Click "update"
    Then Check the validation message for medical history mandatory fields on edit

  @Edit_allergy_medicalHistory_Mandatory @patient-smokeTest
  Scenario: Mandatory message on edit medical history screen for allergy and medical history
    And Clear only allergy and medicalhistory details
    And Click "update"
    Then Check the validation message on allergy and medical history field

  @Medicalhistory-Cancel
  Scenario: Cancel medical history form
    And Click "cancel"
