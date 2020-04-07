Feature: Login to the application and Search for a product

  Background: 
    When Launch flipkart application

  Scenario Outline: Login to the flipkart application
    When Enter "<username>" and "<password>"
    Then User should be successfully navigated to Homepage
    And Logout from the application

    Examples: 
      | username   | password   |
      | 8144855487 | Selva@2000 |

  @RegressionTest
  Scenario Outline: Search for a product
    When Enter "<username>" and "<password>"
    Then User should be successfully navigated to Homepage
    When Enter "<product>" to search
    Then Product should be successfully searched
    And Logout from the application

    Examples: 
      | username   | password   | product     |
      | 8144855487 | Selva@2000 | Mobilephone |
      | 8144855487 | Selva@2000 | noresult    |

  Scenario Outline: Search for a product
    When User enter "<username>" and "<password>"
    Then User should be successfully navigated to Homepage
    When User enter "<product>" to search
    Then Product should be successfully searched
    And Logout from the application

    Examples: 
      | username       | password       | product       |
      | Value_Username | Value_Password | Value_Product |
