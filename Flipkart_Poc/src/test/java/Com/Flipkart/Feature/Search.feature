Feature: Search for a product
Background:
When user navigate to the flipkart application
And enter the valid username and password
Scenario: Validate the loginpage
Then the user should navigate to the homepage as user
Scenario Outline:
And enter the "<search_product>"
Examples:
|search_product|
|Mobilephone|
|Headset|