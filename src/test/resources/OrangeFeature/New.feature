Feature: Orange HRM Practice
Description: End to End Testing

Scenario: User logged In

	Given OrangeHRM website
	When enters valid credentials
	And Click Login
	Then Login as Paul
	And click on Location
	And Write New York and Office found
	And User Driver Closed