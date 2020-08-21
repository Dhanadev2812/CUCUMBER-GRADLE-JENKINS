$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature/patient_dashboard.feature");
formatter.feature({
  "name": "Feature to done dashboard functionaity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Patientdashboard"
    }
  ]
});
formatter.scenario({
  "name": "Update profile with valid details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Patientdashboard"
    },
    {
      "name": "@Editprofile-valid"
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
  "name": "Click on edit profile option",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.click_editProfile()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter mobile_number,address,street,city,state,country and pincode",
  "rows": [
    {},
    {}
  ],
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.enter_profiledetails(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on \"save\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.click_option(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check the data stored on DB",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.checkData_DB()"
});
formatter.result({
  "status": "passed"
});
});