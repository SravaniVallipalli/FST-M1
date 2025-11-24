@activity4
Feature: Activity to test the login feature
	Scenario: Successful login
    Given the user is on the login page
    When the user enter "admin" and "password"
    And clicks the submit button
    Then verify error message as "Welcome Back, Admin"