@patient:Bookappointment
Feature: Feature to check book appointment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email              | password    | clinic_code |
      | wilson@patient.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in
    And Get the patient country
    And Go to book appointment screen

  #Ref Patient-Inputs text file before edit
  @patient:BookAppointment-Create @patient-smokeTest
  Scenario Outline: Create new appointment
    When Enter the appointment details
      | mobile     | appointment_type | speciality      | doctor            | chief_complaint     |
      | 9090909091 | Clinic Visit     | Physiotherapist | Dr. Eritriya Drud | General appointment |
    Then Check wheather the appointment date-"<AppointmentDate>" is a past date or not,Based on zoneid "<TimeZone>"
    And Select the appointment date "<AppointmentDate>"
    Then Check the slot time is 2hrs>current time,if the appointment booked on today date and check the slot availability
    And Select the slot "<Slot>"
    Then Check the paynow option is enabled or not
    Then Check the fee details based on country
      | Domestic Consulting Fee | Overseas Consulting Fee |
      |                    2000 |                    4000 |
    And Click on paynow
    Then Done a payment process via "<PaymentMethod>"
      | card_number      | card_expiry-MM/YY | card_holder | card_cvv | netbanking_bankname | bank_type |
      | 4111111111111111 |              1228 | Sandhiya    |      123 | SBI                 | Retail    |
    Then validate the appointment details on payment success screen
    Then validate the appointment details from appointment view page
    Then Check payment details from payment module
    Then Check the appointment count from dashboard module
    Then Check the appointment details from my treatment module

    Examples: 
      | AppointmentDate | TimeZone     | Slot    | PaymentMethod |
      | 30/10/2020      | Asia/Kolkata | 2:00 PM | netbanking    |
