# GluuQAAutomation

The goal of this project is to automate the QA process using Selenium webdriver.

# Prepare a gluu instance for QA

1. Install a Gluu server 3.1.3 or use an existing one
1. Clone branch **gluu_qa** of the oxTrust project
1. Generate a new war
1. Replace the identity.war file in your gluu instance with the generated one.
1. Restart identity service.


# How to run QA test cases
 
 1. Clone the project: `git clone https://github.com/sahiliamsso/gluuQAAutomation.git`
 1. `cd src/main/java/org/gluu/gluuQAAutomation/configuration/`
 1. Edit the file `config.properties` to match your settings
 1. Run the command `mvn test -Dcucumber.options="--tags @gluuQA"`
 
 
 # How to view the test result
 
 1. Open a new terminal
 1. Navigate to the project `cd gluuQAAutomation`
 1. Run this command: `mvn spring-boot:run`
 1. Run: **Ctrl+C**
 1. Run this command: `mvn spring-boot:run`
 1. Navigate to: `http://localhost:8080`
 
 
 Sample:
   
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/Screenshot%20from%202018-06-15%2009-06-23.png" alt="Report">
 
