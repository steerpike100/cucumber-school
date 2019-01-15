package io.cucumber.shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

    @Given("^Lucy is (\\d+)m from Sean$")
    public void lucy_is_m_from_Sean(int distance) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Person lucy = new Person();
        Person sean = new Person();

        lucy.setLocation(distance);
        sean.setLocation(0);
    }

    @When("^Sean shouts \"(.*?)\"$")
    public void sean_shouts(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("^Lucy should hear Sean's message$")
    public void lucy_should_hear_Sean_s_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

}
