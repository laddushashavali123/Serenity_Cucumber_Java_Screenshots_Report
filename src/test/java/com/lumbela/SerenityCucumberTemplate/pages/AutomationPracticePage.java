package com.lumbela.SerenityCucumberTemplate.pages;

import com.lumbela.SerenityCucumberTemplate.hooks.DriverClass;
import com.lumbela.SerenityCucumberTemplate.utils.WebDriverUtils;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.lumbela.SerenityCucumberTemplate.utils.Utilities.generateRandomEmail;
import static com.lumbela.SerenityCucumberTemplate.utils.Utilities.loadProperties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class contains locators for UI tests
 *
 * @author laddu shashavali
 */
@DefaultUrl("/index.php")
public class AutomationPracticePage extends DriverClass {
    private Properties properties = loadProperties();
    private WebDriver driver = getBrowser(properties.getProperty("browser"));
    /**
     * Locator for link: "Sign in"
     */
    @FindBy(xpath = "//*[@class='login']")//".login")
    private static WebElement linkSignin;

    /**
     * Locator for textbox: "Create An Account"
     */
    @FindBy(css = "#email_create")
    private static WebElement txtBoxCreateAcc;

    /**
     * Locator for button: "Create an account"
     */
    @FindBy(css = "#SubmitCreate")
    private static WebElement btnCreateAnAcc;

    /**
     * Locator for Radio button: "Mr."
     */
    @FindBy(xpath = "//*[@id='uniform-id_gender1' and @class='radio']/span/input")
    private static WebElement rdBtnMr;

    /**
     * Locator for Radio button: "Mrs."
     */
    @FindBy(xpath = "//*[@id='uniform-id_gender2' and @class='radio']/span/input")
    private static WebElement rdBtnMrs;

    /**
     * Locator for Text box: "First Name"
     */
    @FindBy(css = "#customer_firstname")
    private static WebElement txtBoxFirstName;

    /**
     * Locator for Text box: "Last Name"
     */
    @FindBy(css = "#customer_lastname")
    private static WebElement txtBoxLastName;

    /**
     * Locator for Text box: "Password"
     */
    @FindBy(css = "#passwd")
    private static WebElement txtBoxPassword;

    /**
     * Locator for dropdown: "days"
     */
    @FindBy(css = "#days")
    private static WebElement drpDwnDays;

    /**
     * Locator for dropdown: "months"
     */
    @FindBy(css = "#months")
    private static WebElement drpDwnMonths;

    /**
     * Locator for dropdown: "years"
     */
    @FindBy(css = "#years")
    private static WebElement drpDwnYears;

    /**
     * Locator for Text box: "Company"
     */
    @FindBy(css = "#company")
    private static WebElement txtBoxCompany;

    /**
     * Locator for Text box: "Address1"
     */
    @FindBy(css = "#address1")
    private static WebElement txtBoxAddress1;

    /**
     * Locator for Text box: "Address2"
     */
    @FindBy(css = "#address2")
    private static WebElement txtBoxAddress2;

    /**
     * Locator for Text box: "City"
     */
    @FindBy(css = "#city")
    private static WebElement txtBoxCity;

    /**
     * Locator for Dropdown: "State"
     */
    @FindBy(css = "#id_state")
    private static WebElement drpDwnState;

    /**
     * Locator for Text box: "Zip/Postal Code"
     */
    @FindBy(css = "#postcode")
    private static WebElement txtBoxPostCode;

    /**
     * Locator forDropdown: "Country"
     */
    @FindBy(css = "id_country")
    private static WebElement drpDwnCountry;

    /**
     * Locator for Text box: "Additional information"
     */
    @FindBy(xpath = "//*[@class='form-control' and @name='other']")
    private static WebElement txtBoxAdditionalInfo;

    /**
     * Locator for Text box: "Home phone"
     */
    @FindBy(css = "#phone")
    private static WebElement txtBoxHomePhone;

    /**
     * Locator for Text box: "Mobile phone"
     */
    @FindBy(css = "#phone_mobile")
    private static WebElement txtBoxPhoneMobile;

    /**
     * Locator for Text box: "Assign an address alias for future reference."
     */
    @FindBy(css = "#alias")
    private WebElement txtBoxAlias;

    /**
     * Locator for Button: "Register"
     */
    @FindBy(css = "#submitAccount")
    private WebElement btnRegister;

    /**
     * Locator for Label: "My Account"
     */
    @FindBy(css = ".page-heading")
    private WebElement lblMyAccount;

    /**
     * Locator for link: "firstname lastname"
     */
    @FindBy(css = ".account")
    private WebElement linkUserName;

    /**
     * Locator for Label: "Welcome to your account. Here you can manage all of
     * your personal information and orders."
     */
    @FindBy(css = ".info-account")
    private static WebElement lblSubHeading;

    /**
     * Locator for Link: "Sign out"
     */
    @FindBy(css = ".logout")
    private static WebElement linkSignOut;

    /**
     * Locator for Text box: "Email address"
     */
    @FindBy(css = "#email")
    private static WebElement txtBoxEmail;

    /**
     * Locator for Button: "Sign in"
     */
    @FindBy(css = "#SubmitLogin")
    private static WebElement btnSignIn;

    /**
     * Locator for Menu Link: "Women"
     */
    @FindBy(linkText = "Women")
    private static WebElement linkWomen;

    /**
     * Locator for Link block: "Faded Short Sleeve T-shirts"
     */
    @FindBy(css = ".product_list.grid.row>li:first-child .right-block .product-name")
    private static WebElement LinkFadedShortTShirt;

    /**
     * Locator for Button: "Add to Cart"
     */
    @FindBy(css = "[name='Submit']")
    private static WebElement BtnAddToCart;

    /**
     * Locator for Button: "Proceed To Checkout"
     */
    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    private static WebElement btnProceedToCheckout;

    /**
     * Locator for Button on review order: "Proceed to checkout"
     */
    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    private static WebElement btnReviewProceedToCheckout;

    /**
     * Locator for Button - processAddress: "Proceed to checkout"
     */
    //*[@name='processAddress' and @type='submit']//*[text()='Proceed to checkout']
    @FindBy(xpath = "//*[@name='processAddress' and @type='submit']/span[text()='Proceed to checkout']")
    private static WebElement btnProcessAddress;

    /**
     * Locator for Checkbox: "I agree to the terms of service and will adhere to
     * them unconditionally. (Read the Terms of Service)"
     */
    @FindBy(xpath = "//*[@name='cgv' and @id='cgv']")
    private static WebElement chkBoxIAgree;

    /**
     * Locator for Button: "Proceed to checkout"
     */
    @FindBy(css = "[name='processCarrier']")
    private static WebElement btnProcessCarrier;

    /**
     * Locator for Link: "Pay by bank wire"
     */
    @FindBy(css = ".bankwire")
    private static WebElement LinkBankWire;

    /**
     * Locator for Button: "I confirm my order"
     */
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private static WebElement btnIConfirmMyOrder;

    /**
     * Locator for Breadcrumb: "Shipping"
     */
    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    private static WebElement LinkShippingBrdCrmb;

    /**
     * Locator for Breadcrumb: "Payment"
     */
    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    private static WebElement linkPaymentBrdCrmb;

    /**
     * Locator for label message: "Your order on My Store is complete."
     */
    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    private static WebElement lblOrderIsComplete;

    /**
     * Locator for label error message: "An account using this email address has already been registered. Please enter a valid password or request a new one."
     */
    @FindBy(css = "#create_account_error")
    private static WebElement lblErrorMsgPanel;

    /**
     * Locator for button: "Add to cart"
     */
    @FindBy(css = ".button-container>span")
    private static WebElement btnAddToCartOnMouseAction;

    /**
     * Locator for label: "Payment"
     */
    @FindBy(css = ".step_current.last")
    private static WebElement lblPaymentBrdCrmb;
    private String PASSWORD;

    // --------------Getters----------------

    /**
     * Locator for label: "Payment"
     *
     * @return lblPaymentBrdCrmb
     */
    public static WebElement getLblPaymentBrdCrmb() {
        return lblPaymentBrdCrmb;
    }

    /**
     * Locator for button: "Add to cart"
     *
     * @return btnAddToCartOnMouseAction
     */
    public static WebElement getBtnAddToCartOnMouseAction() {
        return btnAddToCartOnMouseAction;
    }

    /**
     * Locator for label error message: "An account using this email address has already been registered. Please enter a valid password or request a new one."
     *
     * @return lblErrorMsgPanel
     */
    public static WebElement getLblErrorMsgPanel() {
        return lblErrorMsgPanel;
    }

    /**
     * Locator for label message: "Your order on My Store is complete."
     *
     * @return lblOrderIsComplete
     */
    public static WebElement getLblOrderIsComplete() {
        return lblOrderIsComplete;
    }

    /**
     * Locator for Breadcrumb: "Payment"
     *
     * @return linkPaymentBrdCrmb
     */
    public static WebElement getLinkPaymentBrdCrmb() {
        return linkPaymentBrdCrmb;
    }

    /**
     * Locator for Breadcrumb: "Shipping"
     *
     * @return LinkShippingBrdCrmb
     */
    public static WebElement getLinkShippingBrdCrmb() {
        return LinkShippingBrdCrmb;
    }

    /**
     * Locator for Button: "I confirm my order"
     *
     * @return btnIConfirmMyOrder
     */
    public static WebElement getBtnIConfirmMyOrder() {
        return btnIConfirmMyOrder;
    }

    /**
     * Locator for Link: "Pay by bank wire"
     *
     * @return LinkBankWire
     */
    public static WebElement getLinkBankWire() {
        return LinkBankWire;
    }

    /**
     * Locator for Button: "Proceed to checkout"
     *
     * @return btnProcessCarrier
     */
    public static WebElement getBtnProcessCarrier() {
        return btnProcessCarrier;
    }

    /**
     * Locator for Checkbox: "I agree to the terms of service and will adhere to
     * them unconditionally. (Read the Terms of Service)"
     *
     * @return chkBoxIAgree
     */
    public static WebElement getChkBoxIAgree() {
        return chkBoxIAgree;
    }

    /**
     * Locator for Button - processAddress: "Proceed to checkout"
     *
     * @return btnProcessAddress
     */
    public static WebElement getBtnProcessAddress() {
        return btnProcessAddress;
    }

    /**
     * Locator for Button on review order: "Proceed to checkout"
     *
     * @return btnReviewProceedToCheckout
     */
    public static WebElement getBtnReviewProceedToCheckout() {
        return btnReviewProceedToCheckout;
    }

    /**
     * Locator for Button: "Proceed To Checkout"
     *
     * @return btnProceedToCheckout
     */
    public static WebElement getBtnProceedToCheckout() {

        return btnProceedToCheckout;
    }

    /**
     * Locator for Button: "Add to Cart"
     *
     * @return BtnAddToCart
     */
    public static WebElement getBtnAddToCart() {
        return BtnAddToCart;
    }

    /**
     * Locator for Link block: "Faded Short Sleeve T-shirts"
     *
     * @return LinkFadedShortTShirt
     */
    public static WebElement getLinkFadedShortTShirt() {
        return LinkFadedShortTShirt;
    }

    /**
     * Locator for Menu Link: "Women"
     *
     * @return linkWomen
     */
    public static WebElement getLinkWomen() {
        return linkWomen;
    }

    /**
     * Locator for Button: "Sign in"
     *
     * @return btnSignIn
     */
    public static WebElement getBtnSignIn() {
        return btnSignIn;
    }

    /**
     * Locator for Text box: "Email address"
     *
     * @return txtBoxEmail
     */
    public static WebElement getTxtBoxEmail() {
        return txtBoxEmail;
    }

    /**
     * Locator for Link: "Sign out"
     *
     * @return linkSignOut
     */
    public static WebElement getLinkSignOut() {
        return linkSignOut;
    }

    /**
     * Locator for Label: "Welcome to your account. Here you can manage all of
     * your personal information and orders."
     *
     * @return lblSubHeading
     */
    public static WebElement getLblSubHeading() {
        return lblSubHeading;
    }

    /**
     * Locator for link: "firstname lastname"
     *
     * @return linkUserName
     */
    public WebElement getLinkUserName() {
        return linkUserName;
    }

    /**
     * Locator for Label: "My Account"
     *
     * @return lblMyAccount
     */
    public WebElement getLblMyAccount() {
        return lblMyAccount;
    }

    /**
     * Locator for Button: "Register"
     *
     * @return btnRegister
     */
    public WebElement getBtnRegister() {
        return btnRegister;
    }

    /**
     * Locator for Text box: "Assign an address alias for future reference."
     *
     * @return txtBoxAlias
     */
    public WebElement getTxtBoxAlias() {
        return txtBoxAlias;
    }

    /**
     * Locator for Text box: "Mobile phone"
     *
     * @return txtBoxPhoneMobile
     */
    public WebElement getTxtBoxPhoneMobile() {
        return txtBoxPhoneMobile;
    }

    /**
     * Locator for Text box: "Home phone"
     *
     * @return txtBoxHomePhone
     */
    public WebElement getTxtBoxHomePhone() {
        return txtBoxHomePhone;
    }

    /**
     * Locator for Text box: "Additional information"
     *
     * @return txtBoxAdditionalInfo
     */
    public WebElement getTxtBoxAdditionalInfo() {
        return txtBoxAdditionalInfo;
    }

    /**
     * Locator forDropdown: "Country"
     *
     * @return drpDwnCountry
     */
    public WebElement getDrpDwnCountry() {
        return drpDwnCountry;
    }

    /**
     * Locator for Text box: "Zip/Postal Code"
     *
     * @return txtBoxPostCode
     */
    public WebElement getTxtBoxPostCode() {
        return txtBoxPostCode;
    }

    /**
     * Locator for Dropdown: "State"
     *
     * @return drpDwnState
     */
    public WebElement getDrpDwnState() {
        return drpDwnState;
    }

    /**
     * Locator for Text box: "City"
     *
     * @return txtBoxCity
     */
    public WebElement getTxtBoxCity() {
        return txtBoxCity;
    }

    /**
     * Locator for Text box: "Address2"
     *
     * @return txtBoxAddress2
     */
    public WebElement getTxtBoxAddress2() {
        return txtBoxAddress2;
    }

    /**
     * Locator for Text box: "Address1"
     *
     * @return txtBoxAddress1
     */
    public WebElement getTxtBoxAddress1() {
        return txtBoxAddress1;
    }

    /**
     * Locator for Text box: "Company"
     *
     * @return txtBoxCompany
     */
    public WebElement getTxtBoxCompany() {
        return txtBoxCompany;
    }

    /**
     * Locator for dropdown: "years"
     *
     * @return drpDwnYears
     */
    public WebElement getDrpDwnYears() {
        return drpDwnYears;
    }

    /**
     * Locator for dropdown: "months"
     *
     * @return drpDwnMonths
     */
    public WebElement getDrpDwnMonths() {
        return drpDwnMonths;
    }

    /**
     * Locator for dropdown: "days"
     *
     * @return drpDwnDays
     */
    public WebElement getDrpDwnDays() {
        return drpDwnDays;
    }

    /**
     * Locator for Text box: "Password"
     *
     * @return txtBoxPassword
     */
    public WebElement getTxtBoxPassword() {
        return txtBoxPassword;
    }

    /**
     * Locator for Text box: "Last Name"
     *
     * @return txtBoxLastName
     */
    public WebElement getTxtBoxLastName() {
        return txtBoxLastName;
    }

    /**
     * Locator for Text box: "First Name"
     *
     * @return txtBoxFirstName
     */
    public WebElement getTxtBoxFirstName() {
        return txtBoxFirstName;
    }

    /**
     * Locator for Radio button: "Mrs."
     *
     * @return rdBtnMrs
     */
    public WebElement getRdBtnMrs() {
        return rdBtnMrs;
    }

    /**
     * Locator for Radio button: "Mr."
     *
     * @return rdBtnMr
     */
    public WebElement getRdBtnMr() {
        return rdBtnMr;
    }

    /**
     * Locator for button: "Create an account"
     *
     * @return btnCreateAnAcc
     */
    public WebElement getBtnCreateAnAcc() {
        return btnCreateAnAcc;
    }

    /**
     * Locator for textbox: "Create An Account"
     *
     * @return txtBoxCreateAcc
     */
    public WebElement getTxtBoxCreateAcc() {
        return txtBoxCreateAcc;
    }

    /**
     * Locator for link: "Sign in"
     *
     * @return linkSignin
     */
    public WebElement getLinkSignin() {
        return linkSignin;
    }


    public void setBrowserForExecution() {
        System.out.println("Company: " + properties.getProperty("browser"));
        setDriver(driver);
    }

    public void loadURL() {
        open();
    }

    public void fillYourAddressFields() {
        // logger.writeLog("INFO","Filling YOUR ADDRESS fields");
        getTxtBoxCompany().sendKeys(properties.getProperty("Company"));
        getTxtBoxAddress1().sendKeys(properties.getProperty("Address1"));
        getTxtBoxAddress2().sendKeys(properties.getProperty("Address2"));
        getTxtBoxCity().sendKeys(properties.getProperty("City"));
        Select select = new Select(getDrpDwnState());
        select.selectByVisibleText(properties.getProperty("State"));
        getTxtBoxPostCode().sendKeys(properties.getProperty("PostalCode"));
        getTxtBoxAdditionalInfo().sendKeys(properties.getProperty("AdditionalInfo"));
        getTxtBoxPhoneMobile().sendKeys(properties.getProperty("MobilePhone"));
        getTxtBoxAlias().clear();
        getTxtBoxAlias().sendKeys(properties.getProperty("Alias"));
    }

    public void verifyUsername() {
        //  logger.writeLog("INFO","Correct username is showing at the top");
        assertEquals(getLinkUserName().getText(), properties.getProperty("UserName"));
    }

    public void verifySignoutBtn() {
        //logger.writeLog("INFO","Verifying the Sign-out link");
        assertTrue(getLinkSignOut().isDisplayed());
    }

    public void verifyMyAccHeader() {
        //  logger.writeLog("INFO","MY ACCOUNT header is present");
        assertEquals(getLblMyAccount().getText(), properties.getProperty("HeaderMyAccountText"));
    }

    public void verifyWelcomeMsg() {
        // logger.writeLog("INFO","Welcome message is present");
        assertEquals(getLblSubHeading().getText(), properties.getProperty("WelcomeText"));
        getLinkSignOut().click();
    }

    public void enterEmailAddr() {
        String EMAIL = generateRandomEmail();
        // logger.writeLog("INFO","Entering email " + EMAIL);
        getTxtBoxCreateAcc().sendKeys(EMAIL);
    }

    public void clickOnSignInBtnBelowPassField() {
        //  logger.writeLog("INFO","Sign in button below the passsword field is clicked");
        getBtnSignIn().click();
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        if (webDriverUtils.isElementDisplayed(getLblErrorMsgPanel())) {
            getTxtBoxCreateAcc().sendKeys(generateRandomEmail());
        } else {
            //  logger.writeLog("INFO","Sign in is successfull");
        }
    }

    public void enterEmailAndPass() {
        //  logger.writeLog("INFO","email and password are entered in the fields");
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.waitForElementToBeVisible(By.cssSelector("#email"));
        getTxtBoxEmail().sendKeys(properties.getProperty("AlreadyRegisteredEmail"));
        getTxtBoxPassword().sendKeys(properties.getProperty("Password"));
    }

    public void selectProductWithTitleFadedShort() {
        //  logger.writeLog("INFO","User is selecting the product");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,900)", "");
        getLinkFadedShortTShirt().click();
    }

    public void clickOnAddToCartButton() {
        //  logger.writeLog("INFO","Clicking on add to cart");
        getBtnAddToCart().click();
    }

    public void clickOnProceedToChkOutOnOverlay() {
        //  logger.writeLog("INFO","Clicking on Proceed to checkout on an overlay");
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.waitForVisibilityOfElement(getBtnProceedToCheckout());
        getBtnProceedToCheckout().click();
    }

    public void clickProceedOnShoppingSummaryPage() {
        //  logger.writeLog("INFO","Clicking..AutomationPracticePageModel.getBtnReviewProceedToCheckout().");
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.waitForVisibilityOfElement(getBtnReviewProceedToCheckout());
        getBtnReviewProceedToCheckout().click();
    }

    public void clickProceedOnAddrSection() {
        // logger.writeLog("INFO","Clicking..AutomationPracticePageModel.getBtnProcessAddress().");
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.scrollToElement(getBtnProcessAddress());
        webDriverUtils.actionClick(getBtnProcessAddress());
    }

    public void clickOnIAgreeChkBox() {
        //   logger.writeLog("INFO","selecting the checkbox terms");
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.scrollToElement(getChkBoxIAgree());

        getChkBoxIAgree().click();
    }

    public void clickOnProceedOnShippingSection() {
        // logger.writeLog("INFO","clicking ...AutomationPracticePageModel.getBtnProcessCarrier().");
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.scrollToElement(getBtnProcessCarrier());
        webDriverUtils.waitForElementDisplayed(getBtnProcessCarrier());
        getBtnProcessCarrier().click();
    }

    public void clickOnPaymentPayByBankWire() {
        //   logger.writeLog("INFO","clicking on the payment method...");
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.waitForElementDisplayed(getLinkBankWire());
        getLinkBankWire().click();
    }

    public void clickOnBtnIConfirmMyOrder() {
        // logger.writeLog("INFO", "I confirm ...");
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.waitForElementDisplayed(getBtnIConfirmMyOrder());
        getBtnIConfirmMyOrder().click();
    }

    public void verifyOrderIsComplete() {
        assertEquals(getLblOrderIsComplete().getText(),
                properties.getProperty("OrderIsCompleteTextMsg"));
    }

    public void verifyLastBreadcrumb() {
        assertTrue(getLblPaymentBrdCrmb().getAttribute("class")
                .equals(properties.getProperty("ClassPropertyValue")));
    }

    public void clickSignInOnHomePage() {
        // logger.writeLog("INFO","Clicking on Sign in link: " + AutomationPracticePageModel.getLinkSignin().getText());
        //waitForElementToBeVisible(By.cssSelector(".login"));
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.waitForVisibilityOfElement(By.cssSelector(".login"));
        getLinkSignin().click();
    }

    public void fillUserPersonalInfo() {
        //logger.writeLog("INFO","Entering personal info");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.checkPageIsReady();
        webDriverUtils.waitForJStoLoad();
        webDriverUtils.jsRadioButtonCheck(getRdBtnMr());
        getTxtBoxFirstName().sendKeys(properties.getProperty("FirstName"));
        getTxtBoxLastName().sendKeys(properties.getProperty("LastName"));
        getTxtBoxPassword().sendKeys(properties.getProperty("Password"));
        webDriverUtils.jsRadioButtonCheck(getRdBtnMr());
        PASSWORD = getTxtBoxPassword().getAttribute("value");
        Select select = new Select(getDrpDwnDays());
        select.selectByIndex(3);
        select = new Select(getDrpDwnMonths());
        select.selectByIndex(3);
        select = new Select(getDrpDwnYears());
        select.selectByIndex(3);
    }

    public void clickOnTopSignInBtn() {
        WebDriverUtils webDriverUtils = new WebDriverUtils(driver);
        webDriverUtils.waitForElementDisplayed(getLinkSignin());
        getLinkSignin().click();
    }

    public void clickOnWomenOption() {
        //logger.writeLog("INFO","User is clicking on Women section");
        getLinkWomen().click();
    }

    public void ConfirmationAppUrl() {
        //  logger.writeLog("INFO","Appender URL is loaded correctly");
        assertTrue(driver.getCurrentUrl().contains(properties.getProperty("ConfirmationAppUrl")));
    }

    public void afterLoginUrl() {
        // logger.writeLog("INFO","Login is successful");
        boolean afterLoginUrl = driver.getCurrentUrl().contains(properties.getProperty("ConfirmationAppUrl"));
        assertTrue(afterLoginUrl);
    }

    public void verifyConfirmationUrlForOrder() {
        // logger.writeLog("INFO","Verifying the url...");
        assertTrue(driver.getCurrentUrl().contains(properties.getProperty("OrderConfirmUrl")));
    }
}
