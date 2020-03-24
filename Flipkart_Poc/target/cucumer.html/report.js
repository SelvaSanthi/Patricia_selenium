$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/Com/Flipkart/Feature/AddCart.feature");
formatter.feature({
  "name": "Search for a product and add to cart",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user navigate to the flipkart application",
  "keyword": "When "
});
formatter.match({
  "location": "Com.Flipkart.StepDef.WebActionsSetpDef.user_navigate_to_the_flipkart_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter the valid username and password",
  "keyword": "And "
});
formatter.match({
  "location": "Com.Flipkart.StepDef.WebActionsSetpDef.enter_the_valid_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Validate the loginpage",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user should navigate to the homepage as user",
  "keyword": "Then "
});
formatter.match({
  "location": "Com.Flipkart.StepDef.WebActionsSetpDef.the_user_should_navigate_to_the_homepage_as_user()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Search for a product",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "enter the \"\u003csearch_product\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "click on the product to view its details",
  "keyword": "And "
});
formatter.step({
  "name": "add the the product to the cart",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "search_product"
      ]
    },
    {
      "cells": [
        "Mobilephone"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user navigate to the flipkart application",
  "keyword": "When "
});
formatter.match({
  "location": "Com.Flipkart.StepDef.WebActionsSetpDef.user_navigate_to_the_flipkart_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter the valid username and password",
  "keyword": "And "
});
formatter.match({
  "location": "Com.Flipkart.StepDef.WebActionsSetpDef.enter_the_valid_username_and_password()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Search for a product",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "enter the \"Mobilephone\"",
  "keyword": "And "
});
formatter.match({
  "location": "Com.Flipkart.StepDef.WebActionsSetpDef.enter_the(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on the product to view its details",
  "keyword": "And "
});
formatter.match({
  "location": "Com.Flipkart.StepDef.WebActionsSetpDef.click_on_the_product_to_view_its_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add the the product to the cart",
  "keyword": "And "
});
formatter.match({
  "location": "Com.Flipkart.StepDef.WebActionsSetpDef.add_the_the_product_to_the_cart()"
});
formatter.result({
  "status": "passed"
});
});