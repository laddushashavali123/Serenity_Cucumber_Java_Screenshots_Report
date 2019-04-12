package com.lumbela.SerenityCucumberTemplate.steps.serenity;

import com.lumbela.SerenityCucumberTemplate.pages.AutomationPracticePage;
import com.lumbela.SerenityCucumberTemplate.pages.WiktionaryPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static com.lumbela.SerenityCucumberTemplate.utils.Constant.CHROME_DRIVER_DIRECTORY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AutomationPracticeSteps {
    AutomationPracticePage automationPracticePage;

    /*@Step
    public void enters(String keyword) {
        automationPracticePage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        automationPracticePage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(automationPracticePage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_on_the_home_page() {
        System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_DIRECTORY);// "src/test/resources/drivers/chromedriver_Win.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        automationPracticePage.setDriver(new ChromeDriver(options));
        //wiktionaryPage.setDriver(REAL_DRIVER);
        automationPracticePage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }*/

   // Logger logger=new Logger(AutomationPracticePageController.class);
/*
*/
   private String PASSWORD;
    /**
     * Navigating to the portal
     */
    @Step
    public void setBrowserForExecution() {
        // logger.writeLog("INFO","The portal is opened");
        // automationPracticePage.open();
        automationPracticePage.setBrowserForExecution();
        // navigateToApplication();//(properties.getProperty("PortalUrl"));
    }

    /**************************** AND Methods *************************/
    /**
     * Method to load the portal url
     *
     * @param
     */
    @Step
    public void loadURL() {
      // logger.writeLog("INFO","Opening url .........");
        automationPracticePage.loadURL();
    }

    /**
     * Method to click on Create an account button
     */
    @Step
    public void clickOnCreateAnAccountBtn() {
      //  logger.writeLog("INFO","Clicking on button: " + AutomationPracticePageModel.getBtnCreateAnAcc().getText());
        automationPracticePage.getBtnCreateAnAcc().click();
    }

    /**
     * Filling YOUR ADDRESS fields
     */
    @Step
    public void fillYourAddressFields() {
       // logger.writeLog("INFO","Filling YOUR ADDRESS fields");
        automationPracticePage.fillYourAddressFields();
        /*getTxtBoxCompany().sendKeys(properties.getProperty("Company"));
        automationPracticePage.getTxtBoxAddress1().sendKeys(properties.getProperty("Address1"));
        automationPracticePage.getTxtBoxAddress2().sendKeys(properties.getProperty("Address2"));
        automationPracticePage.getTxtBoxCity().sendKeys(properties.getProperty("City"));
        Select select = new Select(AutomationPracticePage.getDrpDwnState());
        select.selectByVisibleText(properties.getProperty("State"));
        automationPracticePage.getTxtBoxPostCode().sendKeys(properties.getProperty("PostalCode"));
        automationPracticePage.getTxtBoxAdditionalInfo().sendKeys(properties.getProperty("AdditionalInfo"));
        automationPracticePage.getTxtBoxPhoneMobile().sendKeys(properties.getProperty("MobilePhone"));
        automationPracticePage.getTxtBoxAlias().clear();
        automationPracticePage.getTxtBoxAlias().sendKeys(properties.getProperty("Alias"));*/
    }

    /**
     * Clicking on Register button
     */
    @Step
    public void clickOnRegisterBtn() {
       // logger.writeLog("INFO","Clciking on Register button");
        automationPracticePage.getBtnRegister().click();
    }

    /**
     * Verifying the user name
     */
    @Step
    public void verifyUsername() {
      //  logger.writeLog("INFO","Correct username is showing at the top");
        automationPracticePage.verifyUsername();
    }

    /**
     * Verifying the Sign-out link
     */
    @Step
    public void verifySignoutBtn() {
        //logger.writeLog("INFO","Verifying the Sign-out link");
        automationPracticePage.verifySignoutBtn();
    }

    /**
     * Checking the header MY ACCOUNT
     */
    @Step
    public void verifyMyAccHeader() {
      //  logger.writeLog("INFO","MY ACCOUNT header is present");
        automationPracticePage.verifyMyAccHeader();
    }

    /**
     * Verifying the welcome message
     */
    @Step
    public void verifyWelcomeMsg() {
       // logger.writeLog("INFO","Welcome message is present");
       automationPracticePage.verifyWelcomeMsg();
    }

    /**
     * Entering email
     *
     * @param
     */
    @Step
    public void enterEmailAddr() {
       // logger.writeLog("INFO","Entering email " + EMAIL);
        automationPracticePage.enterEmailAddr();
    }

    /**
     * Clicking on the sign-in button below the email/pass fields
     */
    @Step
    public void clickOnSignInBtnBelowPassField() {
      //  logger.writeLog("INFO","Sign in button below the passsword field is clicked");
        automationPracticePage.clickOnSignInBtnBelowPassField();
    }

    /**
     * Entering credentials
     */
    @Step
    public void enterEmailAndPass() {
      //  logger.writeLog("INFO","email and password are entered in the fields");
        automationPracticePage.enterEmailAndPass();
    }

    /**
     * Checking out the desired product in below methods
     */
    @Step
    public void selectProductWithTitleFadedShort() {
      //  logger.writeLog("INFO","User is selecting the product");
        automationPracticePage.selectProductWithTitleFadedShort();
    }
    @Step
    public void clickOnAddToCartButton() {
      //  logger.writeLog("INFO","Clicking on add to cart");
        automationPracticePage.clickOnAddToCartButton();
    }
    @Step
    public void clickOnProceedToChkOutOnOverlay() {
      //  logger.writeLog("INFO","Clicking on Proceed to checkout on an overlay");
        automationPracticePage.clickOnProceedToChkOutOnOverlay();
    }
    @Step
    public void clickProceedOnShoppingSummaryPage() {
      //  logger.writeLog("INFO","Clicking..AutomationPracticePageModel.getBtnReviewProceedToCheckout().");
        automationPracticePage.clickProceedOnShoppingSummaryPage();
    }
    @Step
    public void clickProceedOnAddrSection() {
       // logger.writeLog("INFO","Clicking..AutomationPracticePageModel.getBtnProcessAddress().");
      automationPracticePage.clickProceedOnAddrSection();
    }
    @Step
    public void clickOnIAgreeChkBox() {
     //   logger.writeLog("INFO","selecting the checkbox terms");
        automationPracticePage.clickOnIAgreeChkBox();
    }
    @Step
    public void clickOnProceedOnShippingSection() {
       // logger.writeLog("INFO","clicking ...AutomationPracticePageModel.getBtnProcessCarrier().");
        automationPracticePage.clickOnProceedOnShippingSection();
    }
    @Step
    public void clickOnPaymentPayByBankWire() {
     //   logger.writeLog("INFO","clicking on the payment method...");
        automationPracticePage.clickOnPaymentPayByBankWire();
    }
    @Step
    public void clickOnBtnIConfirmMyOrder() {
        //logger.writeLog("INFO","I confirm ...");
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
       // logger.writeLog("INFO","Clicking on Sign in link: " + AutomationPracticePageModel.getLinkSignin().getText());
        //waitForElementToBeVisible(By.cssSelector(".login"));
        automationPracticePage.clickSignInOnHomePage();
    }

    /**
     * Method to fill all the fields of user's personal info
     */
    @Step
    public void fillUserPersonalInfo() {
        //logger.writeLog("INFO","Entering personal info");
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
        //logger.writeLog("INFO","User is clicking on Women section");
        automationPracticePage.clickOnWomenOption();
    }

    /**************************** THEN Methods *************************/

    /**
     * Verifying the URL appender
     */
    @Step
    public void appConfirmationUrl() {
      //  logger.writeLog("INFO","Appender URL is loaded correctly");
        automationPracticePage.ConfirmationAppUrl();
    }

    /**
     * Verifying the URL appender
     */
    @Step
    public void afterLoginUrl() {
       // logger.writeLog("INFO","Login is successful");
        automationPracticePage.afterLoginUrl();
    }

    /**
     * Verifying the URL appender
     */
    @Step
    public void verifyConfirmationUrlForOrder() {
       // logger.writeLog("INFO","Verifying the url...");
        automationPracticePage.verifyConfirmationUrlForOrder();
    }
}
