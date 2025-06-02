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
  Scenario Outline: Add three products to cart
    Given User is on the Main Page
    When User adds a product from tab number <Tab1> and selects product number <Product1>
    And User adds another product from tab number <Tab2> and selects product number <Product2>
    And User searches for "<SearchItem>" and selects product number <SearchProduct>
    Then User should see the three products added to the cart successfully

    Examples:
      | Tab1 | Product1 | Tab2 | Product2 | SearchItem | SearchProduct |
      | 3    | 4        | 5    | 3        | Iphone 15  | 1             |