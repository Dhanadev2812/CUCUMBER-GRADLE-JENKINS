$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/Patient_bookappointment.feature");
formatter.feature({
  "name": "Feature to check book appointment functionaity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Bookappointment"
    }
  ]
});
formatter.background({
  "name": "User is Logged In",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open the app",
  "keyword": "Given "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_LoginStepDefs.openTheApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the email,password and clinic code",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_LoginStepDefs.login(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_LoginStepDefs.clickLogin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check i am logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_LoginStepDefs.check_i_am_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the patient country",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.get_country()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Go to book appointment screen",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.Goto_bookAppointment()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Create new appointment",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Bookappointment"
    },
    {
      "name": "@BookAppointment-Create"
    }
  ]
});
formatter.step({
  "name": "Enter the appointment details",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.Enter_appointment_details(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check wheather the appointment date-\"10/10/2020\" is a past date or not,Based on zoneid \"Asia/Kolkata\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.validation_appointmentDate(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select the appointment date \"10/10/2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.select_appointment_Date(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the slot time is 2hrs\u003ecurrent time,if the appointment booked on today date and check the slot availability",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.compare_slot()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select the slot \"9:00 AM\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.select_slot(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the paynow option is enabled or not",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.check_payNow_enable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the fee details based on country",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.check_patient_currentCountry(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on paynow",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.click_on_payNow()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Done a payment process via \"netbanking\"",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.payment_process(java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the appointment details on payment success screen",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.validate_appointment_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the appointment details from appointment view page",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.validate_appointmentDetails_viewPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check payment details from payment module",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.check_payment_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the appointment count from dashboard module",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.check_dashboard_appointmentCount()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the appointment details from my treatment module",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.check_myTreatment_appointmentDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});