Feature: OrangeHrm
@Loginsingledata
Scenario: validate login test
Given Launch in chrome browser
When Enter user name and Enter password
When Click on login button
Then verify url
Then close browser
@Loginmultipledata
Scenario Outline: validate login with multiple data
Given launch url in "<Browser>" 
When user enter "<Username>" in username textbox field
When user enter "<Password>" in password textbox field
When user click on login button
Then user verify url text
Then user close browser
Examples:
|Browser|Username|Password|
|chrome|Admin|Qedge123!@#|
|firefox|Admin|Qedge123!@#|
|chrome|Admn|Qedge123!@#|
|firefox|Admin|Qedge23!@#|
|chrome|Admin|Qedge123!@#|
|firefox|Admin|Qedge123!@#|
|chrome|dmin|Qedge123!@#|
|firefox|Admin|Qedge123!@#|

