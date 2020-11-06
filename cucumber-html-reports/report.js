$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/ClinicAdmin_Doctor.feature");
formatter.feature({
  "name": "Feature to validate and create new doctor",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Clinic_doctor"
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
  "name": "Go to doctor module",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.goTo_doctor_module()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add fee details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Clinic_doctor"
    },
    {
      "name": "@Addfees"
    }
  ]
});
formatter.step({
  "name": "get the doctor details from \"src\\test\\resources\\ClinicAdmin_TestData\\Watts Health Center\\Doctor-details.xlsx\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.get_doctor_details(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Update the doctor fee details",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.update_doctorFee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the success message for fee update process",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.check_successMessage_editFee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the updated details on payment edit screen",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.validate_updatedDetails_editPayment()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});