# Automatic Testing for DUMMYAPI.IO and Swag Labs

<img src="https://drive.google.com/uc?id=1O5vMZ6EybOVWGQKiRE-PSjZf1U0k4y_3" alt="Web Automation Testing" width="700">

[![Collaborators](https://img.shields.io/badge/Collaborators-Falia%20Davina%20%7C%20Dea%20Salma%20%7C%20Syifa%20Khairina-blue)](https://github.com/deasalmaisnaini/WebAutomationTesting)
[![Technologies](https://img.shields.io/badge/Technologies-Selenium%20%7C%20Cucumber%20%7C%20Maven%20%7C%20Java%20%7C%20JUnit-red)](https://github.com/deasalmaisnaini/WebAutomationTesting)

(https://github.com/deasalmaisnaini/WebAutomationTesting)

This project demonstrates the use of automated testing for the DUMMYAPI.IO and Swag Labs applications. DUMMYAPI.IO provides API endpoints for testing purposes, while Swag Labs is a web-based e-commerce application commonly used for software testing. This README outlines the project's structure, usage, development, and community guidelines.

## :ledger: Index

- [About](#beginner-about)
- [Usage](#zap-usage)
  - [Installation](#electric_plug-installation)
  - [Commands](#package-commands)
- [Development](#wrench-development)
  - [Pre-Requisites](#notebook-pre-requisites)
  - [Development Environment](#nut_and_bolt-development-environment)
  - [File Structure](#file_folder-file-structure)
  - [Build](#hammer-build)
  - [Deployment](#rocket-deployment)
- [Community](#cherry_blossom-community)
  - [Contribution](#fire-contribution)
  - [Branches](#cactus-branches)
  - [Guideline](#exclamation-guideline)
- [FAQ](#question-faq)
- [Resources](#page_facing_up-resources)
- [Gallery](#camera-gallery)
- [Credit/Acknowledgment](#star2-creditacknowledgment)
- [License](#lock-license)

## :beginner: About

This project involves automated testing for two different applications:

### DUMMYAPI.IO

DUMMYAPI.IO is a platform providing API documentation for testing and learning purposes. It allows developers to simulate API calls, facilitating the process of testing and application development without building their own backend. The API functionalities tested include:
- **Create:** Adding new user data. Endpoint: `POST /user/create`
- **Update:** Updating existing user data. Endpoint: `PUT /user/{id}`
- **Get By ID:** Retrieving user data by ID. Endpoint: `GET /user/{id}`
- **Get List:** Retrieving a list of users. Endpoint: `GET /user/`
- **Delete:** Deleting a user. Endpoint: `DELETE /user/{id}`

### Swag Labs

Swag Labs is a web-based e-commerce application used for software testing. It simulates an online store where users can browse products, add them to their cart, and proceed to checkout. Key features tested include:
- **Menu:** Navigation through the application.
- **Dashboard:** Viewing available products.
- **Login and Logout:** User authentication and session management.
- **Product Detail:** Viewing detailed information about products.
- **Cart:** Managing products in the shopping cart.
- **Checkout:** Completing the purchase process.

## :zap: Usage

This section explains how to use the automated tests for both DUMMYAPI.IO and Swag Labs.

:file_folder: File Structure
```
ppl-tugas-final
├── src                          # Main directory for all source code and test code
│   └── test                     # Directory for test code
│       └── java                 # Directory for test code in Java
│           ├── APITesting       # Directory for API testing
│           │   ├── helper       # Subdirectory for helper classes
│           │   ├── model        # Subdirectory for model classes
│           │   └── testlogic    # Subdirectory for API test logic
│           ├── runner           # Directory for test runner classes
│           ├── stepDefinitions  # Directory for step definitions
│           │   ├── apitesting   # Subdirectory for API testing step definitions
│           │   ├── webTesting   # Subdirectory for web testing step definitions
│           │   └── Hooks.java   # Java class for hooks (e.g., setup and teardown)
│           └── webTesting       # Directory for web testing
│               ├── actions      # Subdirectory for classes performing web actions
│               ├── locators     # Subdirectory for classes defining web element locators
│               └── utils        # Subdirectory for utility classes supporting web testing
├── resources                    # Directory for additional resources
└── pom.xml                      # Maven configuration file for this project
```

:hammer: Build
To build the project, run:

sh
Copy code
mvn clean install
:rocket: Deployment
For deployment instructions, refer to the specific deployment guidelines of your infrastructure. Typically, this involves ensuring the environment is correctly configured with Java and Maven, and then running the application or tests as required.
