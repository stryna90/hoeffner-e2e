Feature: Forgotten password

  Background: I log in and accept cookies
    Given I load the login page
    And I accept cookies on the login page

  Scenario: Send me an email with reset password instructions
    And I can see forgot password link
    When I click on a forgotten password link
    And I enter my email in forgotten password form
    And I click on the Send Email button
    Then I can see a confirmation that email with further instructions was sent
