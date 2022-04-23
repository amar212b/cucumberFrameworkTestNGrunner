@tag
Feature: Search for Products
  I want to use this template for my feature file

  @tag1
  Scenario: Search for Product in Home and Offer page
    Given User is on GreenCart Landing page
		When user searched with Shortname <Name> and extracted actual name of product
		Then user searched for <Name> shortname in offers page 
		And validate product name in offers page matches with Landing Page
		##Then user close the offers page and navigate to landing page

	Examples:
	| Name  |
	|	Tom 	|
	|	Beet 	|

 