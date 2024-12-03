Feature: Invalid Login Feature

  Scenario Outline: Verify invalid login feature
    Given user is on the login page
    When user enters username as "<username>" and password as "<password>"
    Then user should get the error message

    Examples:
      | username         | password  |
      | fname@gmail.com  | test@13   |
      | lname@@gmail.com | test@12   |
      | flname           | test@1234 |
      | flname@gmail     | test@123  |