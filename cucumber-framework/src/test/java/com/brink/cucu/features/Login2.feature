Feature: User Login

Scenario: User logs into account with valid credentials
	Given user navigates to website2
	And user clicks homepage login button2
	When user enters valid credentials and clicks login button2
	Then user should be taken to successful login page2