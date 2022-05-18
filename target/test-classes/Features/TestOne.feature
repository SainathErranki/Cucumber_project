Feature: Test1

  @Sanity001 @CloseDriver
  Scenario: Verify and Enter log in credtionals
    When user is in Home Page
    Then verify Email address and Password texts
    And Verify sign in button
    Then Enter Email and Password texts

  @Sanity002 @HomePage @CloseDriver
  Scenario: Verify List items and its values
    When verify  listgroup values
    Then verify second list value name
    And verify sccond list item badge value is 6

  @Sanity003 @HomePage @CloseDriver
  Scenario: Verify Dropdown options values
    When Default value is option1
    Then click on the dropdown and select option3

  @Sanity004 @HomePage @CloseDriver
  Scenario: Veirfy Enabled and disabled buttons
    When First button is enabled and Second button is disabled

  @Sanity005 @HomePage @CloseDriver
  Scenario: To Check Alert message and verify disabled state of button
    When Wait for button to displayed
    Then click on the button
    And Verify Alert to display in screen
    Then Verify button is disabled or not

  @Sanity006 @HomePage @CloseDriver
  Scenario: To check tabular form and find values
    When Get any value in Tabular form:
      | "3,3" |
      | "1,2" |
      
    Then Verify the postion of value in tabular form
    And Verify Ventosanzap cell value
