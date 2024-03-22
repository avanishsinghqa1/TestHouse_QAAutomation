Feature: Validating Analytics page
   

@Regression   @Analytics_1  @TC_001
  Scenario: verify the Analytics Page
    Given I navigate to APPlication open UrL
    When user Enter UsernamE and PassworD by clicK on login Button
    Then login sucessfully
    And user is in VtigerCRM HOme page
    And User has click on Analytics tab
  
 @Regression  @Analytics_2 @TC_002  
 Scenario: verify and create Report in Analytics
    Given I navigate to APPlication open UrL
    When user Enter UsernamE and PassworD by clicK on login Button
    Then login sucessfully
    And user is in VtigerCRM HOme page
    And User has click on Analytics tab
    And User has click on Reports tab
    And User verify and click on new report in Analytics Page
     