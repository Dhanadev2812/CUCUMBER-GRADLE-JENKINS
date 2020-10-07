$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/clinang_Feature_Patient/Patient_appointment.feature");
formatter.feature({
  "name": "Feature to appointment functionaity",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Appointment"
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
  "name": "Add followup",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Appointment"
    },
    {
      "name": "@Addfollowup"
    }
  ]
});
formatter.step({
  "name": "Get the patient country",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.get_country()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Move to dashboard",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_DashboardStepDefs.moveto_dashboard()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Go to appointment module",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.goTo_appointment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check wheather the appointment date-\"7/10/2020\" is a upcoming date or not,Based on zoneid \"Asia/Kolkata\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.check_appointmentDate_upcoming(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Move to appointment list page based on date \"7/10/2020\" and zoneid \"Asia/Kolkata\"",
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.compare__date(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Find the appointment using the appointment ID \"1\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.find_appointmentID(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the appointment have an option to book a followup",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.Check_bookFollowupOption()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the followup fees",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.Validate_followupFee(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Accept the book followup",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.Accept_bookFollowup()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter the followup appointment details",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.followup_appointmentDetails(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check wheather the appointment date-\"7/10/2020\" is a past date or not,Based on zoneid \"Asia/Kolkata\"",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.validation_appointmentDate(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select the appointment date \"10/10/2020\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.select_appointment_Date(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the slot time is 2hrs\u003ecurrent time,if the appointment booked on today date and check the slot availability",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.compare_slot()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Select the slot \"9:00 PM\"",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.select_slot(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check the paynow option is enabled or not",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.check_payNow_enable()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the payment amount with followup fee details",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_AppointmentStepDefs.Validate_followUp_fee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on paynow",
  "keyword": "And "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.click_on_payNow()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Done a payment process via \"netbanking\"",
  "rows": [
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.payment_process(java.lang.String,io.cucumber.datatable.DataTable)"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for clinang.webDriverUtils.CustomDriver$2@6ae62c7e (tried for 50 second(s) with 500 milliseconds interval)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:95)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:272)\r\n\tat clinang.webDriverUtils.CustomDriver.waitForElementDisplayed(CustomDriver.java:71)\r\n\tat clinang.pageUtils.Patient_BookAppointmentPageUtils.wait_paymentForm(Patient_BookAppointmentPageUtils.java:213)\r\n\tat clinang.pageUtils.Patient_BookAppointmentPageUtils.paymentMethod_netbanking(Patient_BookAppointmentPageUtils.java:761)\r\n\tat clinang.stepDefs.Patient_BookAppointmentStepDefs.payment_process(Patient_BookAppointmentStepDefs.java:94)\r\n\tat ✽.Done a payment process via \"netbanking\"(file:///D:/Testing%20workspace/ClinaNG/src/test/resources/clinang_Feature_Patient/Patient_appointment.feature:102)\r\nCaused by: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"#content\"}\n  (Session info: chrome\u003d85.0.4183.121)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027COMP\u0027, ip: \u0027192.168.43.207\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 85.0.4183.121, chrome: {chromedriverVersion: 84.0.4147.30 (48b3e868b4cc0..., userDataDir: C:\\Users\\DELL\\AppData\\Local...}, goog:chromeOptions: {debuggerAddress: localhost:63179}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 5e69261c7c14352e55fa15829748a327\n*** Element info: {Using\u003did, value\u003dcontent}\r\n\tat sun.reflect.GeneratedConstructorAccessor14.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat clinang.webDriverUtils.CustomDriver$2.apply(CustomDriver.java:60)\r\n\tat clinang.webDriverUtils.CustomDriver$2.apply(CustomDriver.java:1)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:249)\r\n\tat clinang.webDriverUtils.CustomDriver.waitForElementDisplayed(CustomDriver.java:71)\r\n\tat clinang.pageUtils.Patient_BookAppointmentPageUtils.wait_paymentForm(Patient_BookAppointmentPageUtils.java:213)\r\n\tat clinang.pageUtils.Patient_BookAppointmentPageUtils.paymentMethod_netbanking(Patient_BookAppointmentPageUtils.java:761)\r\n\tat clinang.stepDefs.Patient_BookAppointmentStepDefs.payment_process(Patient_BookAppointmentStepDefs.java:94)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)\r\n\tat java.lang.reflect.Method.invoke(Unknown Source)\r\n\tat io.cucumber.java.Invoker.invoke(Invoker.java:27)\r\n\tat io.cucumber.java.JavaStepDefinition.execute(JavaStepDefinition.java:27)\r\n\tat io.cucumber.core.runner.PickleStepDefinitionMatch.runStep(PickleStepDefinitionMatch.java:63)\r\n\tat io.cucumber.core.runner.TestStep.executeStep(TestStep.java:64)\r\n\tat io.cucumber.core.runner.TestStep.run(TestStep.java:49)\r\n\tat io.cucumber.core.runner.PickleStepTestStep.run(PickleStepTestStep.java:46)\r\n\tat io.cucumber.core.runner.TestCase.run(TestCase.java:51)\r\n\tat io.cucumber.core.runner.Runner.runPickle(Runner.java:66)\r\n\tat io.cucumber.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:149)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:83)\r\n\tat io.cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:24)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:185)\r\n\tat io.cucumber.junit.Cucumber.runChild(Cucumber.java:83)\r\n\tat org.junit.runners.ParentRunner$4.run(ParentRunner.java:331)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:79)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:329)\r\n\tat org.junit.runners.ParentRunner.access$100(ParentRunner.java:66)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:293)\r\n\tat io.cucumber.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:219)\r\n\tat org.junit.runners.ParentRunner$3.evaluate(ParentRunner.java:306)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:413)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:89)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:41)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:542)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:770)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:464)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "validate the appointment details",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.validate_appointment_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check payment details from payment module",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.check_payment_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Check the appointment count from dashboard module",
  "keyword": "Then "
});
formatter.match({
  "location": "clinang.stepDefs.Patient_BookAppointmentStepDefs.check_dashboard_appointmentCount()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});