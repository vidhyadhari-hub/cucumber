Feature:
  @Functional
  Scenario: Login with DataDriven Excel File
    Given User launch browser
    And User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters Username  and password and clicks submit button and tests the expected result
