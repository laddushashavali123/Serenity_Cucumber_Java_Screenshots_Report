package com.lumbela.SerenityCucumberTemplate.steps;


import com.lumbela.SerenityCucumberTemplate.steps.serenity.AutomationPracticeSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AutomationPracticeDefinitionSteps {

    @Steps
    AutomationPracticeSteps automationPracticeSteps;

    /**
     * Method to open the browser
     *
     * @param
     */
    @Given("^I have opened the browser$")
    public void openBrowser() {
        // infoLog("Opening browser " + browser);
        automationPracticeSteps.setBrowserForExecution();
    }

    /**************************** AND Methods *************************/

    /**
     * Method to load the portal url
     * Navigating to the portal
     * @param
     */
    @And("^I have loaded the url$")
    public void loadURL() {
        automationPracticeSteps.loadURL();
    }

    /**
     * Method to click on Create an account button
     */
    @And("^user clicks on Create an account button$")
    public void clickOnCreateAnAccountBtn() {
        // infoLog("Clicking on button: " + uiTestPageModel.getBtnCreateAnAcc().getText());
        automationPracticeSteps.clickOnCreateAnAccountBtn();
    }

    /**
     * Filling YOUR ADDRESS fields
     */
    @And("^user fills in information in the field YOUR ADDRESS$")
    public void fillYourAddressFields() {
        //infoLog("Filling YOUR ADDRESS fields");
        automationPracticeSteps.fillYourAddressFields();
    }

    /**
     * Clicking on Register button
     */
    @And("^user clicks on Register button$")
    public void clickOnRegisterBtn() {
        // infoLog("Clciking on Register button");
        automationPracticeSteps.clickOnRegisterBtn();
    }

    /**
     * Verifying the user name
     */
    @And("^verify the username is formed by concatenating FirstName and LastName$")
    public void verifyUsername() {
        automationPracticeSteps.verifyUsername();
        // infoLog("Correct username is showing at the top");
    }

    /**
     * Verifying the Sign-out link
     */
    @And("^verify the Sign out button is present$")
    public void verifySignoutBtn() {
        // infoLog("Sign-out button is present");
        automationPracticeSteps.verifySignoutBtn();
    }

    /**
     * Checking the header MY ACCOUNT
     */
    @And("^verify that MY ACCOUNT header is present$")
    public void verifyMyAccHeader() {
        //  infoLog("MY ACCOUNT header is present");
        automationPracticeSteps.verifyMyAccHeader();
    }

    /**
     * Verifying the welcome message
     */
    @And("^verify that welcome message is also present$")
    public void verifyWelcomeMsg() {
        //   infoLog("Welcome message is present");
        automationPracticeSteps.verifyWelcomeMsg();
    }

    /**
     * Entering email
     *
     * @param
     */
    @And("^user enters email$")
    public void enterEmailAddr() {
        // infoLog("Entering email " + EMAIL);
        automationPracticeSteps.enterEmailAddr();
    }

    /**
     * Clicking on the sign-in button below the email/pass fields
     */
    @And("^Sign in button below the password field is clicked$")
    public void clickOnSignInBtnBelowPassField() {
        //infoLog("Sign in button below the passsword field is clicked");
        automationPracticeSteps.clickOnSignInBtnBelowPassField();
    }

    /**
     * Entering credentials
     */
    @And("^Email and Password are entered in the ALREADY REGISTERED section$")
    public void enterEmailAndPass() {
        // infoLog("email and password are entered in the fields");
        automationPracticeSteps.enterEmailAndPass();
    }

    /**
     * Checking out the desired product in below methods
     */
    @And("^user clicks the product with title as Faded Short Sleeve Tshirts$")
    public void selectProductWithTitleFadedShort() {
        // infoLog("User is selecting the product");
        automationPracticeSteps.selectProductWithTitleFadedShort();
    }

    @And("^user clicks on Add to cart button$")
    public void clickOnAddToCartButton() {
        // infoLog("Clicking on add to cart");
        automationPracticeSteps.clickOnAddToCartButton();
    }

    @And("^user clicks on Proceed to checkout button on overlay$")
    public void clickOnProceedToChkOutOnOverlay() {
        //infoLog("Clicking on Proceed to checkout on an overlay");
        automationPracticeSteps.clickOnProceedToChkOutOnOverlay();
    }

    @And("^user clicks on Proceed to checkout button on SHOPPING CART SUMMARY section$")
    public void clickProceedOnShoppingSummaryPage() {
        // infoLog("Clicking...");
        automationPracticeSteps.clickProceedOnShoppingSummaryPage();
    }

    @And("^user clicks on Proceed to checkout button on ADDRESSES section$")
    public void clickProceedOnAddrSection() {
        // infoLog("Clicking...");
        automationPracticeSteps.clickProceedOnAddrSection();
    }

    @And("^user agrees to the terms and conditions by clicking on the checkbox$")
    public void clickOnIAgreeChkBox() {
        // infoLog("selecting the checkbox terms");
        automationPracticeSteps.clickOnIAgreeChkBox();
    }

    @And("^user clicks on Proceed to checkout button on SHIPPING section$")
    public void clickOnProceedOnShippingSection() {
        // infoLog("clicking ....");
        automationPracticeSteps.clickOnProceedOnShippingSection();
    }

    @And("^user clicks on the payment method of Pay by bank wire$")
    public void clickOnPaymentPayByBankWire() {
        // infoLog("clicking on the payment method...");
        automationPracticeSteps.clickOnPaymentPayByBankWire();
    }

    @And("^user clicks on the button I confirm my order$")
    public void clickOnBtnIConfirmMyOrder() {
        //infoLog("I confirm ...");
        automationPracticeSteps.clickOnBtnIConfirmMyOrder();
    }

    @And("^verify that the order is complete$")
    public void verifyOrderIsComplete() {
        //infoLog("Verify order is complete ...");
        automationPracticeSteps.verifyOrderIsComplete();
    }

    @And("^verify the last breadcrumb is the current selection$")
    public void verifyLastBreadcrumb() {
        automationPracticeSteps.verifyLastBreadcrumb();
    }

    /**************************** WHEN Methods *************************/

    /**
     * Method to click on Sign in button on Home page
     */
    @When("^user clicks on Sign in button$")
    public void clickSignInOnHomePage() {
        // infoLog("Clicking on Sign in link: " + uiTestPageModel.getLinkSignin().getText());
        automationPracticeSteps.clickSignInOnHomePage();
    }

    /**
     * Method to fill all the fields of user's personal info
     */
    @When("^user fills in information in the field YOUR PERSONAL INFORMATION$")
    public void fillUserPersonalInfo() {
        //infoLog("Entering personal info");
        automationPracticeSteps.fillUserPersonalInfo();
    }

    /**
     * Clicking on the sign-in button
     */
    @When("^user clicks on Sign in button on the top$")
    public void clickOnTopSignInBtn() {
        automationPracticeSteps.clickOnTopSignInBtn();
    }

    /**
     * Selecting the category from top menu: Women
     */
    @When("^user clicks on Women option in the menu bar$")
    public void clickOnWomenOption() {
        // infoLog("User is clicking on Women section");
        automationPracticeSteps.clickOnWomenOption();
    }

    /**************************** THEN Methods *************************/

    /**
     * Verifying the URL appender
     */
    @Then("^verify that the correct appender is loaded in Url$")
    public void appConfirmationUrl() {
        // infoLog("Appender URL is loaded correctly");
        automationPracticeSteps.appConfirmationUrl();
    }

    /**
     * Verifying the URL appender
     */
    @Then("^verify that correct appender in the URL is loaded after the login$")
    public void afterLoginUrl() {
        //infoLog("Login is successful");
        automationPracticeSteps.afterLoginUrl();
    }

    /**
     * Verifying the URL appender
     */
    @Then("^verify that correct appender in the URL is loaded after placing an order$")
    public void verifyConfirmationUrlForOrder() {
        //infoLog("Verifying the url...");
        automationPracticeSteps.verifyConfirmationUrlForOrder();
    }
}
