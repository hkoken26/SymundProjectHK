Feature: User should be able to login

  @UND-627
  Scenario: Login with valid credentials
    Given the user is on the login page
    When the user enters the valid information
    Then Dashboard page should be displayed

  @UND-628
  Scenario Outline: try login with invalid credential
    Given the user is on the login page
    When user enters invalid "<username>" or "<password>"
    Then user should not login and should see error message "Wrong username or password."

    Examples:
      | username   | password    |
      | Employea72 | Employee123 |
      | Employee71 | Employee125 |
      | Employee72 | Employee125 |

  @UND-629
  Scenario Outline: try login with empty credential
    Given the user is on the login page
    When user enters empty "<username>" or "<password>"
    Then user should not login and should see notice message "Please fill out this field."

    Examples:
      | username   | password    |
      |            | Employee123 |
      | Employee71 |             |
      |            |             |

  @UND-630
  Scenario: See the password in a form of dots
    Given the user is on the login page
    When the user enters the valid information without click
    Then user should see only dots in password fields

  @UND-631
  Scenario: See the password explicitly
    Given the user is on the login page
    When the user enters the valid information without click
    And the user click on the eye icon
    Then user should see the password explicitly on fields

  @UND-632
  Scenario: Click on Forget password link
    Given the user is on the login page
    When the user click on the Forgot password
    Then user should see the "Reset password" button

  @UND-633
  Scenario: see valid placeholders
    Given the user is on the login page
    Then user should see "Username or email" and "Password" text on Username and Password fields

