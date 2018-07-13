Feature: Add trust reletionship 
@gluuQA
Scenario: Add trust reletionship
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to tr add page
	Then 	I set 'QaTRDN' as display name
	And 	I set 'QaTRDesc' as description
	And 	I set 'Single SP' as entity type
	And 	I set 'File' as metadata location
	And 	I set '/home/gasmyr/gluuQAAutomation/src/main/resources/qa_meta.xml' metadata
	And 	I configure sp with 'SAML2SSO' profile
	And 	I release the following attributes 'Username Email'
	And 	I save the current tr
	When 	I go to tr list page
	And 	I search for tr named 'QaTRDN'
	Then 	I should see a tr with display name 'QaTRDN' in the list
	And 	I sign out