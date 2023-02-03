Feature: Login on main page

  Background: I subscribe to a newsletter
    Given I load the login page
    And I accept cookies on the login page
    And the User see email input on login form

  Scenario: the User should not login with invalid email and password
    When the User enters "invalidemail" email
    And the User click on Register button
    Then the User should see alert "Bitte geben Sie eine gültige E-Mail-Adresse ein" message