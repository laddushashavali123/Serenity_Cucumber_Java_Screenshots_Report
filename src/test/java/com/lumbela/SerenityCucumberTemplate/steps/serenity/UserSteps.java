package com.lumbela.SerenityCucumberTemplate.steps.serenity;

import com.lumbela.SerenityCucumberTemplate.pages.WiktionaryPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.lumbela.SerenityCucumberTemplate.utils.Constant.CHROME_DRIVER_DIRECTORY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class UserSteps {
    WiktionaryPage wiktionaryPage;

    @Step
    public void enters(String keyword) {
        wiktionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        wiktionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(wiktionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_on_the_home_page() {
        /*System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_DIRECTORY);// "src/test/resources/drivers/chromedriver_Win.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");*/
        wiktionaryPage.setDriver(wiktionaryPage.setBrowserForExecution());
        //wiktionaryPage.setDriver(REAL_DRIVER);
        wiktionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}