
Feature: The user should be able to log out
  @UND-635 @wip
  Scenario: Logout successfully
    Given the user logged in
    When the user open the user option window
    Then the user should be able to logout

  @UND-636 @wip
  Scenario: Should not be able to with shortcut
    Given the user logged in
    When the user open the user option window
    And the user should be able to logout
    Then the user should not be able to Dashboard page by using step back button
