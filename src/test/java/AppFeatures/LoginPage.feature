Feature: Login Page Feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"
 
 Scenario: Forgot Password Link
 Given user is on login page
 Then forgot your password link should be display
 
 Scenario: Login with correct credentials
 Given user is on login page
 When user enters username "abhishek.deshpande04@gmail.com"
 And user enters password "Abcd@1234"
 And user clicks on Login button
Then user gets the title of the page
 And page title should be "My account - My Store123"