Feature: Check Certificates
@gluuQA
Scenario: Check Certificates 
	When 	I sign in as administrator
	And 	I go to certificates page
	Then 	I should see '2' certs in the list
	And 	I should see a cert named 'HTTPD SSL'
	And 	I should see a cert named 'Shibboleth IDP SAML Certificate'
	Then 	I sign out