# GluuQAAutomation

The goal of this project is to automate the QA process using Selenium webdriver.

# How to run the test
 
 1. Clone the project: `git clone https://github.com/sahiliamsso/gluuQAAutomation.git`
 1. `cd src/main/java/org/gluu/gluuQAAutomation/configuration/`
 1. Edit the file `config.properties` to match your settings
 1. Run the command `mvn test -Dcucumber.options="--tags @gluuQA"`
 
 
 # How to view the test result
 
 1. Run the command: `mvn spring-boot:run`
 1. Navigate to: `http://localhost:8080`
 
 
