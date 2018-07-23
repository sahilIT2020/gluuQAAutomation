Feature: Oxtrust json configuration 
@gluuQAPending1 
Scenario: Oxtrust json configuration 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to oxtrust Json configuration page 
	Then 	I should see the cert dir set to '/etc/certs' 
	And 	I should see the base dn set to 'o=gluu' 
	And 	I should see the org iname is empty 
	And 	I should see that the support mail is not empty 
	And 	I should see that the appliance inum is not empty 
	And 	I should see that the application url is not empty 
	And 	I should see that the base endpoint is correct 
	And 	I should see that the log level is set to 'DEFAULT' 
	And 	I should see that the sicm max count is set to '200'
	Then 	I sign out 
	