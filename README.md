# Branchster Android app automation testing with Appium.

Demo automation testing framework for Branchster app.

## EnvironmentSetup
### Global Dependencies
* Install Android SDK

* Install Maven with [Homebrew](https://brew.sh/) 

 ```
$ brew install maven
```
* Install [Appium](https://appium.io)


### Connect Android device
* Connect Android device in debug mode

### Run tests

* Run tests from 'Acceptance' class 
* Or run the whole suite with command:
```
mvn test -Dsurefire.suiteXmlFiles=acceptanceGroup.xml
```
