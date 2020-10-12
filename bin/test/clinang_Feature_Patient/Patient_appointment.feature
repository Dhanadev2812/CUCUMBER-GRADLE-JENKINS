@Appointment
Feature: Feature to appointment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in

  @Reschedule
  Scenario: Reschedule the appointment
    And Go to appointment module
    When Move to appointment list page based on date "13/10/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "26"
    Then Check wheather the appointment date-"13/10/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    Then Check wheather the reschedule date-"13/10/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    When Reschedule the appointment to "13/10/2020"
    Then Check the slot time is 2hrs>current time,if the reschedule date "13/10/2020" is a current date also check the slot availability
    When Select slot  "8:00 PM" with complaint "general appointment"
    Then Check validation message
    Then Validate rescheduled appointment details
    Then Check the appointment count based on reschedule date "13/10/2020" and previous appointment date "13/10/2020"

  @Cancel
  Scenario: Cancel the appointment
    And Go to appointment module
    When Move to appointment list page based on date "13/10/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "27"
    Then Check wheather the appointment date-"13/10/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    And Cancel the appointment
    Then Check the validation message for cancellation process
    Then Check the appointment count based on cancelled appointment date "13/10/2020"
    Then Check the appointment id "27" should removed from my treatment list

  @Addfollowup
  Scenario: Add followup
    And Get the patient country
    And Move to dashboard
    And Go to appointment module
    Then Check wheather the appointment date-"7/10/2020" is a upcoming date or not,Based on zoneid "Asia/Kolkata"
    When Move to appointment list page based on date "7/10/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "3"
    Then Check the appointment have an option to book a followup
    Then Validate the followup fees
      | Domestic Followup Fee | Overseas Followup Fee |
      |                  1000 |                  1500 |
    And Accept the book followup
    When Enter the followup appointment details
      | mobile     | appointment_type    | chief_complaint     |
      | 9090909091 | Online Consultation | General appointment |
    Then Check wheather the appointment date-"14/10/2020" is a past date or not,Based on zoneid "Asia/Kolkata"
    And Select the appointment date "14/10/2020"
    Then Check the slot time is 2hrs>current time,if the appointment booked on today date and check the slot availability
    And Select the slot "8:00 PM"
    Then Check the paynow option is enabled or not
    Then Validate the payment amount with followup fee details
    And Click on paynow
    Then Done a payment process via "netbanking"
      | card_number      | card_expiry-MM/YY | card_holder | card_cvv | netbanking_bankname | bank_type |
      | 4111111111111111 |              1228 | Sandhiya    |      123 | SBI                 | Retail    |
    Then validate the appointment details on payment success screen
    Then validate the appointment details from appointment view page
    Then Check payment details from payment module
    Then Check the appointment count from dashboard module
    Then Check the appointment details from my treatment module

  @Add-Medicalreport
  Scenario: Add medical report
    And Go to appointment module
    When Move to appointment list page based on date "13/10/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "26"
    And Add medical report with description
      | src\\test\\resources\\Patient_TestData\\Sandhiya-ID-1\\Patient_medicalReport\\PDF.pdf     | Pdf-Medical report |
      | src\\test\\resources\\Patient_TestData\\Sandhiya-ID-1\\Patient_medicalReport\\JPG-1MB.jpg | Scean image        |
    Then Validate the uploaded medical reports
      | PDF.pdf     | Pdf-Medical report |
      | JPG-1MB.jpg | Scean image        |

  @Downloadall-Medicalreport
  Scenario: Download all the medical report
    And Go to appointment module
    When Move to appointment list page based on date "13/10/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "26"
    When download all the uploaded report

  @DownloadSpecific-Medicalreport
  Scenario: Download specific medical report
    And Go to appointment module
    When Move to appointment list page based on date "19/9/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "92"
    When Download specific uploaded report based on report name and description
      | PDF.pdf  | Pdf-Medical report |
      | test.png | test des           |

  @Deleteall-Medicalreport
  Scenario: Delete all the medical report
    And Go to appointment module
    When Move to appointment list page based on date "19/9/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "91"
    When delete all the uploaded report

  @DeleteSpecific-Medicalreport
  Scenario: Delete specific  medical report
    And Go to appointment module
    When Move to appointment list page based on date "19/9/2020" and zoneid "Asia/Kolkata"
    And Find the appointment using the appointment ID "91"
    When Delete specific uploaded report based on report name and description
      | 1.1 (8).png | Test |
