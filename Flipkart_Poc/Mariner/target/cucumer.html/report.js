$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/flipkartFeatureFile/applicationLoginAndsearch.feature");
formatter.feature({
  "name": "Login to the application and Search for a product",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Login to the flipkart application",
  "description": "",
  "keyword": "Scenario Outline"
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
        "password"
      ]
    },
    {
      "cells": [
        "8144855487",
        "Selva@2000"
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
  "name": "Launch flipkart application",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.launch_flipkart_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Login to the flipkart application",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter \"8144855487\" and \"Selva@2000\"",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.enter_and(java.lang.String,java.lang.String)"
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
  "location": "flipkartStepDef.loginAndsearchStepDef.user_should_be_successfully_navigated_to_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Logout from the application",
  "keyword": "And "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.logout_from_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Search for a product",
  "description": "",
  "keyword": "Scenario Outline"
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
formatter.step({
  "name": "Launch flipkart application",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.launch_flipkart_application()"
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
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter \"8144855487\" and \"Selva@2000\"",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.enter_and(java.lang.String,java.lang.String)"
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
  "location": "flipkartStepDef.loginAndsearchStepDef.user_should_be_successfully_navigated_to_Homepage()"
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
  "location": "flipkartStepDef.loginAndsearchStepDef.enter_to_search(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Product should be successfully searched",
  "keyword": "Then "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.product_should_be_successfully_searched()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Logout from the application",
  "keyword": "And "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.logout_from_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch flipkart application",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.launch_flipkart_application()"
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
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter \"8144855487\" and \"Selva@2000\"",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.enter_and(java.lang.String,java.lang.String)"
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
  "location": "flipkartStepDef.loginAndsearchStepDef.user_should_be_successfully_navigated_to_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Enter \"noresult\" to search",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.enter_to_search(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Product should be successfully searched",
  "keyword": "Then "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.product_should_be_successfully_searched()"
});
formatter.result({
  "error_message": "junit.framework.AssertionFailedError: No search result found\r\n\tat junit.framework.Assert.fail(Assert.java:57)\r\n\tat flipkartPages.WebActions.validateSearch(WebActions.java:135)\r\n\tat flipkartStepDef.loginAndsearchStepDef.product_should_be_successfully_searched(loginAndsearchStepDef.java:46)\r\n\tat ✽.Product should be successfully searched(file:///C:/Users/selvamuthukumar.g.ZUCISYSTEMS/OneDrive%20-%20zucisystems.com/SG/Eclipse%20Automation/Mariner/src/test/java/flipkartFeatureFile/applicationLoginAndsearch.feature:19)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Logout from the application",
  "keyword": "And "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.logout_from_the_application()"
});
formatter.result({
  "status": "skipped"
});
formatter.afterstep({
  "status": "skipped"
});
formatter.uri("file:src/test/java/flipkartFeatureFile/wishlistAddandRemove.feature");
formatter.feature({
  "name": "Search for a product and add to wishlist or remove from wishlist",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Search for a product and add to wishlist",
  "description": "",
  "keyword": "Scenario Outline"
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
  "name": "Click on the product in the search result to view details",
  "keyword": "When "
});
formatter.step({
  "name": "Add the the product to the wishlist",
  "keyword": "And "
});
formatter.step({
  "name": "Product should be successfully added to wishlist",
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
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "Launch flipkart application",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.launch_flipkart_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Search for a product and add to wishlist",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter \"8144855487\" and \"Selva@2000\"",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.enter_and(java.lang.String,java.lang.String)"
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
  "location": "flipkartStepDef.loginAndsearchStepDef.user_should_be_successfully_navigated_to_Homepage()"
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
  "location": "flipkartStepDef.loginAndsearchStepDef.enter_to_search(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Product should be successfully searched",
  "keyword": "Then "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.product_should_be_successfully_searched()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Click on the product in the search result to view details",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.click_on_the_product_in_the_search_result_to_view_details()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Add the the product to the wishlist",
  "keyword": "And "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.add_the_the_product_to_the_wishlist()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Product should be successfully added to wishlist",
  "keyword": "Then "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.product_should_be_successfully_added_to_wishlist()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Logout from the application",
  "keyword": "And "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.logout_from_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Search for a product and remove from wishlist",
  "description": "",
  "keyword": "Scenario Outline"
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
  "name": "Navigate to userprofile and click on wishlist",
  "keyword": "When "
});
formatter.step({
  "name": "Click on the product from the wishlist to remove",
  "keyword": "And "
});
formatter.step({
  "name": "Product should be successfuly removed from the wishlist",
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
        "password"
      ]
    },
    {
      "cells": [
        "8144855487",
        "Selva@2000"
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
  "name": "Launch flipkart application",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.launch_flipkart_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.scenario({
  "name": "Search for a product and remove from wishlist",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Enter \"8144855487\" and \"Selva@2000\"",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.enter_and(java.lang.String,java.lang.String)"
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
  "location": "flipkartStepDef.loginAndsearchStepDef.user_should_be_successfully_navigated_to_Homepage()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to userprofile and click on wishlist",
  "keyword": "When "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.navigate_to_userprofile_and_click_on_wishlist()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Click on the product from the wishlist to remove",
  "keyword": "And "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.click_on_the_product_from_the_wishlist_to_remove()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Product should be successfuly removed from the wishlist",
  "keyword": "Then "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.product_should_be_successfuly_removed_from_the_wishlist()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "Logout from the application",
  "keyword": "And "
});
formatter.match({
  "location": "flipkartStepDef.loginAndsearchStepDef.logout_from_the_application()"
});
formatter.result({
  "status": "passed"
});
formatter.afterstep({
  "status": "passed"
});
});