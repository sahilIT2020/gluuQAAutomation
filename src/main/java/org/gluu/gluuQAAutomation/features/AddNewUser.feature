Feature: Add new user 
@gluuQA 
Scenario: Sign in as admin 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to user add page 
	And 	I add a user named 'QaUser' 
	And 	With first name 'QaUserFN' 
	And 	With last name 'QaUserLN' 
	And 	With display name 'QaUserDN' 
	And 	With email 'QaUser@gmail.com' 
	And 	With password 'QaUser' 
	And 	With status 'Inactive' 
	And 	I save the user 
	When 	I sign out 
	#Then 	I should see the gluu login page