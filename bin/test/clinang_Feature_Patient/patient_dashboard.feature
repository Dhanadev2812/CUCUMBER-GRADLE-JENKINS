@Patientdashboard
Feature: Feature to done dashboard functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | will@patient.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in
    And Click on edit profile option
    
#Ref Patient-Inputs text file before edit
  @Editprofile-valid
  Scenario: Update profile with valid details
    And Upload the image from "src\test\resources\Patient_TestData\Will Amster\Profile_img\men.jpg"
    When Enter mobile_number,address,street,city,state,country and pincode
      | mobile_number | address                   | street          | city    | state     | country | pincode |
      |    0909090909 | 191,Crown city appartment | Aruthnar street | Chennai | Tamilnadu | USA     |  666777 |
    And Click on "save"
    Then Check validation message for successful update
    And Move to dashboard
    Then Check the profile details updated on dashboard

  @Editprofile-Null-Check_mandatory
  Scenario: Update profile with null details
    Then Clear all existing details
    Then Check the validation message for mandatory fields
    Then Check the save button is disabled or not
    And Click on "cancel"
    And Move to dashboard

  @Editprofile-Invaliddatas
  Scenario: Update profile with invalid details
    When Enter invalid mobile number
      | mobile_number | address                   | street          | city    | state     | country | pincode |
      |           678 | 190,Crown city appartment | Aruthnar street | Chennai | Tamilnadu | USA     |  666777 |
    Then Check the validation message for invalid data
    Then Check the save button is disabled or not
    And Click on "cancel"
    And Move to dashboard
