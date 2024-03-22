Feature: Validating Quick Create page
   

@Regression   @Quick_1  @TC_001
  Scenario: verify the Vtiger Login Page
    Given I navigate to application Open Url
    When User Enter username and password by click On login Button
    Then Login sucessfully
    And User is In vtigerCRM Home page
    And User has click on Quick Create dropdown Item field