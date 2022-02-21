Feature: Login Customer

  @cucumber
  Scenario: Searching for a term
    Given Max is on the gitHub Home page
    When he enters his username as "username"
    And he password as the "password"
    Then he should be redirected to the home page of github