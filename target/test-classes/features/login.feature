@Login
Feature: Login on OrangeHRM

As a new user
I want to login
So that...

Scenario: Successful Login with Valid Credentials
Given User is on LoginPage of OrangeHRM "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
When User enters the required data "<UserName>" "<Password>"
Then Is displayed the Dashboard Page

Examples:
|UserName|Password|
|Admin|	admin123|