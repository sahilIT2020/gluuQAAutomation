Feature: OxTrust setting config 
@gluuQA 
Scenario: OxTrust setting config 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to oxtrust setting configuration page
	Then 	I should that the build date is not empty
	And 	I should that the build number is not empty
	And 	I should that the org name is not empty
	And 	I set the new org name to 'GLUU QA'
	And 	I should that 'Gluu Manager Group' is the admin group
	And 	I set the default qa logo as organisation logo
	And 	I set the default qa logo as organisation favicon
	And 	I save the oxtrust configuration
	When 	I go to oxtrust setting configuration page
	Then 	I should that the build date is not empty
	And 	I should that the build number is not empty
	And 	I should that the org name is 'GLUU QA'
	Then 	I sign out