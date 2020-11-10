$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/ClinicAdmin_Appointment.feature");
formatter.feature({
  "name": "Feature to validate appointment details on appointment module",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Clinic_appointment"
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
  "name": "Move to admin login page",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_LoginStepDefs.admin_loginPage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter clinic admin credentials",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_LoginStepDefs.enter_credentials(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on Login button",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_LoginStepDefs.click_loginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check i am logged in as a clinic admin",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_LoginStepDefs.check_loggedIn_clinicAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on appointment module",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_AppointmentStepDefs.click_appointmentModule()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate appointment details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Clinic_appointment"
    },
    {
      "name": "@validateAppointment"
    }
  ]
});
formatter.step({
  "name": "Get the details from \"src\\test\\resources\\ClinicAdmin_TestData\\Watts Health Center\\Patient-details.xlsx\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_AppointmentStepDefs.get_appointment_details(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the appointment details",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_AppointmentStepDefs.validate_appointmentDetails()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the total appointment count with dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_AppointmentStepDefs.check_total_appointment_count()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});