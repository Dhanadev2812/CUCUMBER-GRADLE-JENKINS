@Appointment
Feature: Feature to appointment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | will@patient.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in
    
    @Add_medicalreport
  	Scenario: Reschedule the appointment
    And Go to appointment module
    And Move to appointment list page based on appointment date "25/9/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "203"
    When Reschedule the appointment to "26/9/2020" "11:00 AM" with complaint "general appointment"
    Then Check validation message
    
    