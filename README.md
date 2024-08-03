Project Setup and Execution Guide
---------------------------------
  This document provides a step-by-step guide to setting up and running the automation script for the FITPeo website.

Prerequisites
-------------
  1.Java Development Kit (JDK): Ensure you have JDK 11 or higher installed. You can download it from here.

  2.Gradle: Ensure you have Gradle installed. You can download it from here.

  3.Google Chrome: Ensure you have the latest version of Google Chrome installed.

  4.ChromeDriver: Ensure you have ChromeDriver that matches your Chrome version. You can download it from here.

Project Structure 
-----------------
css
Copy code
ME_QA_FITPEO
│
├── build.gradle
├── settings.gradle
├── src
│   ├── main
│   │   ├── java
│   │   │   └── soubhagya0399
│   │   │       └── ME_QA_FITPEO
│   │   │           └── App.java
│   ├── test
│       ├── java
│       │   └── soubhagya0399
│       │       └── ME_QA_FITPEO
│       │           ├── AppTest.java
│       │           └── Pages
│       │               ├── Home.java
│       │               └── RevenueCalculatorPage.java
│       │           └── ListenersClass.java
│       └── resources
│           └── testng.xml
└── .gitignore


Setup Instructions
-------------------------------------------------------------------------------------
  Clone the Repository:https://github.com/soubhagya03999/soubhagya0399-ME_QA_FITPEO.git

  Copy code:-git clone https://github.com/soubhagya03999/soubhagya0399-ME_QA_FITPEO.git

  Go to project directory:-cd soubhagya0399-ME_QA_FITPEO

  Build the Project:-./gradlew build

  This will execute the test cases specified in the testng.xml file:- ./gradlew test

  View the Test Results:-After the tests have been executed, you can view the test results in the generated reports. The reports are located in the build/reports/tests/test          directory.

  Additional Notes
  1.Dependencies: The build.gradle file includes all necessary dependencies such as Selenium, TestNG, Apache POI, and Extent Reports.
  2.Logging and Reports: The test logging is configured to show passed, skipped, and failed tests with full stack traces. TestNG XML configuration (src/test/resources/testng.xml) specifies the test suite and includes the AppTest class.
