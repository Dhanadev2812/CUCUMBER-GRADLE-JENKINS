$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/Patient_appointment.feature");
formatter.feature({
  "name": "Feature to appointment functionaity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Appointment"
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
formatter.scenario({
  "name": "Reschedule the appointment",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Appointment"
    },
    {
      "name": "@Reschedule"
    }
  ]
});
formatter.step({
  "name": "Go to appointment module",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.goTo_appointment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Move to appointment list page based on date \"29/9/2020\" and zoneid \"Asia/Kolkata\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.compare__date(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Find the appointment using the appointment ID \"232\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.find_appointmentID(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check wheather the appointment date-\"29/9/2020\" is a past date or not,Based on zoneid \"Asia/Kolkata\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.validation_appointmentDate(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check wheather the reschedule date-\"30/9/2020\" is a past date or not,Based on zoneid \"Asia/Kolkata\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.check_reschedule_date(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Reschedule the appointment to \"30/9/2020\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.rescheduleAppointment(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the slot time is 2hrs\u003ecurrent time,if the reschedule date \"30/9/2020\" is a current date also check the slot availability",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.Check_slot(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select slot  \"8:30 PM\" with complaint \"general appointment\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.Select_slot_complaint(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check validation message",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.check_validation_message()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate rescheduled appointment details",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.Validate_rescheduleDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the appointment count based on reschedule date \"30/9/2020\" and previous appointment date \"29/9/2020\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.check_appointmentCount(java.lang.String,java.lang.String)"
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