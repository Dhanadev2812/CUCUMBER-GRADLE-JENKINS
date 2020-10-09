@Mytreatment
Feature: Feature to check my treatment functionaity

  Background: User is Logged In
    Given I open the app
    When Enter the email,password and clinic code
      | email                   | password    | clinic_code |
      | sandhiya.2894@gmail.com | Password12# | LAT002      |
    And click on login button
    Then Check i am logged in

  @Check-Mytreatment
  Scenario: Check my treatment
    And Move to my treatment
    Then Check the my treatment details with the help of "src\test\resources\Patient_TestData\Sandhiya-ID-1\Patient_Mytreatment\TreatmentDetails.xlsx"

  @Download-prescription
  Scenario: Download prescription
    And Move to my treatment
    When Validate and Download the prescription based on appointment id "2"
      | DrugName | Unit | Frequency | Days   | Before/After |
      | Drug001  | 1 mg | 1-0-1     | 5 Days | After Food   |
      | Drug003  | 1 ml | 1-0-1     | 5 Days | After Food   |
      