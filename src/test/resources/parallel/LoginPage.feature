Feature: Login Page Feature

  @login
  Scenario: Verify login page title
    Given user is on the login page
    When user checks the page title
    Then page title should be "Account Login"

  @login
  Scenario: Verify login page URL
    Given user is on the login page
    When user checks the page URL
    Then URL should contain "account/login"

  @login
  Scenario: Verify forgot password link exists
    Given user is on the login page
    When user checks the forgot password link
    Then forgot password link should be displayed

  @login
  Scenario: Login to application
    Given user is on the login page
    When user logs in with username "qauseraccount@open.com" and password "qa@123"
    Then user should be redirected to the accounts page with title "My Account"