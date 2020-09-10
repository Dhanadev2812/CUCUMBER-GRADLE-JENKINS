@Bookappointment
Feature: Feature to check book appointment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | wilson@gmail.com | Password12# | LAT004      |
    And click on login button
    Then Check i am logged in
    And Go to book appointment screen

  @BookAppointment-Create
  Scenario: Create new appointment-Today
    When Enter the appointment details
      | mobile     | appointment_type | speciality   | doctor        | chief_complaint    |
      | 9090909090 | Clinic Visit     | Cardiologist | Dr. gilbret S | General appointment |
    Then Check wheather the appointment date-"11/09/2020" is a past date or not,Based on zoneid "America/New_York"
    And  Select the appointment date "11/9/2020"
    Then Check the slot time is 2hrs>current time,if the current date is equal to the given date
