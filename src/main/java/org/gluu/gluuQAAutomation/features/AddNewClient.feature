Feature: Add new client
@gluuQAPending
Scenario: Add new client
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to openid connect clients list page
	And 	I start the process to add new client
	And 	I set the client name to 'QaClientName'
	And 	I set the client description to 'QaClientDescription'
	And 	I set the client secret to 'secret'
	And 	I set application type to 'Web'
	And 	I set preauthorization to 'False'
	And 	I set persist authorization to 'True'
	And 	I set subject type to 'public'
	And 	I set authentication method to 'client_secret_basic'
	#And 	I add the scope named 'profile'
	And 	I add following scopes 'email openid user_name profile'
