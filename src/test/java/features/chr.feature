Feature:  go to the Google search page, and search for an item
@Test1
Scenario: tranport login

Given that I have gone to the ogs transportpage
When I enter "username" and "password" to the search box
And click the login Button
Then request should be mentioned in the results

@Test2
Scenario: view ors/update
Given you are in transport page
When you click on smart roster
And you click on ORS update
Then it shows required page

@Test3
Scenario: checking dropdown box
Given that I am on ors page
When I select dropdown details
And select checkbox emoliyee details 
Then closes the page

@Test4
Scenario: checking datepicker
Given that I am in ors page
When I click on date
Then date will selected and close the window