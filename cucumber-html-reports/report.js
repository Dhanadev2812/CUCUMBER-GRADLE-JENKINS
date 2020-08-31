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
formatter.scenario({
  "name": "Update medical history with valid details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Medicalhistory"
    },
    {
      "name": "@Medicalhistory-Edit-valid"
    }
  ]
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
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MedicalhistoryStepDefs.goto_medicalhistory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the medical history details",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MedicalhistoryStepDefs.enter_medicalHistorydetails(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click \"update\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MedicalhistoryStepDefs.click_option(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check validation message for successful medical history update",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MedicalhistoryStepDefs.checkValidation_update()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the added details updated on patient dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MedicalhistoryStepDefs.comparewith_dashboard()"
});
formatter.result({
  "status": "passed"
});
});