@Appointment
Feature: Feature to appointment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | will@patient.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in

  @Reschedule
  Scenario: Reschedule the appointment
    And Go to appointment module
    When Move to appointment list page based on date "30/9/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "232"
    Then Check wheather the appointment date-"30/9/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    Then Check wheather the reschedule date-"29/9/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    When Reschedule the appointment to "29/9/2020"
    Then Check the slot time is 2hrs>current time,if the reschedule date "29/9/2020" is a current date also check the slot availability
    When Select slot  "8:00 PM" with complaint "general appointment"
    Then Check validation message
    Then Validate rescheduled appointment details
    Then Check the appointment count based on reschedule date "29/9/2020" and previous appointment date "30/9/2020"

  @Cancel
  Scenario: Cancel the appointment
    And Go to appointment module
    When Move to appointment list page based on date "7/10/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "236"
    Then Check wheather the appointment date-"7/10/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    And Cancel the appointment
    Then Check the validation message for cancellation process
    Then Check the appointment count based on cancelled appointment date "7/10/2020"

  @Add-Medicalreport
  Scenario: Add medical report
    And Go to appointment module
    When Move to appointment list page based on date "19/9/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "103"
    And Add medical report with description
      | src\\test\\resources\\Patient_TestData\\Will Amster\\Patient_medicalReport\\PDF.pdf     | Pdf-Medical report |
      | src\\test\\resources\\Patient_TestData\\Will Amster\\Patient_medicalReport\\JPG-1MB.jpg | Scean image        |
    Then Validate the uploaded medical reports
      | PDF.pdf     | Pdf-Medical report |
      | JPG-1MB.jpg | Scean image        |
