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

  #Use Online Consultation/Clinic Visit
  #For zoneid ref knowhow package
  @BookAppointment-Create
  Scenario: Create new appointment-Today
    When Enter the appointment details
      | mobile     | appointment_type | speciality   | doctor        | chief_complaint     |
      | 9090909090 | Clinic Visit     | Cardiologist | Dr. gilbret S | General appointment |
    Then Check wheather the appointment date-"11/09/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    And Select the appointment date "12/9/2020"
    Then Check the slot time is 2hrs>current time,if the appointment booked on today date and check the slot availability
    And Select the slot "7:00 PM"
    Then Check the paynow option is enabled or not
    And Check the consultation fee "20000" and then Click on paynow
