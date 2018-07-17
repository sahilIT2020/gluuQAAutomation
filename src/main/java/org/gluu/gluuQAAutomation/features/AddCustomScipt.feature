Feature: Add custom script 
@gluuQA
Scenario: Add custom script 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to Manage Custom Script 
	Then    I click on Add Custom Script
	And 	I add a Custom script configuration with display name 'QACustomScriptName' 
	And 	I add a Custom script configuration with description 'QACustomScriptDesc' 
	And 	I add a Custom script configuration with Level '5' 
	And 	I add a Custom property key "QACustomPropertyKey"
	And 	I add a Custom property value "QACustomPropertyValue"
	And 	I add a custom script with content "QACustomScriptContent"
	And 	I save the Custom script
	Then 	I go to Manage Custom Script 
	And 	I should see a Custom script with description 'QACustomScriptDesc' 
	And 	I should see a Custom script with display name 'QACustomScriptName'
	Then 	I sign out