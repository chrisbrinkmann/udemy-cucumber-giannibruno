Feature: User Login

@test1
Scenario: User logs into account with valid credentials
	Given user navigates to website
	And user clicks homepage login button
	When user enters valid credentials and clicks login button
	Then user should be taken to successful login page