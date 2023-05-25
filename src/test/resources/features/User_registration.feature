Feature: User registration

  Background: I open registration page and accept cookies
    Given I load the registration page
    When I accept cookies

    @registration
  Scenario: I am able to register account with valid data
    And I submit form with valid data
    Then My account is registered