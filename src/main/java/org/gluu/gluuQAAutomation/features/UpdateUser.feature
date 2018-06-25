Feature: Update user 
@gluuQA
Scenario: Update an existing user 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to users manage page 
	And 	I search for user with pattern 'QA' 
	Then 	I should see a user named 'QaUser' 
	When 	I start to update that user 
	And 	I set the display name to 'QaUser Display Name' 
	And 	I set the email to 'QaUser@gluu.com' 
	And 	I set the userName to 'QaUser' 
	And 	I save the update 
	When 	I search for user with pattern 'QA' 
	Then 	I should see a user named 'QaUser' 
	And 	I should see a user with display name 'QaUser Display Name' 
	When 	I sign out 
	#Then 	I should see the gluu login page