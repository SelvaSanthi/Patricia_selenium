$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/flipkartFeatureFile/ApplicationLoginAndsearch.feature");
formatter.feature({
  "name": "Login to the application and Search for a product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Search for a product",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "name": "Enter \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "User should be successfully navigated to Homepage",
  "keyword": "Then "
});
formatter.step({
  "name": "Enter \"\u003cproduct\u003e\" to search",
  "keyword": "When "
});
formatter.step({
  "name": "Product should be successfully searched",
  "keyword": "Then "
});
formatter.step({
  "name": "Logout from the application",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "product"
      ]
    },
    {
      "cells": [
        "8144855487",
        "Selva@2000",
        "Mobilephone"
      ]
    },
    {
      "cells": [
        "8144855487",
        "Selva@2000",
        "noresult"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Launch flipkart application",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.LoginAndSearchStepDef.launch_flipkart_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Search for a product",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@RegressionTest"
    }
  ]
});
formatter.step({
  "name": "Enter \"8144855487\" and \"Selva@2000\"",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.LoginAndSearchStepDef.enter_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "User should be successfully navigated to Homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "flipkartStepDef.LoginAndSearchStepDef.user_should_be_successfully_navigated_to_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Enter \"Mobilephone\" to search",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.LoginAndSearchStepDef.enter_to_search(java.lang.String)"
});
