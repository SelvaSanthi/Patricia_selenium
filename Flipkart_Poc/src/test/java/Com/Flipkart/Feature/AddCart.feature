
Feature: Search for a product and add to cart
Background:
When user navigate to the flipkart application
And enter the valid username and password
Scenario: Validate the loginpage
Then the user should navigate to the homepage as user
Scenario Outline: Search for a product
And enter the "<search_product>"
And click on the product to view its details
And add the the product to the cart
Examples:
|search_product|
|Mobilephone|