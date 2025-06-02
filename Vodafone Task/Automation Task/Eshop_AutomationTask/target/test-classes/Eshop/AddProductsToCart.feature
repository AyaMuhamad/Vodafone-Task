Feature: Login and Add Products to Cart

  @testcase1
  Scenario Outline: Login to the Eshop system
    Given User is on the Login Page
    When User Fill "<Email>" And "<Password>"
    Then User logs in successfully

    Examples:
      | Email       | Password  |
      | 01016062970 | Aya@1212  |

  @testcase2
  Scenario: Add three products to cart
    Given User is on the Main Page
    And User adds two products from the main page
    And User adds one product by searching for a specific item
    Then User should see the three products added to the cart successfully
