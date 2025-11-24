@activity5
Feature: Data driven test with Examples

  Scenario Outline: Testing with Data from Scenario
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And clicks the submit button
    Then get the confirmation text and verify message as "Invalid credentials"
 

Examples:
	|username|password|
	|wrongAdmin|password|
	|admin|Wrongpassword|
	|@#$#|AFYUGD| 
    