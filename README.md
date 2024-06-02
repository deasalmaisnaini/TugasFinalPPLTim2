## Project Structure
ppl-tugas-final
├── src
│   └── test
│       └── java
│           ├── APITesting.helper
│           │   ├── SetUpEndPoint.java
│           │   └── Utility.java
│           ├── APITesting.model
│           │   ├── ListUser.java
│           │   ├── Location.java
│           │   ├── UserPreview.java
│           │   └── UserProfile.java
│           ├── APITesting.testlogic
│           │   ├── APITestProcessGeneric.java
│           │   └── APIUserTest.java
│           ├── APITesting.testlogic.requestAPItesting
│           ├── runner
│           │   └── CucumberRunnerTest.java
│           ├── stepDefinitions
│           │   ├── Hooks.java
│           │   ├── apitesting
│           │   │   └── APIUserStep.java
│           │   ├── webTesting
│           │   │   ├── CartSteps.java
│           │   │   ├── CheckoutSteps.java
│           │   │   ├── LoginSteps.java
│           │   │   ├── LogoutSteps.java
│           │   │   ├── MenuSteps.java
│           │   │   └── ProductDetailSteps.java
│           ├── webTesting.actions
│           │   ├── LoginPageActions.java
│           │   ├── LogoutPageActions.java
│           │   ├── MenuActions.java
│           │   └── ProductDetailActions.java
│           ├── webTesting.locators
│           │   ├── EndToEndLocators.java
│           │   ├── LoginPageLocators.java
│           │   ├── LogoutPageLocators.java
│           │   ├── MenuLocators.java
│           │   └── ProductDetailLocators.java
│           ├── webTesting.utils
│           │   └── HelperClass.java
│       └── resources
│           └── features
│               ├── create.feature
│               ├── delete.feature
│               ├── EndToEnd.feature
│               ├── get.feature
│               ├── LoginPage.feature
│               ├── LogoutPage.feature
│               ├── Menu.feature
│               ├── ProductDetail.feature
│               └── update.feature
├── JRE System Library [JavaSE-1.8]
└── Maven Dependencies

