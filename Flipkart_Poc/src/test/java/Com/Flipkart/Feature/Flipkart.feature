Feature: Validate the Flipkart application
Background:
Given user start the report process

Scenario: Validate the loginpage
When user navigate to the flipkart application
And enter the valid username and password
Then the user should navigate to the homepage as user

Scenario Outline:
When user navigate to the flipkart application
And enter the invalid "<username_value>" and "<password_value>"
Then the user should not navigate to the homepage as user
Examples:
|username_value||password_value|
|0988144855487||Selva@2000|
|8144855487||selva2000|