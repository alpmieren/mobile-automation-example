Feature: Wikipedia

  Scenario: App Navigation: Scrolling Through Pages and Returning to Home
    Given open to app
    Given Scroll to the end of the page
    When Click My List,History and Nearby icons
    When Click Browse icon
    And Scroll to the top of the page

  Scenario: Verify search bar functionality and return to home page
    Given the user enters "New York" in the search bar
    When the search bar expands with the returned results
    When the user double clicks on the close search button

  Scenario: Verify to go to Setting and disable all options
    Given Click on setting
    When Disable all options
    When Back to home page