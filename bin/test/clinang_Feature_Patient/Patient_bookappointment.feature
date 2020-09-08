@Bookappointment
Feature: Feature to check book appointment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | wilson@gmail.com | Password12# | LAT004      |
    And click on login button
    Then Check i am logged in

  @BookAppointment-Create
  Scenario: Create new appointment-Today
    When Go to book appointment screen
    And Enter the appointment details
      | mobile     | appointment_type | speciality   | doctor        | date_of_appointment | timeslot | chief_complaint    |
      | 9090909090 | Clinic Visit     | Cardiologist | Dr. gilbret S | 11/9/2020           | 9:00AM   | online appointment |
