# GluuQAAutomation

The goal of this project is to automate the QA process using Selenium webdriver.

# Prepare a gluu instance for QA

1. Install a Gluu server 3.1.3 or use an existing one
1. Clone oxtrust project [here](https://github.com/GluuFederation/oxTrust)
1. Clone branch **gluu_qa** of the oxTrust project
1. Romove the target directory if exist:**rm -rf server/target/**
1. Generate a new war: **mvn package -Dmaven.test.skip=true**, the generatee war is present in this folder **server/target/oxtrust_server.war**
1. Replace the **opt/gluu/jetty/identity/identity.war** file in your gluu instance with the generated one(**server/target/oxtrust_server.war**).
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
   
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_1.png" alt="Report">
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_2.png" alt="Report">
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_3.png" alt="Report">
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_4.png" alt="Report">
   <img src="https://github.com/sahiliamsso/gluuQAAutomation/blob/master/src/main/resources/qa_5.png" alt="Report">
 
