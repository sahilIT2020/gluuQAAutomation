Feature: List OpenID connect clients
@gluuQA
Scenario: List OpenID connect clients
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to openid connect clients list page
	Then 	I should see an openid client named 'SCIM Resource Server Client'
	And 	I should see an openid client named 'SCIM Requesting Party Client'
	Then 	I should see an openid client named 'Passport Resource Server Client'
	And 	I should see an openid client named 'Passport Requesting Party Client'
	And 	I should see an openid client named 'oxTrust Admin GUI'
	Then 	I sign out