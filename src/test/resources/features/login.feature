Feature:login
  @sanity @TIK-890
  Scenario: Successful login with valid user credentials
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters Username as "Admin" and password as "admin123"
    And User clicks login button
    Then Page Title should be displayed as "OrangeHRM"
    And clicks logout hamburger and logout link

  @regression @TIK-899
  Scenario Outline: Login to the application validation
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters Username as "<username>" and password as "<password>"
    And User clicks login button
    Then Page Title should be displayed as "OrangeHRM"
    And clicks logout hamburger and logout link
    Examples:
    | username | password |
    | Admin    | admin123 |
    | vidhya   | vid123   |
    | vinodh   | vin123   |
  @sanity @TIK-891
  Scenario: Successful login with valid user credentials
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters Username as "Admin" and password as "admin1234"
    And User clicks login button
    Then Page Title should be displayed as "OrangeHRM"
    And clicks logout hamburger and logout link
  @sanity @TIK-892
  Scenario: Successful login with valid user credentials
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters Username as "Admin" and password as "admin1235"
    And User clicks login button
    Then Page Title should be displayed as "OrangeHRM"
    And clicks logout hamburger and logout link

