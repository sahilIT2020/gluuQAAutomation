Feature: Z_Import users
@gluuQA
Scenario: Z_Import users to gluu server
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to users import page
	And 	I import the sample excel file locate at '/home/gasmyr/gluuQAAutomation/src/main/resources/ImportUsers.xls'
	Then 	I sign out 
