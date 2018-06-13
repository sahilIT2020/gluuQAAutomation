Feature: Sign in

Scenario: Sign in as admin
 	When 	I sign in as administrator
 	Then 	I should see gluu home page

#Scenario: Sign in with credentials
# 	When 	I sign in with username 'testUser' and password 'testUser'
# 	Then 	I should see gluu home page 	
