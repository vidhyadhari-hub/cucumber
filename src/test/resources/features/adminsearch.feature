@sanity
Feature: adminsearch
  Scenario: searching using username
    Given User launch browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters Username as "Admin" and password as "admin123"
    And User clicks login button
    Then Page Title should be displayed as "OrangeHRM"
    When User clicks on admin tab
    And User enters user search text as "Admin"
    And User clicks search button
    Then Application displays the displays
