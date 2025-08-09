# 🚀 Hybrid Selenium Test Automation Framework

This repository contains a **Hybrid Test Automation Framework** built using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and **Page Object Model/Page Factory** with **Data-Driven Testing** support.  

The framework is designed for **maintainability**, **scalability**, and **reusability** — supporting cross-browser execution, Excel-based test data, rich HTML reporting, and seamless CI/CD integration.

---

## 📌 Features

- **Maven-based project** (`maven-archetype-quickstart`) for standard build structure and dependency management.
- **TestNG integration** for test execution, grouping, parameterization, and reporting.
- **Page Object Model (POM)** and **Page Factory** for clean, reusable, and maintainable UI mapping.
- **Data-Driven Testing** support via:
  - `.properties` files for static configuration and key-value test data.
  - **Excel data** handling using Apache POI for multiple data sets.
- **Cross-browser execution** support (Chrome, Firefox, etc.) using WebDriver.
- **Listeners** (`ITestListener`) for event handling, logging, and custom actions during execution.
- **Extent Reports** integration for rich, interactive HTML reports.
- **Centralized configuration management** for environment and test settings.
- **Jenkins integration support** for Continuous Integration and Continuous Deployment (CI/CD).

---

## 📂 Project Structure

```plaintext
HybridFramework_SeleniumJava/
│
├── src/test/java
│   ├── com.tutorialsninja.qa.base        # Base class for browser setup & teardown
│   ├── com.tutorialsninja.qa.testcases   # Test classes (LoginTest, RegisterTest, SearchTest)
│   ├── com.tutorialsninja.qa.pages       # Page Object classes with locators & actions
│   ├── com.tutorialsninja.qa.utilities   # Utility classes (Excel reader, config loader, reports)
│   ├── com.tutorialsninja.qa.listeners   # TestNG Listeners for logging & reports
│
├── src/test/resources
│   ├── config.properties                 # Application URL, browser, and global configs
│   ├── datatest.properties               # Key-value based test data
│   ├── TestData.xlsx                      # Excel sheet for data-driven testing
│   ├── testng.xml                         # Test suite configuration file
│
├── pom.xml                               # Maven dependencies & build plugins
└── README.md                             # Project documentation





