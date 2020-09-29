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
  "name": "Add medical report",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Appointment"
    },
    {
      "name": "@Add-Medicalreport"
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
  "name": "Move to appointment list page based on date \"19/9/2020\" and zoneid \"Asia/Kolkata\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.compare__date(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Find the appointment using the appointment ID \"100\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.find_appointmentID(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Add medical report",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.add_medicalReport(io.cucumber.datatable.DataTable)"
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