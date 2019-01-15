package io.cucumber.shouty;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class Stepdefs {

    private Person sean;
    private Person lucy;
    private String messageFromSean;
    private Network network;
    private Map<String, Person> people;

    @Before
    public void createNetwork() {
        network = new Network();
        people = new HashMap<String, Person>();
    }

    @Given("^A person named (\\w+)$")
    public void a_person_named(String name) throws Throwable {
        people.put(name, new Person(network));
    }

    @When("^(\\w+) shouts \"(.*?)\"$")
    public void person_shouts(String name, String message) {
        people.get(name).shout(message);
        messageFromSean = message;
    }

    @Then("^(\\w+) hears (\\w+[\"']\\w) message$")
    public void person_should_hear_the_message(String nameOne, String nameTwo) {
        assertEquals(asList(messageFromSean), people.get(nameOne).getMessagesHeard());
    }


}
