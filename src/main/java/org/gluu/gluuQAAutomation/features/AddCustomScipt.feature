Feature: Add custom script 
@gluuQA
Scenario: Add custom script 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to Manage Custom Script 
	Then    I select the 'Person Authentication' tab
	And 	I click the add custom script button
	And 	I set the custom script name to 'QACustomScriptName' 
	And 	I set the custom script description to 'QACustomScriptDesc' 
	And 	I set the custom script level to '5' 
	And 	I set the custom script location type to 'Ldap'
	And 	I set the custom script usage type to 'Web'
	And 	I set the custom script content to 'QACustomScriptContent'
	And 	I enable the script
	And 	I save the custom script
	Then 	I sign out