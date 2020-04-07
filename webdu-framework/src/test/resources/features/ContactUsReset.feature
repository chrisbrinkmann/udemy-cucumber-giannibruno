Feature: Clear the contact us web form

Scenario: Use the reset button to clear the contact form
	Given I access webdriver university contact form
	When I fill out the contact us form
	And I click the reset button
	Then the form should be cleared of all my input