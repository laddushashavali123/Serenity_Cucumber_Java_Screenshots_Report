package com.lumbela.SerenityCucumberTemplate.steps;

import com.lumbela.SerenityCucumberTemplate.steps.serenity.UserSteps;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionSteps {

    @Steps
    UserSteps user;

    @Given("the user is on the Wiktionary home page")
    public void givenTheUserIsOnTheWiktionaryHomePage() {
        user.is_on_the_home_page();
    }

    @When("the user looks up the definition of the word '(.*)'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        user.looks_for(word);
    }

    @Then("they should see the definition '(.*)'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        user.should_see_definition(definition);
    }

}
