
@Bookappointment
Feature: Feature to check book appointment functionaity

  @Bookappointment-valid
  Scenario: Book new appointment with vaalid details
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | anusri@gmail.com | Password12# | UCLA01      |
    And click on login button
    Then Check i am logged in

  