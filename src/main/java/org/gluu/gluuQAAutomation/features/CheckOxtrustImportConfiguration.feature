Feature: Oxtrust import json configuration 
@gluuQAPending 
Scenario: Oxtrust import json configuration 
	When 	I sign in as administrator 
	Then 	I should see gluu home page 
	When 	I go to oxtrust import Json configuration page 
	Then 	I should see an item with ldapName 'uid' and displayName 'Username' and dataType 'string' and required 'true'
	And 	I should see an item with ldapName 'givenName' and displayName 'First Name' and dataType 'string' and required 'true'
	And 	I should see an item with ldapName 'sn' and displayName 'Last Name' and dataType 'string' and required 'true'
	And 	I should see an item with ldapName 'mail' and displayName 'Email' and dataType 'string' and required 'true'
	And 	I should see an item with ldapName 'userPassword' and displayName 'Password' and dataType 'string' and required 'false'
	Then 	I sign out