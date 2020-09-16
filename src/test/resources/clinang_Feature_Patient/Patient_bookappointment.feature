@Bookappointment
Feature: Feature to check book appointment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email            | password    | clinic_code |
      | will@patient.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in
    And Get the patient country
    And Go to book appointment screen

  #Use Online Consultation/Clinic Visit
  #For zoneid ref knowhow package
  #payment method card/upi/netbanking/wallet/emi
  @BookAppointment-Create
  Scenario: Create new appointment-Today
    When Enter the appointment details
      | mobile     | appointment_type | speciality      | doctor            | chief_complaint     |
      | 9090909090 | Clinic Visit     | Physiotherapist | Dr. Eritriya Drud | General appointment |
    Then Check wheather the appointment date-"16/09/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    And Select the appointment date "16/9/2020"
    Then Check the slot time is 2hrs>current time,if the appointment booked on today date and check the slot availability
    And Select the slot "8:00 PM"
    Then Check the paynow option is enabled or not
    Then Check the fee details based on country
      | Domestic Consulting Fee | Overseas Consulting Fee |
      |                    1000 |                    2000 |
    And Click on paynow
    Then Done a payment process via "emi"
      | card |
      | test |
