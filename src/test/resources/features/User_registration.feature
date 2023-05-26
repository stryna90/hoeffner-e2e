Feature: User registration

  Background: I open registration page and accept cookies
    Given I load the registration page
    When I accept the cookies

    @registration
  Scenario: I am able to register account with valid data
    And I submit the form with valid data
    Then My account is registered

    @registration
  Scenario Outline: Try to register account with invalid data
      And I fill out the registration form
      And I submit the form with invalid value '<fieldValue>' for '<fieldName>'
      Then I see a error message for '<errorField>'

  Examples:
    | fieldName       | fieldValue      | errorField      |
    | first name      | Fir5tName       | first name      |
    | last name       | LastNam#e       | last name       |
    | email           | Fir5tName@email | email           |
    | password        | Password        | password        |
    | repeat password | Password        | repeat password |