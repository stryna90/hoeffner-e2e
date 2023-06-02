Feature: User registration

  Background: I open registration page and accept cookies
    Given I load the registration page
    When I accept the cookies

  @registration
  Scenario: I am able to register account with valid data
    And I submit the form with valid data
    Then My account is registered

  @registration
  Scenario Outline: I try to register account with invalid data
    And I fill out the registration form
    And I submit the form with invalid value '<fieldValue>' for '<fieldName>'
    Then I see a error message for '<errorField>'

    Examples:
      | fieldName       | fieldValue                    | errorField            |
      | first name      | Fir5tName                     | first name            |
      | first name      |                               | empty first name      |
      | last name       | LastNam#e                     | last name             |
      | last name       |                               | empty last name       |
      | email           | Fir5tName@email               | email                 |
      | email           |                               | empty email           |
      | email           | hoeffner_testuser@mailsac.com | existing email        |
      | password        | @Aa8t5@                       | password              |
      | password        | @AC89A@#A                     | password              |
      | password        | #a98nauda                     | password              |
      | password        | j*An#akaj                     | password              |
      | password        | jhay2ANB23r                   | password              |
      | repeat password | Password                      | repeat password       |
      | repeat password |                               | empty repeat password |


  @registration
  Scenario: I try to register account without salutation
    And I submit the registration form without salutation
    Then I see a error message for 'salutation'

  @registration
  Scenario: I try to register account without accepting terms and conditions
    And I fill out the registration form
    And I submit the registration form without terms and conditions
    Then I see a error message for 'terms and conditions'


  @registration
  Scenario Outline: I want to read registration form clauses
    And I open register form clause for '<clause>'
    Then I can read register form clause for '<clause_title>'

    Examples:
      | clause              | clause_title              |
      | newsletter          | newsletter title          |
      | terms and condition | terms and condition title |
      | data usage          | data usage title          |