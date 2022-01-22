Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check site main functions
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks sign in button visibility
    When User clicks 'Sign In' button
    Then User checks that current url contains '<keywordURL>'

    Examples:
      | homePage                            | keywordURL   |
      | https://www.bbc.com                 | signin       |


