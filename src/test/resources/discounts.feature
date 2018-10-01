Feature: Order Total Discounts

  We have three tiers for discounts - either a 10 percent discount for less than $10, a fixed $1.00 off
  for $10-20 orders, or 20 percent discount for orders over $20.00

  Scenario Outline: Calculating discounts
    Given the order <total>
    When the discount is calculated
    Then the discount total is <discount amount>

    Examples:
      |total|discount amount|notes|
      |0.00       |0.00           |no discount|
      |9.99       |0.99           |10% discount|
      |10.00      |1.00           |$1.00 discount|
      |19.99      |1.00           |$1.00 discount|
      |20.00      |4.00           |20% discount  |
      |100.00     |20.00          |20% discount  |