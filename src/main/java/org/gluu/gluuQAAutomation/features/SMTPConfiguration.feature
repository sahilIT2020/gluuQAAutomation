Feature: SMTP config 
@gluuQAPending 
Scenario: SMTP config 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to smtp configuration page
	And 	I set 'smtp.gmail.com' as smtp host
	And 	I set 'GluuQA' as from name
	And 	I set 'GluuQA' as from email address 