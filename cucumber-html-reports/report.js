$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/patient_dashboard.feature");
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
  "name": "Upload the image from \"D://Testing workspace//ClinaNG//Profile_img//women.jpg\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.uploadimage(java.lang.String)"
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
  "name": "Check validation message for successful update",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.check_updatealert_success()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Move to dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.moveto_dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the profile details updated on dashboard",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.check_with_dashboard()"
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
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027COMP\u0027, ip: \u0027192.168.43.207\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: driver.version: CustomDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:277)\r\n\tat clinang.webDriverUtils.CustomDriver.get(CustomDriver.java:22)\r\n\tat clinang.pageUtils.BrowserUtils.openApp(BrowserUtils.java:16)\r\n\tat clinang.stepDefs.Patient_LoginStepDefs.openTheApp(Patient_LoginStepDefs.java:24)\r\n\tat ✽.I open the app(file:///D:/Testing%20workspace/ClinaNG/src/test/resources/clinang_Feature_Patient/patient_dashboard.feature:5)\r\n",
  "status": "failed"
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
  "status": "skipped"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_LoginStepDefs.clickLogin()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check i am logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_LoginStepDefs.check_i_am_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Update profile with null details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Patientdashboard"
    },
    {
      "name": "@Editprofile-Null-Check_mandatory"
    }
  ]
});
formatter.step({
  "name": "Click on edit profile option",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.click_editProfile()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Clear all existing details",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.update_with_nullDetails()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check the validation message for mandatory fields",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.validation_message_mandatory()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check the save button is disabled or not",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.check_saveDisable()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click on \"cancel\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.click_option(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Move to dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.moveto_dashboard()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027COMP\u0027, ip: \u0027192.168.43.207\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteWebDriverOptions.deleteAllCookies(RemoteWebDriver.java:694)\r\n\tat clinang.webDriverUtils.Hooks_Utils.beforeScenario(Hooks_Utils.java:27)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
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
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027COMP\u0027, ip: \u0027192.168.43.207\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: driver.version: CustomDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:277)\r\n\tat clinang.webDriverUtils.CustomDriver.get(CustomDriver.java:22)\r\n\tat clinang.pageUtils.BrowserUtils.openApp(BrowserUtils.java:16)\r\n\tat clinang.stepDefs.Patient_LoginStepDefs.openTheApp(Patient_LoginStepDefs.java:24)\r\n\tat ✽.I open the app(file:///D:/Testing%20workspace/ClinaNG/src/test/resources/clinang_Feature_Patient/patient_dashboard.feature:5)\r\n",
  "status": "failed"
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
  "status": "skipped"
});
formatter.step({
  "name": "click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_LoginStepDefs.clickLogin()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check i am logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_LoginStepDefs.check_i_am_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Update profile with invalid details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Patientdashboard"
    },
    {
      "name": "@Editprofile-Invaliddatas"
    }
  ]
});
formatter.step({
  "name": "Click on edit profile option",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.click_editProfile()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Enter invalid mobile number",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.invalid_mobileNum(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check the validation message for invalid data",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.alert_invalidMobnum()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check the save button is disabled or not",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.check_saveDisable()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click on \"cancel\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.click_option(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Move to dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.moveto_dashboard()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027COMP\u0027, ip: \u0027192.168.43.207\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: driver.version: RemoteWebDriver\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:125)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:609)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver$RemoteWebDriverOptions.deleteAllCookies(RemoteWebDriver.java:694)\r\n\tat clinang.webDriverUtils.Hooks_Utils.beforeScenario(Hooks_Utils.java:27)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
});