$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/ClinicAdmin_Patient.feature");
formatter.feature({
  "name": "Feature to done patient functionaity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Clinic_patient"
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
  "name": "Click on patient module",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_PatientStepDefs.moveTo_patientModule()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify patient details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Clinic_patient"
    },
    {
      "name": "@Patientdetails"
    }
  ]
});
formatter.step({
  "name": "get the patient details from \"src\\test\\resources\\ClinicAdmin_TestData\\Watts Health Center\\Patient-details.xlsx\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_PatientStepDefs.get_patient_details(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the appointment details on patient module",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_PatientStepDefs.verify_appointment_patientModule()"
});
