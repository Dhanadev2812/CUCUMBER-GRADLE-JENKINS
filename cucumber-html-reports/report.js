$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/ClinicAdmin_Profileupdate.feature");
formatter.feature({
  "name": "Feature to done clinic update functionaity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ClinicUpdate"
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
  "name": "Check the mandatory fields",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ClinicUpdate"
    },
    {
      "name": "@Clinicupdate-Invalidemail"
    }
  ]
});
formatter.step({
  "name": "Go to clinic admin module",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_ProfileupdateStepDefs.goto_clinicAdmin()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on edit option",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_ProfileupdateStepDefs.click_edit()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter invalid email \"@test.com\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_ProfileupdateStepDefs.enter_invalid_email(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Submit the clinic updates",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_ProfileupdateStepDefs.submit_clinicUpdate()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "It display invalid email alert",
  "keyword": "But "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_ProfileupdateStepDefs.invalid_email_alert()"
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