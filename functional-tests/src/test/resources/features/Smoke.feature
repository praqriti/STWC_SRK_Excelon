Feature: Smoke Tests

@Smoke
  Scenario: Verify Navigation and functionality
    Given I access excelon home
    Then I should see the image carousel
    When I navigate to contacts page
    Then I should see the search bar
    And I should see the category dropdown
    When I should see the coffee mug link

  Scenario: Verify Contact Us allows user to submit details
    Given I access excelon home
    When I navigate to contacts page
    Then I should be able to see a form
    Then I should be able to submit my details "name","lastname","message","email"


