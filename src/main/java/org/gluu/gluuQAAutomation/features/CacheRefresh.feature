Feature: Setup Cache Refresh

@gluuQAPending
Scenario: Add  source attribute
	When 	I sign in as administrator
	And 	I go to cache refresh page
	And 	I select the tab named 'Cache Refresh'
	And 	I add a source attribute named 'uid' to destination attribute named 'uid'
	And 	I add a source attribute named 'ldapName' to destination attribute named 'Username'
	And 	I set polling interval to '45' minutes
	And 	I enable cache refresh
	And 	I select the tab named 'Customer Backend Key/Attributes'
	And 	I add a key attribute named 'newKayAtrrib'
	And 	I save the cache refresh configuration
	Then 	I sign out
	
