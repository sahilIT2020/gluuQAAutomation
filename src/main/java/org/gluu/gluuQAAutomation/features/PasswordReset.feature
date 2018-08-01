Feature: Password reset 
@gluuQA
Scenario: Password reset 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to smtp configuration page
	And 	I set 'smtp.gmail.com' as smtp host
	And 	I set 'GluuQA' as from name
	And 	I set 'gasmyr-ims.app@gmail.com' as from email address
	And 	I set 'gasmyr-ims.app@gmail.com' as username
	And 	I set 'gasmyr-imsApp2017' as password
	And 	I set '456' as smtp port
	And 	I test the configuration
	And 	I save the configuration
	When 	I go to system organization configuration page
    And     I set the Self-Service Password Reset to 'Enabled'
    And     I click on the Update button
    And 	I sign out
    And 	I click on password reset link
    Then 	I set 'qapasswordReset@gmail.com' as email
    And 	I send the mail
    Then 	I should see that the mail was send
    And 	I sign in as administrator
    And 	I sign out
