package com.lumbela.SerenityCucumberTemplate.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.lumbela.SerenityCucumberTemplate.utils.Constant.CHROME_DRIVER_DIRECTORY;
import static com.lumbela.SerenityCucumberTemplate.utils.Constant.GECKO_DRIVER_DIRECTORY;
import static com.lumbela.SerenityCucumberTemplate.utils.Constant.IE_DRIVER_DIRECTORY;
import static org.openqa.selenium.ie.InternetExplorerDriver.IGNORE_ZOOM_SETTING;

public class DriverClass extends PageObject {
    /**
     * Creating a driver instance
     */

    public WebDriver getBrowser(String desiredBrowserName)  {
        // String desiredBrowserName = System.getProperty("browser", "chrome");
        WebDriver desiredBrowser = null;
        DesiredCapabilities capabilities =null;
        switch(desiredBrowserName) {
            case "ie":
                System.setProperty("webdriver.ie.driver", IE_DRIVER_DIRECTORY);
                capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(IGNORE_ZOOM_SETTING, true);
                desiredBrowser = new InternetExplorerDriver(capabilities);
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_DIRECTORY);// "src/test/resources/drivers/chromedriver_Win.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                options.addArguments("--start-maximized");
                desiredBrowser = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",GECKO_DRIVER_DIRECTORY);// "src/test/resources/drivers/geckodriver_Win.exe");
                capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                ProfilesIni prof = new ProfilesIni();
                FirefoxProfile ffProfile = prof.getProfile("default");
                ffProfile.setAcceptUntrustedCertificates(true);
                ffProfile.setAssumeUntrustedCertificateIssuer(false);
                desiredBrowser = new FirefoxDriver((Capabilities) ffProfile);
                break;
            default:
                //work out what to do when a browser isn't needed
                break;
        }
        desiredBrowser.manage().deleteAllCookies();
        return desiredBrowser;
    }

}
