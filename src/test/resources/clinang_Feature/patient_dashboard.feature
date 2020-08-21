@Patientdashboard
Feature: Feature to done dashboard functionaity

  @Editprofile-valid
  Scenario: Update profile with valid details
    Given I open the app
    When Enter the email,password and clinic code
      | email           | password    | clinic_code |
      | banu@latlon.com | Password12# | ABC025      |
    And click on login button
    Then Check i am logged in
    And Click on edit profile option
    And Enter mobile_number,address,street,city,state,country and pincode
      | mobile_number | address                   | street          | city    | state     | country | pincode |
      |    0909090909 | 190,Crown city appartment | Aruthnar street | Chennai | Tamilnadu | USA   |  666777 |
    Then Click on "save"
    Then check the data stored on DB
