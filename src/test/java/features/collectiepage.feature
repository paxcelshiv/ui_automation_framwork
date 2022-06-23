Feature: Test functionality of Ontdek de collectie page
Scenario: 
	Search the painting with title Het Gele Huis and verify more than 700 results
	Given I am opening url "https://www.vangoghmuseum.nl"
	When I Scrolling right hand side
	And I Clicking on "Ontdek de collectie" textlink
	When I Enter "Het Gele Huis" text in Search textbox
	When I Click on Search submit button
	Then Here should be appeared more than 700 results
Scenario: 
	Search the painting with title Het Gele Huis and Verify first result painting
	When Reload collection page and Enter "Het Gele Huis" text in Search textbox
	When I Click on the first result
	Then I should verify painting as below
	 | F-nummer | F0464 |
	 | JH-nummer| JH1589|
	 | Inventarisnummer  | s0032V1962 |
	 
Scenario:
	Quite browser for all test cases
	Then quite browser
	 
	 
	