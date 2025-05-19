# Sauce Selenium Automation

This project demonstrates how to set up and run Selenium WebDriver tests for the [Sauce Demo](https://www.saucedemo.com/) website using Java and Maven.

## 🚀 Project Goals

- Set up Selenium WebDriver in a Maven-based Java project
- Configure and run automated browser tests
- Gain hands-on experience interacting with a test web application
- Execute the first test script successfully in the browser

---

## 🛠️ Tech Stack

- **Java** 21
- **Selenium WebDriver**
- **JUnit 5**
- **Maven**
- **Web Browsers**: Microsoft Edge, Safari (optional)

---

## ✅ Prerequisites

Make sure you have the following installed:

- [Java JDK 17+](https://adoptium.net/)
- [Apache Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- A supported browser (e.g. Microsoft Edge, Safari)

---


## 📂 Project Structure
```
src
├── main
│   └── java
│       └── com.sauceDemo.app.App.java
└── test
    └── java
        └── com.sauceDemo.app.AppTest.java
```

## 🏁 How It Started

I initially ran a simple Java file with:

```bash
java -cp target/selenium-1.0-SNAPSHOT.jar com.sauceDemo.app.App
```
Build the project 
```bash
mvn package 
```
or
```
mvn clean install
```

## 📦 Setup Instructions


1. **Clone the repository**
   ```bash
   git clone https://github.com/cynthia7125/sauce-selenium.git
   cd sauce-selenium

## 🧪 Running the Tests

1. **Run all tests:**
```bash
mvn test
```

2. **Run a specific test:**
```bash
mvn -Dtest=AppTest test
```

