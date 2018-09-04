# GluuQAAutomation

# How to load test again a running Gluu server

  ## Login/Logout load testing
  
  The goal here is the instruct the browser to log into a target Gluu Server using the provide credentials, wait few seconds and logout. The browser will do these steps n times where n can be parameterized. 
  1. Clone the project: `git clone https://github.com/sahiliamsso/gluuQAAutomation.git`
  1. `cd src/main/java/org/gluu/gluuQAAutomation/configuration/`
  1. Edit the file `config.properties` to match your settings
  1. Run the command `mvn test -Dcucumber.options="--tags @gluuLoadTest"`

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
   
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_1.png" alt="Report1">
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_2.png" alt="Report2">
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_3.png" alt="Report3">
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_4.png" alt="Report4">
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_5.png" alt="Report5">
 
