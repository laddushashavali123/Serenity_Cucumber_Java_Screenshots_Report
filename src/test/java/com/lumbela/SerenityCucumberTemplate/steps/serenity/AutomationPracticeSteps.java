package com.lumbela.SerenityCucumberTemplate.steps.serenity;

import com.lumbela.SerenityCucumberTemplate.pages.AutomationPracticePage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationPracticeSteps {
    AutomationPracticePage automationPracticePage;

   private String PASSWORD;
    /**
     * Navigating to the portal
     */
    @Step
    public void setBrowserForExecution() {

        automationPracticePage.setBrowserForExecution();
    }

    /**************************** AND Methods *************************/
    /**
     * Method to load the portal url
     *
     * @param
     */
    @Step
    public void loadURL() {
        automationPracticePage.loadURL();
    }

    /**
     * Method to click on Create an account button
     */
    @Step
    public void clickOnCreateAnAccountBtn() {
        automationPracticePage.getBtnCreateAnAcc().click();
    }

    /**
     * Filling YOUR ADDRESS fields
     */
    @Step
    public void fillYourAddressFields() {
        automationPracticePage.fillYourAddressFields();
    }

    /**
     * Clicking on Register button
     */
    @Step
    public void clickOnRegisterBtn() {
        automationPracticePage.getBtnRegister().click();
    }

    /**
     * Verifying the user name
     */
    @Step
    public void verifyUsername() {
        automationPracticePage.verifyUsername();
    }

    /**
     * Verifying the Sign-out link
     */
    @Step
    public void verifySignoutBtn() {
        automationPracticePage.verifySignoutBtn();
    }

    /**
     * Checking the header MY ACCOUNT
     */
    @Step
    public void verifyMyAccHeader() {
        automationPracticePage.verifyMyAccHeader();
    }

    /**
     * Verifying the welcome message
     */
    @Step
    public void verifyWelcomeMsg() {
       automationPracticePage.verifyWelcomeMsg();
    }

    /**
     * Entering email
     *
     * @param
     */
    @Step
    public void enterEmailAddr() {
        automationPracticePage.enterEmailAddr();
    }

    /**
     * Clicking on the sign-in button below the email/pass fields
     */
    @Step
    public void clickOnSignInBtnBelowPassField() {
       automationPracticePage.clickOnSignInBtnBelowPassField();
    }

    /**
     * Entering credentials
     */
    @Step
    public void enterEmailAndPass() {
        automationPracticePage.enterEmailAndPass();
    }

    /**
     * Checking out the desired product in below methods
     */
    @Step
    public void selectProductWithTitleFadedShort() {
        automationPracticePage.selectProductWithTitleFadedShort();
    }
    @Step
    public void clickOnAddToCartButton() {
        automationPracticePage.clickOnAddToCartButton();
    }
    @Step
    public void clickOnProceedToChkOutOnOverlay() {
        automationPracticePage.clickOnProceedToChkOutOnOverlay();
    }
    @Step
    public void clickProceedOnShoppingSummaryPage() {
        automationPracticePage.clickProceedOnShoppingSummaryPage();
    }
    @Step
    public void clickProceedOnAddrSection() {
      automationPracticePage.clickProceedOnAddrSection();
    }
    @Step
    public void clickOnIAgreeChkBox() {
        automationPracticePage.clickOnIAgreeChkBox();
    }
    @Step
    public void clickOnProceedOnShippingSection() {
        automationPracticePage.clickOnProceedOnShippingSection();
    }
    @Step
    public void clickOnPaymentPayByBankWire() {
        automationPracticePage.clickOnPaymentPayByBankWire();
    }
    @Step
    public void clickOnBtnIConfirmMyOrder() {
        automationPracticePage.clickOnBtnIConfirmMyOrder();
    }
    @Step
    public void verifyOrderIsComplete() {
       automationPracticePage.verifyOrderIsComplete();
    }
    @Step
    public void verifyLastBreadcrumb() {
        automationPracticePage.verifyLastBreadcrumb();
    }

    /**************************** WHEN Methods *************************/
    /**
     * Method to click on Sign in button on Home page
     */
    @Step
    public void clickSignInOnHomePage() {
        automationPracticePage.clickSignInOnHomePage();
    }

    /**
     * Method to fill all the fields of user's personal info
     */
    @Step
    public void fillUserPersonalInfo() {
        automationPracticePage.fillUserPersonalInfo();
    }

    /**
     * Clicking on the sign-in button
     */
    @Step
    public void clickOnTopSignInBtn() {
        automationPracticePage.clickOnTopSignInBtn();
    }

    /**
     * Selecting the category from top menu: Women
     */
    @Step
    public void clickOnWomenOption() {
        automationPracticePage.clickOnWomenOption();
    }

    /**************************** THEN Methods *************************/

    /**
     * Verifying the URL appender
     */
    @Step
    public void appConfirmationUrl() {
        automationPracticePage.ConfirmationAppUrl();
    }

    /**
     * Verifying the URL appender
     */
    @Step
    public void afterLoginUrl() {
        automationPracticePage.afterLoginUrl();
    }

    /**
     * Verifying the URL appender
     */
    @Step
    public void verifyConfirmationUrlForOrder() {
        automationPracticePage.verifyConfirmationUrlForOrder();
    }
}
