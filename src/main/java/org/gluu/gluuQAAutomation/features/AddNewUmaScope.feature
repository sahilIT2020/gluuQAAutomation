Feature: Add new uma scope 
@gluuQATodo 
Scenario: Add new uma scope 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to uma scope add page 
	And 	I set uma scope id to a random value 
	And 	I set uma scope display name to 'QAUmaScopeDN' 
	And 	I set uma scope logo to '/home/gasmyr/gluuQAAutomation/src/main/resources/gluu_qa_report.png' 
	#And 	I set uma scope policy to 'uma_rpt_policy'
	And 	I save the scope
	When 	I go to uma scope list page
	And 	I search for scopes with pattern 'SCIM'
	Then 	I should see a uma scope named 'SCIM Access'
	And 	I sign out