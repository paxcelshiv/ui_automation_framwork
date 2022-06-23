Feature: Test functionality of home page
Scenario: 
	Open the Home page of vangoghmuseum and Verify Collection page
	Given I am on the Home page url "https://www.vangoghmuseum.nl"
	When I Scroll right from home page
	When I Click on "Ontdek de collectie" link
	Then I should verify page title as "Collectie"
	And Verify placeholder "Zoek een kunstwerk" in search textbox
Scenario:
	Browser tear down
	Then close browser for Home test cases