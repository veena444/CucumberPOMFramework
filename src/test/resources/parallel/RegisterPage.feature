Feature: New User Registration

  Scenario: Verify new user registration with different data
    Given user is on the register page
    When user enters following user details
      | firstName | lastName | email          | telephone  | password  | subscribe |
      | Virat     | Kohli    | virat@open.com | 4512378963 | virat@123 | Yes       |
      | Roger     | Federer  | roger@open.com | 3216547890 | roger@123 | No        |
      | Manas     | Patra    | manas@open.com | 7896541230 | manas@123 | Yes       |
      | John      | Joe      | john@open.com  | 2789123607 | john@123  | No        |
    Then user registration should be successful