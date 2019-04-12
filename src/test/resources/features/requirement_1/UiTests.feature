@web
Feature: This feature file contains the Test Scenarios for GFK Assignment, includes (Signup, Login and Checkout): Portal: "http://automationpractice.com/index.php"

@SignUp
Scenario: Sign up to the portal
	Given I have opened the browser
	And I have loaded the url
	When user clicks on Sign in button
	And user enters email
	And user clicks on Create an account button
	When user fills in information in the field YOUR PERSONAL INFORMATION
	And user fills in information in the field YOUR ADDRESS
	And user clicks on Register button
	Then verify that the correct appender is loaded in Url
	And verify the username is formed by concatenating FirstName and LastName
	And verify the Sign out button is present
	And verify that MY ACCOUNT header is present
	And verify that welcome message is also present
	
	@Login
Scenario: Log in to the portal
    Given I have opened the browser
	And I have loaded the url
	When user clicks on Sign in button on the top
	And Email and Password are entered in the ALREADY REGISTERED section
	And Sign in button below the password field is clicked
	Then verify that correct appender in the URL is loaded after the login
	And verify the username is formed by concatenating FirstName and LastName
	And verify the Sign out button is present
	
@Checkout
Scenario: Check out the order
	Given I have opened the browser
	And I have loaded the url
	When user clicks on Sign in button on the top
	And Email and Password are entered in the ALREADY REGISTERED section
	And Sign in button below the password field is clicked
	Then verify that correct appender in the URL is loaded after the login
	When user clicks on Women option in the menu bar
	And user clicks the product with title as Faded Short Sleeve Tshirts
	And user clicks on Add to cart button
	And user clicks on Proceed to checkout button on overlay
	And user clicks on Proceed to checkout button on SHOPPING CART SUMMARY section
	And user clicks on Proceed to checkout button on ADDRESSES section
	And user agrees to the terms and conditions by clicking on the checkbox
	And user clicks on Proceed to checkout button on SHIPPING section
	And user clicks on the payment method of Pay by bank wire
	And user clicks on the button I confirm my order
	Then verify that correct appender in the URL is loaded after placing an order
	And verify that the order is complete
	And verify the last breadcrumb is the current selection