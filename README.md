### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:

src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature files
          + search                  Feature file subdirectories 
             search_by_keyword.feature 
       + webdriver                 Bundled webdriver binaries
         + linux
         + mac
         + windows 
           chromedriver.exe       OS-specific Webdriver binaries 
           geckodriver.exe


## Executing the tests

To run the sample project, you can either just run the `CucumberTestSuite` test runner class, or run either `mvn verify` or `gradle test` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```json
$ mvn clean verify -Ddriver=chrome
```
Or 
```json
$ gradle clean test -Pdriver=chrome  -Dcucumber.options=–tags italy
```

Command to run all features from Italy

```json
example to run all features from a country
$ gradle clean test "-Dcucumber.filter.tags=@france"

example to run single test
$ gradle clean test "-Dcucumber.filter.tags=@pck1case1"
$ gradle clean test "-Dcucumber.filter.tags=@pck1case2"
```

The test results will be recorded in the `target/site/serenity` directory.

## Simplified WebDriver configuration and other Serenity extras
This project use some Serenity features which make configuring the tests easier.
In particular, Serenity uses the `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  
This configuration means that development machines and build servers do not need to have a particular version of the WebDriver drivers installed for the tests to run correctly.

You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```json
$ mvn clean verify -Denvironment=staging
```
