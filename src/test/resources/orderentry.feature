Feature: Order Entry

When a customer is entering their items we should update the discount amount as well as the total

  Scenario: Entering a single item shows the discount and total
    Given I am on the order form
    And I enter in a "bicycle" that costs "$5.99"
    Then I should see a discount amount of "$0.59"
    And I should see a total of "$5.40"

  Scenario: Entering multiple items shows the total discount and sum of the amount after discount
    Given I am on the order form
    And I enter in a "stuffed animal" that costs "$10.00"
    And I enter in a "racecar" that costs "$20.00"
    Then I should see a discount amount of "$6.00"
    And I should see a total of "$24.00"