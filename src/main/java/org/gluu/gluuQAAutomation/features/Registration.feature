Feature: Check Manage Registration
@gluuQA
Scenario: Check Manage Registration 
	When 	I sign in as administrator
	And 	I go to registration manage page
	Then 	I should see that the captcha status is 'false' 
	And  	I should see that the registration status is 'false'
	And  	I should see that the site key is 'empty'
	And  	I should see that the site secret is 'empty'
	And  	I should see that the css location is 'empty'
	And  	I should see that the js location is 'empty'
	Then 	I sign out