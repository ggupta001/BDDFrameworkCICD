Feature: Home Page Validation
@homePage
Scenario: Valid login and Home page validation
  Given User launches the application
  When User enters username and password 
  Then User is on Home Page
  When User clicks on Home button
  Then User can see the Home Profile
