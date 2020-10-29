@patient:Appointment
Feature: Feature to done appointment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email              | password    | clinic_code |
      | wilson@patient.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in

  @Patient:Reschedule @patient-smokeTest
  Scenario Outline: Reschedule the appointment
    And Go to appointment module
    When Move to appointment list page based on date "<AppointmentDate>" and zoneid "<TimeZone>"
    And Find the appointment using the appointment ID "<AppointmentID>"
    Then Check wheather the appointment date-"<AppointmentDate>" is a past date or not,Based on zoneid "<TimeZone>"
    Then Check wheather the reschedule date-"<RescheduleDate>" is a past date or not,Based on zoneid "<TimeZone>"
    When Reschedule the appointment to "<RescheduleDate>"
    Then Check the slot time is 2hrs>current time,if the reschedule date "<RescheduleDate>" is a current date also check the slot availability
    When Select slot  "<RescheduleSlot>" with complaint "<RescheduleComplaint>"
    Then Check validation message
    Then Validate rescheduled appointment details
    Then Check the appointment count based on "<RescheduleDate>" and "<AppointmentDate>"

    Examples: 
      | AppointmentID | AppointmentDate | RescheduleDate | TimeZone     | RescheduleSlot | RescheduleComplaint |
      |            74 | 30/10/2020      | 31/10/2020     | Asia/Kolkata | 1:00 PM        | general appointment |

  @Patient:Cancel @patient-smokeTest
  Scenario Outline: Cancel the appointment
    And Go to appointment module
    When Move to appointment list page based on date "<AppointmentDate>" and zoneid "<TimeZone>"
    And Find the appointment using the appointment ID "<AppointmentID>"
    Then Check wheather the appointment date-"<AppointmentDate>" is a past date or not,Based on zoneid "<TimeZone>"
    And Cancel the appointment
    Then Check the validation message for cancellation process
    Then Check the appointment count based on cancelled appointment date "<AppointmentDate>"
    Then Check the appointment id "<AppointmentID>" should removed from my treatment list

    Examples: 
      | AppointmentID | AppointmentDate | TimeZone     |
      |            74 | 31/10/2020      | Asia/Kolkata |

  @Patient:Addfollowup @patient-smokeTest
  Scenario Outline: Add followup
    And Get the patient country
    And Move to dashboard
    And Go to appointment module
    Then Check wheather the appointment date-"<AppointmentDate>" is a upcoming date or not,Based on zoneid "<TimeZone>"
    When Move to appointment list page based on date "<AppointmentDate>" and zoneid "<TimeZone>"
    And Find the appointment using the appointment ID "<AppointmentID>"
    Then Check the appointment have an option to book a followup
    Then Validate the followup fees
      | Domestic Followup Fee | Overseas Followup Fee |
      |                  1000 |                  1500 |
    And Accept the book followup
    When Enter the followup appointment details
      | mobile     | appointment_type    | chief_complaint              |
      | 9090909091 | Online Consultation | Followup-General appointment |
    Then Check wheather the appointment date-"<FollowupAppointmentDate>" is a past date or not,Based on zoneid "<TimeZone>"
    And Select the appointment date "<FollowupAppointmentDate>"
    Then Check the slot time is 2hrs>current time,if the appointment booked on today date and check the slot availability
    And Select the slot "<FollowupSlot>"
    Then Check the paynow option is enabled or not
    Then Validate the payment amount with followup fee details
    And Click on paynow
    Then Done a payment process via "<PaymentMethod>"
      | card_number      | card_expiry-MM/YY | card_holder | card_cvv | netbanking_bankname | bank_type |
      | 4111111111111111 |              1228 | Sandhiya    |      123 | SBI                 | Retail    |
    Then validate the appointment details on payment success screen
    Then validate the followup appointment details from appointment view page
    Then Check payment details from payment module
    Then Check the appointment count from dashboard module
    Then Check the appointment details from my treatment module

    Examples: 
      | AppointmentID | AppointmentDate | TimeZone     | FollowupAppointmentDate | FollowupSlot | PaymentMethod |
      |             1 | 22/10/2020      | Asia/Kolkata | 25/10/2020              | 1:30 PM      | netbanking    |

  @Add-Medicalreport @patient-smokeTest
  Scenario Outline: Add medical report
    And Go to appointment module
    When Move to appointment list page based on date "<AppointmentDate>" and zoneid "<TimeZone>"
    And Find the appointment using the appointment ID "<AppointmentID>"
    And Add medical report with description
      | src\\test\\resources\\Patient_TestData\\Sandhiya-ID-1\\Patient_medicalReport\\PDF.pdf     | Pdf-Medical report |
      | src\\test\\resources\\Patient_TestData\\Sandhiya-ID-1\\Patient_medicalReport\\JPG-1MB.jpg | Scean image        |
    Then Validate the uploaded medical reports
      | PDF.pdf     | Pdf-Medical report |
      | JPG-1MB.jpg | Scean image        |

    Examples: 
      | AppointmentID | AppointmentDate | TimeZone     |
      |             1 | 22/10/2020      | Asia/Kolkata |

  @Downloadall-Medicalreport
  Scenario Outline: Download all the medical report
    And Go to appointment module
    When Move to appointment list page based on date "<AppointmentDate>" and zoneid "<TimeZone>"
    And Find the appointment using the appointment ID "<AppointmentID>"
    When download all the uploaded report

    Examples: 
      | AppointmentID | AppointmentDate | TimeZone     |
      |             1 | 22/10/2020      | Asia/Kolkata |

  @DownloadSpecific-Medicalreport @patient-smokeTest
  Scenario Outline: Download specific medical report
    And Go to appointment module
    When Move to appointment list page based on date "<AppointmentDate>" and zoneid "<TimeZone>"
    And Find the appointment using the appointment ID "<AppointmentID>"
    When Download specific uploaded report based on report name and description
      | PDF.pdf  | Pdf-Medical report |
      | test.png | test des           |

    Examples: 
      | AppointmentID | AppointmentDate | TimeZone     |
      |             1 | 22/10/2020      | Asia/Kolkata |

  @Deleteall-Medicalreport
  Scenario Outline: Delete all the medical report
    And Go to appointment module
    When Move to appointment list page based on date "<AppointmentDate>" and zoneid "<TimeZone>"
    And Find the appointment using the appointment ID "<AppointmentID>"
    When delete all the uploaded report

    Examples: 
      | AppointmentID | AppointmentDate | TimeZone     |
      |             1 | 22/10/2020      | Asia/Kolkata |

  @DeleteSpecific-Medicalreport @patient-smokeTest
  Scenario Outline: Delete specific  medical report
    And Go to appointment module
    When Move to appointment list page based on date "<AppointmentDate>" and zoneid "<TimeZone>"
    And Find the appointment using the appointment ID "<AppointmentID>"
    When Delete specific uploaded report based on report name and description
      | 1.1 (8).png | Test |

    Examples: 
      | AppointmentID | AppointmentDate | TimeZone     |
      |             1 | 22/10/2020      | Asia/Kolkata |
