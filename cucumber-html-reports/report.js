$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/Patient_mytreatment.feature");
formatter.feature({
  "name": "Feature to check my treatment functionaity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Mytreatment"
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
  "name": "Download prescription",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Mytreatment"
    },
    {
      "name": "@Download-prescription"
    }
  ]
});
formatter.step({
  "name": "Move to my treatment",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MytreatmentStepDefs.moveTo_myTreatment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate and Download the prescription based on appointment id \"2\"",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_MytreatmentStepDefs.find_appointment(java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat clinang.pageUtils.Patient_MytreatmentPageUtils.downloadPrescription(Patient_MytreatmentPageUtils.java:110)\r\n\tat clinang.stepDefs.Patient_MytreatmentStepDefs.find_appointment(Patient_MytreatmentStepDefs.java:29)\r\n\tat ✽.Validate and Download the prescription based on appointment id \"2\"(file:///D:/Testing%20workspace/ClinaNG/src/test/resources/clinang_Feature_Patient/Patient_mytreatment.feature:20)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});