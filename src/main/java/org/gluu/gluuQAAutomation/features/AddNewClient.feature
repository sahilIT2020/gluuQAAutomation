Feature: Add new client
@gluuQA
Scenario: Add new client
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to openid connect clients list page
	And 	I start the process to add new client
	And 	I select the OIDC 'StandardTab' tab
	And 	I set the client name to 'QaClientName'
	And 	I set the client description to 'QaClientDescription'
	And 	I set the client secret to 'secret'
	And 	I set application type to 'Web'
	And 	I set preauthorization to 'False'
	And 	I set persist authorization to 'True'
	And 	I set subject type to 'public'
	And 	I set authentication method to 'client_secret_basic'
	And 	I add the scope named 'profile'
	And 	I add the response type named 'code'
	And 	I add the grant type named 'authorization_code'
	And 	I add the login redirect named 'https://qalogin/redirect'
	And 	I select the OIDC 'AdvancedTab' tab
	And 	I select the OIDC 'EncryptionTab' tab
	And 	I select the OIDC 'StandardTab' tab
	And 	I save the client registration
	When 	I go to openid connect clients list page
	And 	I search for openid clients with pattern 'QaClientName'
	Then 	I should see an openid client named 'QaClientName'
	When 	I start the process to edit the client named 'QaClientName' 
	And 	I delete that client
	When 	I go to openid connect clients list page
	And 	I search for openid clients with pattern 'QaClientName'
	Then 	I should not see an openid client named 'QaClientName'
	And 	I sign out	
