@Patientdashboard
Feature: Feature to done dashboard functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | wilson@gmail.com | Password12# | LAT004      |
    And click on login button
    Then Check i am logged in

  @Editprofile-valid
  Scenario: Update profile with valid details
    And Click on edit profile option
    Then Upload the image from "D://Testing workspace//ClinaNG//Profile_img//women.jpg"
    And Enter mobile_number,address,street,city,state,country and pincode
      | mobile_number | address                   | street          | city    | state     | country | pincode |
      |    0909090909 | 191,Crown city appartment | Aruthnar street | Chennai | Tamilnadu | USA     |  666777 |
    Then Click on "save"
    Then Check validation message for successful update
    Then Move to dashboard
    And Check the profile details updated on dashboard

  @Editprofile-Null-Check_mandatory
  Scenario: Update profile with null details
    And Click on edit profile option
    Then Clear all existing details
    Then Check the validation message for mandatory fields
    Then Check the save button is disabled or not
    Then Click on "cancel"
    Then Move to dashboard

  @Editprofile-Invaliddatas
  Scenario: Update profile with invalid details
    And Click on edit profile option
    Then Enter invalid mobile number
      | mobile_number | address                   | street          | city    | state     | country | pincode |
      |           678 | 190,Crown city appartment | Aruthnar street | Chennai | Tamilnadu | USA     |  666777 |
    Then Check the validation message for invalid data
    Then Check the save button is disabled or not
    Then Click on "cancel"
    Then Move to dashboard
