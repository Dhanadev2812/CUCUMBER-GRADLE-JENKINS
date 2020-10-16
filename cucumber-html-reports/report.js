$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/Patient_medicalhistory.feature");
formatter.feature({
  "name": "Feature to check medical history functionaity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Medicalhistory"
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
  "name": "Go to medical history",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MedicalhistoryStepDefs.goto_medicalhistory()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Cancel medical history form",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Medicalhistory"
    },
    {
      "name": "@Medicalhistory-Cancel"
    }
  ]
});
formatter.step({
  "name": "Click \"cancel\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MedicalhistoryStepDefs.click_option(java.lang.String)"
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