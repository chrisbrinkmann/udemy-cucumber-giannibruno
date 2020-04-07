Feature: User Login

@staging
Scenario: User logs into account with valid credentials
	Given user navigates to website2
	Given user navigates to website
	And user clicks homepage login button
	When user enters valid credentials and clicks login button
	Then user should be taken to successful login page