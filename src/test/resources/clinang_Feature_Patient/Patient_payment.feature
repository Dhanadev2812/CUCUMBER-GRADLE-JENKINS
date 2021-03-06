@Payment
Feature: Feature to check payment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | wilson@patient.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in
    And Go to payment screen

  @Payment-Downloadinvoice @patient @smokeTest
  Scenario: Check payment for appointment
    And Click on "appointment" tab
    And Find the payment list based on appointment ID "70"
    Then Download the invoice