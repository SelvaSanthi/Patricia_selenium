Feature: Search for a product and add to wishlist or remove from wishlist

  Background: 
    When Launch flipkart application

  Scenario Outline: Search for a product and add to wishlist
    When Enter "<username>" and "<password>"
    Then User should be successfully navigated to Homepage
    When Enter "<product>" to search
    Then Product should be successfully searched
    When Click on the product in the search result to view details
    And Add the the product to the wishlist
    Then Product should be successfully added to wishlist
    And Logout from the application

    Examples: 
      | username   | password   | product     |
      | 8144855487 | Selva@2000 | Mobilephone |

  Scenario Outline: Search for a product and remove from wishlist
    When Enter "<username>" and "<password>"
    Then User should be successfully navigated to Homepage
    When Navigate to userprofile and click on wishlist
    And Click on the product from the wishlist to remove
    Then Product should be successfuly removed from the wishlist
    And Logout from the application

    Examples: 
      | username   | password   |
      | 8144855487 | Selva@2000 |