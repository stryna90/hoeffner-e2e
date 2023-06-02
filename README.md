# Hoeffner E2E Tests

End to End regression tests for Hoeffner project.

# How to generate Allure report

1. Download lastes version as ZIP archive from https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/
2. Unpack the archive to any directory
3. Go to "Edit environment varaibles" and add allure to Path ("andDirectory\allure-2.22.1\bin)
4. Run set of tests
5. Open terminal and naviate to \hoeffner-e2e\target\allure-results
6. For a simple generation of report type "allure serve ."