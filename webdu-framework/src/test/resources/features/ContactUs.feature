Feature: Submit data to webdriverunivsersity.com using web form


Scenario: Submit info using the contact us form
	Given I access webdriveruniversity contact us form
	When I fill out the contact us form
	And I click submit button
	Then the info should be successfully submitted
	
