# Blink22 Automation Task

This project contains automated tests for the blog subscription functionality on the Blink22 website using Selenium WebDriver with Java and TestNG.

## Project Structure

```
Blink22AutomationTask/
├── src/
│   ├── main/java/
│   │   ├── Core/
│   │   │   ├── BasePage.java          # Base page class with common WebDriver operations
│   │   │   └── DriverManager.java     # WebDriver management and initialization
│   │   └── Pages/
│   │       ├── HomePage.java          # Home page object model
│   │       └── BlogPage.java          # Blog page object model
│   └── test/java/
│       ├── Core/
│       │   └── BaseTest.java          # Base test class with setup/teardown
│       └── Tests/
│           ├── BlogSubscriptionSuccessfulSubmissionTest.java
│           ├── BlogSubscriptionRequiredFieldsTest.java
│           └── BlogSubscriptionEmailValidationTest.java
├── testng.xml                         # TestNG suite configuration
└── pom.xml                           # Maven dependencies and configuration
```

## Dependencies

- **Java 21**
- **Selenium WebDriver 4.35.0** - For browser automation
- **TestNG 7.11.0** - Testing framework
- **SLF4J 2.0.17** - Logging framework

## Test Cases

### Sub_1: Valid Data Subscription Test
**Summary:** Check the user can subscribe when entering valid data.

**Steps:**
1. Go to url "https://www.blink22.com/"
2. Choose "Blog" tab from the upper menu
3. Navigate to "Get More Content Like This!" form
4. Fill "Full Name" textbox with "Test Name"
5. Fill "Email" textbox with "TestEmail@example.com"
6. Click "Subscribe" button

**Expected Results:**
- Subscribe form should disappear
- Thank you message "Thanks for signing up! Check your inbox for your Welcome package!" should appear

### Sub_2: Required Fields Validation Test
**Summary:** Check that "Full Name" and "Email" textboxes are mandatory.

**Steps:**
1. Go to url "https://www.blink22.com/"
2. Choose "Blog" tab from the upper menu
3. Navigate to "Get More Content Like This!" form
4. Clear "Full Name" textbox
5. Clear "Email" textbox
6. Click "Subscribe" button

**Expected Results:**
- Subscribe form shouldn't disappear
- Thank you message shouldn't appear
- Error message "This field is required." should appear

### Sub_3: Invalid Email Format Validation Test
**Summary:** Check that the user can't subscribe when adding invalid email format.

**Steps:**
1. Go to url "https://www.blink22.com/"
2. Choose "Blog" tab from the upper menu
3. Navigate to "Get More Content Like This!" form
4. Fill "Full Name" textbox with "Test Name"
5. Fill "Email" textbox with "TestEmail"
6. Click "Subscribe" button

**Expected Results:**
- Subscribe form shouldn't disappear
- Thank you message shouldn't appear
- Error message "Enter a valid email address." should appear

## Features

### Page Object Model (POM)
The project follows the Page Object Model design pattern:
- **BasePage**: Contains common WebDriver operations and wait strategies
- **HomePage**: Handles navigation and cookie popup management
- **BlogPage**: Manages blog subscription form interactions

### Driver Management
- Supports multiple browsers (Chrome, Firefox, Edge)
- Singleton pattern for WebDriver instance management
- Automatic browser window maximization
- Configurable page load timeout (30 seconds)

### Robust Element Handling
- Explicit waits with 2-second timeout
- Element visibility and clickability checks
- Exception handling for missing elements
- Utility methods for common operations (click, sendKeys, getText, etc.)

## How to Run Tests

### Prerequisites
- Java 21 installed
- Maven installed
- Chrome/Firefox/Edge browser installed

### Running Tests

#### Run all tests using TestNG XML:
```bash
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

#### Run specific test class:
```bash
mvn test -Dtest=BlogSubscriptionSuccessfulSubmissionTest
```

#### Run tests with specific browser:
The default browser is set to Edge in `BaseTest.java`. To change the browser, modify the browser parameter in the `setup()` method.

### Test Configuration

The TestNG suite is configured in `testng.xml` and includes:
- Blog Subscription Email Validation Test
- Blog Subscription Required Fields Test  
- Blog Subscription Successful Submission Test

## Key Implementation Details

### Element Locators
- Uses various locator strategies: ID, CSS selectors, class names
- Implements robust error handling for element interactions
- Includes validation for form visibility and error messages

### Test Data Extraction
The setup method automatically extracts and prints:
- Full Name field placeholder text
- Email field placeholder text

### Assertions
Uses TestNG SoftAssert for multiple validations within single test methods, allowing all assertions to be evaluated before test failure.

## Browser Support
- **Chrome** - Primary browser for development
- **Firefox** - Cross-browser compatibility
- **Edge** - Default browser for test execution

## Logging
Simple SLF4J logging configuration for test execution monitoring and debugging.
