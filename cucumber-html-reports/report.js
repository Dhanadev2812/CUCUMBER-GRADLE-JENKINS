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
formatter.scenario({
  "name": "Create new doctor",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Clinic_doctor"
    },
    {
      "name": "@createdoctor"
    }
  ]
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
formatter.step({
  "name": "Click on create doctor",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.click_createDoctor()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter doctor details",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.passDoctorDetails(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submit the form",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.submit_form()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the success message for doctor registration",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.Verify_successMessage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the new doctor details on doctor without profile screen",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_DoctorStepDefs.validate_newDoctor_details()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat clinang.stepDefs.ClinicAdmin_DoctorStepDefs.validate_newDoctor_details(ClinicAdmin_DoctorStepDefs.java:49)\r\n\tat ✽.Validate the new doctor details on doctor without profile screen(file:///D:/Testing%20workspace/ClinaNG/src/test/resources/clinang_Feature_Patient/ClinicAdmin_Doctor.feature:22)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});