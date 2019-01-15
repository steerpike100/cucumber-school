package io.cucumber.shouty;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class Stepdefs {

    Person lucy = new Person();
    Person sean = new Person();
    private String messageFromSean;

    @Given("^Lucy (?:is|is standing) (\\d+) metres? from Sean$")
    public void lucy_is_m_from_Sean(int distance) throws Throwable {
        lucy.setLocation(distance);
        sean.setLocation(0);
    }

    @When("^Sean shouts \"(.*?)\"$")
    public void sean_shouts(String message) {
        sean.shout(message);
        messageFromSean = message;
    }

    @Then("^Lucy hears Sean's message$")
    public void lucy_should_hear_Sean_s_message() {
        assertEquals(asList(messageFromSean), lucy.getMessagesHeard(messageFromSean));
    }

    @Then("^Lucy cannot hear the message$")
    public void lucyCannotHearTheMessage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Lucy shouts back to (\\w+)$")
    public void lucyShoutsBackToSean(String name) throws Throwable {
        System.out.println(name + " says: " + "I hear you!");
    }

    @Given("^Lucy is has \\d+ cucumbers in her bag$")
    public void lucyIsHasCucumbersInHerBag(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("Lucy buys (no|\\d+) cucumbers")
    public void lucyBuysNoCucumbers() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
