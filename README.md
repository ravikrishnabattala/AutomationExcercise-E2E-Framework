# AutomationExcercise-E2E-Framework
This project contains end-to-end automation testing using Selenium, Java and TestNG

##  Project Overview

This is an **End-to-End Test Automation Framework** built using:
- Selenium WebDriver
- Java
- TestNG
- Maven
- Page Object Model (POM)

It supports **cross-browser testing, parallel execution, and reporting**.

---

## Tech Stack

- Java 17
- Selenium 4+
- TestNG
- Maven
- Page Object Model (POM)
- JavaScript Executor
- Explicit & Fluent Waits

---

## Project Structure

```text
src
 ├── main/java/com/automation
 │    ├── driverFactory
 │    ├── pageFactory
 │    ├── utilities
 │    ├── base
 │    └── hook
 │
 ├── test/java/tests
 └── test/resources/testng.xml

## ▶️ Run Tests

To execute all automation tests, use the following Maven command:

```bash
mvn clean test
