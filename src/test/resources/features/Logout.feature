Feature: Logout

  Background: For the scenarios in the feature file, use is expected to be on logout page
    Given The user is on the login page


  Scenario: User logs out successfully using the log out button
    When When the user clicks on the log out button
    Then The user is redirected to the login page

  Scenario: User cannot go back to the home page after logging out
    When When the user clicks on the step back button
    Then The user should not be able to go back to the home page

