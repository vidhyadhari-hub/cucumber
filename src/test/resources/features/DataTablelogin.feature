Feature:login
  @sanity @TIK-896
  Scenario: Successful login with valid user credentials
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters Username  and password
    | Username | password|
    | Admin    | admin123 |
    | Admin    | admin1234 |
    | vidhya   | vid123    |
    And User clicks login button
    Then Page Title should be displayed as "OrangeHRM"
    And clicks logout hamburger and logout link
