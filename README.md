## Project Overview: 

This project demonstrates a Behavior-Driven Development (BDD) automation framework using Cucumber integrated with Selenium WebDriver and Page Object Model(POM).
It is designed for scalable, maintainable and efficient UI test automation.


## Features:

**BDD with Cucumber:** Implements Gherkin syntax for feature files to define test scenarios in plain language.

**Page Object Model (POM):** Separation of test scripts and UI elements for better maintainability.

**Custom Step Definitions:** Simplifies mapping Gherkin steps to Selenium actions.

**Hooks Implementation:** Provides preconditions (before hooks) and postconditions (after hooks) for test execution.

**Data-Driven Testing:** Supports parameterized testing using examples in feature files.

**Parallel Execution:** Executes multiple scenarios concurrently to optimize execution time.

**Cross-Browser Testing:** Runs tests on multiple browsers like Chrome, Firefox, and Edge.

**Detailed Reporting:** Generates execution reports using ExtentReports.


## Tech Stack:

IDE - IntelliJ IDEA

Language - Java

Maven - Build Tool

JUnit - Unit testing framework

Design Pattern - Page Object Model (POM)

Reports : Extent Spark Report & Extent pdf Report



## Prerequisites:

Java JDK 11 or higher

Maven

Cucumber

Selenium WebDriver

Browsers: Chrome, Firefox, Edge

JUnit (for parallel execution)


## Installation and Setup:

**Clone the repository:**

git clone https://github.com/veena444/CucumberPOMFramework.git

**Navigate to the project directory:**

cd CucumberPOMFramework

**Install dependencies using Maven:**

mvn clean install


## Running Tests:

**Local Execution:**

Update the config.properties file to specify browser and environment configurations.

Run tests using Maven:

mvn test

**Parallel Execution:**

Enable parallel execution by configuring TestNG in the testng.xml file:

<suite name="TestSuite" parallel="classes" thread-count="4">



## Reporting:

**ExtentReports:** Provides a comprehensive view of test execution status.

**Screenshots:** Automatically attached to reports for failed scenarios.


## Usage:

* Create new feature files in the /resources/features directory to define test scenarios.

* Implement corresponding step definitions in the /src/test/java/com/framework/steps package.

* Update config.properties to modify test settings like browser type, environment, and base URL.
