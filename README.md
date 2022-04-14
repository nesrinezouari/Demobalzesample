# RestAssuredSerenityCucumber Framework

This is a sample Rest API test solution for sample endpoints available in https://restful-booker.herokuapp.com/apidoc/index.html The published APIs represent a booking system where user can create, update and cancel bookings.

Tests are written using a combination of SerenityBDD, RestAssured, Cucumber, Junit & Maven.

## Technology Stack

- Java
- Serenity BDD
- Maven
- Cucumber

## Prerequisites

* [Java 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java Dev Kit
* [Maven](https://maven.apache.org/download.cgi) - Dependency Manager

## Application Under Test

We are using Restful-Booker APIs as the Application Under Test.

* URL : https://restful-booker.herokuapp.com/

## The project directory structure
The project follows the standard directory structure used in most Serenity projects:

```Gherkin
src
  + main
    + java
      + configuration              configuration of driver Remote and local             
      + entity                     enum ..
      + helper                     commun fonctionalities
      + Page                       Page Object Pattern
  + test
    + java                          
      + features.steps                steps class
      + features.steps.serenity       stepdefinition implementation 
      + acceptancestests            test runner
      + stepdefinitions             Step definitions for the BDD feature
      
    + resources
      + features                  Feature files
      + serenity.conf             serenity configuration (environement url.)
serenity.properties        configuration file to handel Global configuration and can be choosed from maven command "mvn run 	clean verify  -Denvironment=taging -Dwebdriver.provided.type=chrometype"
    
```
Following instructions will help you running the project. First, clone this project locally on your machine from the master branch.

### Installation and Test Execution

Open the project in any IDE Eclipse/IntelliJ. Run the following command in Terminal and build the project. It will automatically download all the required dependencies.

```sh
$ mvn clean install
```

### Execute Tests

Run the following command in Terminal to execute tests.
we specify environment from serenity.conf, type of browser defined on serenity.properties ..

```sh
$ clean verify  -Denvironment=staging -Dwebdriver.provided.type=chrometype

```
###
Custom framework , this implementation can be used for more than two products and when we have more that product on order .

### Managing driver 
we use Dependency bonigarcia to autodetected browser version and download according driver ,
We use @Manage serenity annotation to take serenity handel driver instance ( no need to kill browser manually after test)


by default on serenity.properties i have chosen to make browser maxized  serenity.browser.maximized = true, we can use this property on maven run project and set it to false , we can also add widh and height properties 
### Test Report

You can find the Serenity reports in the following directory of the Project.

```sh
\target\site\serenity\
```


