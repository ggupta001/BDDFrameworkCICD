Feature: Login functionality

  Scenario Outline: Valid login to application
    Given User launches the application
    When User enters username "<username>" and password "<password>"
    Then User should land on Home Page

    Examples:
      | username 			| password  		|
      | student    		| Password123  	|
      | incorrectUser | Password123   |
      | student			  | Passwor123    |