# FinPay - Appium Automation Framework

FinPay is a robust, modular, and well-structured automation testing framework built using **Appium with Java**. This framework simplifies mobile app testing by offering tools for server management, test execution, data-driven testing, and utility operations.

## 🚀 **Project Overview**

The FinPay framework is designed to:
- Automate mobile application testing for Android/iOS.
- Simplify test execution with reusable components.
- Manage Appium server instances and test environments efficiently.
- Integrate test data from Excel files.
- Provide additional utilities like scrolling, swiping, and capturing screenshots.

---

## 📁 **Project Structure**

```plaintext
FinPay/
|-- src/
|   |-- main/
|   |   |-- java/
|   |       |-- server/           # Manages Appium Server
|   |       |-- base/             # BaseTest setup for tests
|   |       |-- utils/            # Utility functions
|   |       |-- data/             # ExcelReader for test data
|   |-- test/
|       |-- java/
|           |-- tests/            # Test classes
|-- resources/
|   |-- config/                   # Config files for Appium capabilities
|   |-- testdata/                 # Excel files for test data
|-- reports/                      # Test execution reports
|-- pom.xml                       # Maven dependencies
|-- README.md                     # Project documentation
```

---

## ⚙️ **Key Components**

### 1. **AppiumServer** *(server/)*
Manages the Appium server lifecycle (start/stop).
- Starts the server with specified port and configurations.
- Ensures a single instance using the Singleton pattern.

```java
AppiumServer server = AppiumServer.getInstance();
server.start();
server.stop();
```

---

### 2. **BaseTest** *(base/)*
Sets up and tears down the test environment.
- **`@BeforeClass`**: Launches the app.
- **`@AfterMethod`**: Closes the app after each test.
- **`@BeforeSuite` & @AfterSuite**: Handles Appium server start/stop.

---

### 3. **ExcelReader** *(data/)*
Reads test data from Excel files dynamically.
- Supports reading cell data, rows, and columns.
- Converts Excel data into a 2D array for data-driven testing.

Example:
```java
ExcelReader reader = new ExcelReader("TestData.xlsx");
String value = reader.getCellData(1, "Username");
```

---

### 4. **Utils** *(utils/)*
Provides helper functions for smooth automation workflows.
- **Scrolling**: `scrollToTop()`, `scrollToBottom()`, `scrollNClick()`
- **Swiping**: `swipe()`
- **Screenshots**: Capture specific or full-page screenshots.
- **Drag & Drop**: `dragNDrop()`

Example:
```java
Utils.scrollToBottom(driver);
Utils.captureFullPageShot(driver, "screenshot.png");
```

---

## 🛠️ **Tech Stack**
- **Java**: Programming language for the framework.
- **Appium**: Mobile automation testing tool.
- **TestNG**: Test execution framework.
- **Apache POI**: Excel file handling library.
- **Maven**: Build and dependency management tool.

---

## 🔧 **Setup and Installation**

1. **Clone the repository:**
   ```bash
   git clone https://github.com/yourusername/FinPay.git
   cd FinPay
   ```
2. **Install dependencies:**
   Make sure Maven is installed.
   ```bash
   mvn clean install
   ```
3. **Configure Appium Path:**
   Update the Appium and NodeJS paths in `AppiumServer`.
   ```java
   .usingDriverExecutable(new File("/path/to/node"))
   .withAppiumJS(new File("/path/to/appium"));
   ```
4. **Run tests:**
   Use TestNG to execute the tests.
   ```bash
   mvn test
   ```

---

## ✅ **Running Tests**

To execute tests, run the `testng.xml` file or use Maven commands.

```bash
mvn test
```

Test execution reports will be generated in the `reports/` folder.

---

## 📝 **Reporting**
- Test reports can be found under `reports/`.
- Integrate tools like **ExtentReports** or **Allure** for advanced reporting.

---

## 🛡️ **Best Practices Followed**
- **Single Responsibility Principle**: Each class focuses on one responsibility.
- **Reusable Components**: Utilities and readers are designed for reuse.
- **Clean Code**: Modular structure with clear naming conventions.
- **Data-Driven**: Test data managed via Excel for scalability.

---

## 🤝 **Contributing**
Contributions are welcome! Follow these steps:
1. Fork the repository.
2. Create a new branch.
3. Commit changes and open a PR.

---

## 📞 **Contact**
For support, suggestions, or queries, reach out:
- **Name**: Ahmed Ghali
- **Email**: qa.ahmedsayed@gmail.com
- **LinkedIn**: [My LinkedIn Profile](https://www.linkedin.com/in/ahmed-ghaly-a2039821a/)

---

## 🌟 **License**
This project is licensed under the **MIT License**. Feel free to use and modify!

---

## 🙌 **Acknowledgements**
- Appium Community
- TestNG Framework
- Apache POI Developers

---

Happy Testing 🚀!

-----------------
**Run Android or IOS tests -** 

If running from the testNG.xml file, then any of theses section is mandatory to redirect tests on Android or IOS
```
<parameter name="platform" value="findBy.android"/>
or  
<parameter name="platform" value="findBy.ios"/>
```

The testng.xml will trigger the TestListener class implemented methods for Driver instantiation

