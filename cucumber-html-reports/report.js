$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature/alogin.feature");
formatter.feature({
  "name": "Login, logout the app",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@sanitytest"
    },
    {
      "name": "@loginfun"
    }
  ]
});
formatter.scenario({
  "name": "Login into the app",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@sanitytest"
    },
    {
      "name": "@loginfun"
    },
    {
      "name": "@alogin"
    }
  ]
});
formatter.step({
  "name": "I open the app",
  "keyword": "Given "
});
formatter.match({
  "location": "clinang.stepDefs.LoginStepDefs.openTheApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I login to the app",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.LoginStepDefs.login()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.LoginStepDefs.close()"
});
formatter.result({
  "status": "passed"
});
});