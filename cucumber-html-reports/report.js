$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/ClinicAdmin_invoice.feature");
formatter.feature({
  "name": "Feature to validate invoice details",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ClinicAdmin:Invoice"
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
  "name": "Validate invoice details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ClinicAdmin:Invoice"
    },
    {
      "name": "@Validateinvoice"
    }
  ]
});
formatter.step({
  "name": "Go to invoice module",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_InvoiceStepDefs.goTo_invoice_module()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Get the invoice details from \"src\\test\\resources\\ClinicAdmin_TestData\\Watts Health Center\\Patient-details.xlsx\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_InvoiceStepDefs.get_invoice_details(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate invoice details from list page",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.ClinicAdmin_InvoiceStepDefs.validate_invoice_listPage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});