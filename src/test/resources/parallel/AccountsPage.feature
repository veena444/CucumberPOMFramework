Feature: Accounts Page

  @accounts
  Scenario: Verify the headers on the accounts page
    Given user is logged in and on the accounts page
    When user checks the page headers
    Then page headers should be:
      | My Account |
      | My Orders  |
      | My Affiliate Account |
      | Newsletter |

  @accounts
  Scenario Outline: Verify the search functionality on the accounts page
    Given user is logged in and on the accounts page
    When user searches for "<searchKey>"
    Then result count should be <resultsCount>

    Examples:
      | searchKey | resultsCount |
      | macbook   | 3            |
      | imac      | 1            |
      | samsung   | 2            |
      | Airtel    | 0            |