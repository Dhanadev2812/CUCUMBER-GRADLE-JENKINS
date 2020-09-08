@Medicalhistory
Feature: Feature to check medical history functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | wilson@gmail.com | Password12# | LAT004      |
    And click on login button
    Then Check i am logged in

  @Medicalhistory-Add-Valid
  Scenario: Add medical history with valid details
    Then Go to medical history
    And Enter the medical history details
      | Gender | Blood_group | DOB        | Age | Weight | Height | Allergies    | Medical_history                                                                                                                                                                                                                                   |
      | Female | A+          | 28/12/1994 |  22 |     54 |    155 | Dust allergy | As an expecting mother, I was adamant in my view that the body can heal itself without any kind of medical intervention. I was stubborn that my pregnancy should be of the same path. I am a sportsperson since my childhood and active even now. |
    Then Click "save"
    Then Check validation message for successful medical history add
    Then Check the added details updated on patient dashboard

  @Medicalhistory-Add_Invalid
  Scenario: Invalid alert message on edit medical history screen
    Then Go to medical history
    And Enter invalid details
      | Weight | Height |
      | h      | w      |
    Then Click "update"
    Then Check the validation message for invalid details

  @Medicalhistory-Add_Mandatory
  Scenario: Mandatory message on add medical history screen
    Then Go to medical history
    And Clear the mandatory fields
    Then Check the validation message for medical history mandatory fields

  @Medicalhistory-Add_Allergy&medicalhistory_Mandatory
  Scenario: Mandatory message on add medical history screen for allergy and medical history
    Then Go to medical history
    And Enter the details except allergy and medical history
      | Gender | Blood_group | DOB        | Age | Weight | Height |
      | Male   | A1B+        | 28/12/1994 |  24 |     56 |    155 |
    Then Click "save"
    Then Check the validation message on allergy and medical history field

  @Medicalhistory-Edit-valid
  Scenario: Update medical history with valid details
    Then Go to medical history
    And Enter the medical history details
      | Gender | Blood_group | DOB        | Age | Weight | Height | Allergies    | Medical_history                                                                                                                                                                                                                                   |
      | Male   | B+          | 28/12/1994 |  27 |     56 |    155 | Dust allergy | As an expecting mother, I was adamant in my view that the body can heal itself without any kind of medical intervention. I was stubborn that my pregnancy should be of the same path. I am a sportsperson since my childhood and active even now. |
    Then Click "update"
    Then Check validation message for successful medical history update
    Then Check the added details updated on patient dashboard

  @Medicalhistory-Edit_Invalid
  Scenario: Invalid alert message on edit medical history screen
    Then Go to medical history
    And Enter invalid details
      | Weight | Height |
      | h      | w      |
    Then Click "save"
    Then Check the validation message for invalid details on add

  @Medicalhistory-Edit_Mandatory
  Scenario: Mandatory message on edit medical history screen
    Then Go to medical history
    And Clear the mandatory fields on edit screen
    Then Click "update"
    Then Check the validation message for medical history mandatory fields on edit

  @Edit_allergy_medicalHistory_Mandatory
  Scenario: Mandatory message on edit medical history screen for allergy and medical history
    Then Go to medical history
    And Clear only allergy and medicalhistory details
    Then Click "update"
    Then Check the validation message on allergy and medical history field

  @Medicalhistory-Cancel
  Scenario: Cancel medical history form
    Then Go to medical history
    Then Click "cancel"
