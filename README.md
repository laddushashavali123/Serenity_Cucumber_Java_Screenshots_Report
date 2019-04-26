# serenity-cucumber-template
__The `serenity-cucumber-template` is a maven template for test automation projects.__ 

This template uses selenium, cucumber and serenity to:
 1. automate browser actions,
 2. through gherkin style (given, when, then) feature files and
 3. generate test-reports (-> mvn verify)

---  

## Feel free to fork this project as a base for your test automation projects.  

### This template includes:
 * latest drivers (chromedriver & geckodriver)
 * drivers are added to failsafe plugin
 * dependencies have been updated to latest versions
 
 
 
---  

Updated uptill 2019/12/04
---  
_This template is based on the maven serenity-cucumber-archetype, but that doesn't work out-of-the-box,  
so I've adapted it a bit :)_

TestCases :   

## Sign in
#### Preconditions
* Generated customer with all customer data
#### Test steps
* Open [Home page](http://automationpractice.com/index.php)
* Click *Sign in* button
* Fill *Email address* to create an account
* Click *Create an account* 
* Fill all fields with correct data 
* Click *Register* button
#### Assertions
* My account page(?controller=my-account) is opened
* Proper username is shown in the header
* Log out action is available

## Log in
#### Preconditions
* Existing customer
#### Test steps
* Open [Home page](http://automationpractice.com/index.php)
* Click *Sign in* button (in the header)
* Fill *Email address* in _Already registered_ block
* Fill *Password* in _Already registered_ block
* Click *Sign in* 
#### Assertions
* My account page(?controller=my-account) is opened
* Proper username is shown in the header
* Log out action is available

## Checkout
#### Preconditions
* Existing customer
* Order details
#### Test steps
* Log in as existing customer
* Click *Women* button in the header
* Click the product with name "Faded Short Sleeve T-shirts"
* Click *Add to card*
* Click *Proceed to checkout*
* Click *Proceed to checkout*
* Click *Proceed to checkout*
* Click by *Terms of service* to agree
* Click *Proceed to checkout*
* Click by payment method *Pay by bank wire*
* Click *I confirm my order*
#### Assertions
* Order confirmation page(?controller=order-confirmation) is opened
* The order is complete.
* Current page is the last step of ordering 