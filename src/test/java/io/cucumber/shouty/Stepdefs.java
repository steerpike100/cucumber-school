package io.cucumber.shouty;

import cucumber.api.DataTable;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Stepdefs {

    private Network network;
    private final ShoutSupport shoutSupport;

    public Stepdefs(ShoutSupport shoutSupport){
        this.shoutSupport = shoutSupport;
    }

    @Given("^the range is (\\d+)$")
    public void the_range_is(int range) throws Throwable {
        network = new Network(range);
    }

    public static class Whereabouts {
        public String name;
        public int location;
    }

    @Given("^Sean has bought (\\d+) credits$")
    public void sean_has_bought_credits(int credits) throws Throwable {
        shoutSupport.people.get("Sean").setCredits(credits);
    }

    @Given("^the following people:$")
    public void the_following_people(@Transpose List<Whereabouts> whereabouts) throws Throwable {
        for (Whereabouts whereabout : whereabouts) {
            shoutSupport.people.put(whereabout.name, new Person(network, whereabout.location));
        }
    }

    @When("^Sean shouts a message containing the word \"([^\"]*)\"$")
    public void seanShoutsAMessageContainingTheWord(String word) throws Throwable {
        shoutSupport.seanShout("here is a message containing the word " + word);
    }

    @When("^Sean shouts (\\d+) messages containing the word \"(.*?)\"$")
    public void sean_shouts_messages_containing_the_word(int num, String word) throws Throwable {
      for(int j=0; j<num; j++){
          shoutSupport.seanShout("here is a message containing the word " + word);
      }
    }


    @And("^Sean shouts a message$")
    public void seanShoutsAMessage() throws Throwable {
        shoutSupport.seanShout("here is a message");
    }

    @And("^Sean shouts a long message$")
    public void seanShoutsALongMessage() throws Throwable {
        String longMessage = shoutSupport.longMessage();
            shoutSupport.seanShout(longMessage);
    }

    @And("^Sean shouts an over-long message$")
    public void seanShoutsAnOverLongMessage() throws Throwable {
        String overLongMessage = shoutSupport.overLongMessage();
            shoutSupport.seanShout(overLongMessage);
    }


//    @And("^Sean shouts (\\d+) over-long messages$")
//    public void seanShoutsOverLongMessages(int num) throws Throwable {
//        for (int j = 0; j < num; j++) {
//            String overLogMessage =  shoutSupport.overLongMessage();
//                shoutSupport.seanShout(overLogMessage);
//            }
//    }


    @When("^Sean shouts \"(.*?)\"$")
    public void sean_shouts(String message) throws Throwable {
        shoutSupport.seanShout(message);
    }


    @When("^Sean shouts:$")
    public void sean_shouts_longer_message(String message) throws Throwable {
        shoutSupport.seanShout(message);
    }

    @Then("^Lucy hears Sean's message$")
    public void lucy_hears_Sean_s_message() throws Throwable {
        lucy_hears_all_Sean_s_messages();
    }

    @Then("^Lucy hears all Sean's messages$")
    public void lucy_hears_all_Sean_s_messages() throws Throwable {
        List<String> heardByLucy = shoutSupport.people.get("Lucy").getMessagesHeard();
        List<String> messagesFromSean = shoutSupport.messagesShoutedBy.get("Sean");

        // Hamcrest's hasItems matcher wants an Array, not a List.
        String[] messagesFromSeanArray = messagesFromSean.toArray(new String[messagesFromSean.size()]);
        assertThat(heardByLucy, hasItems(messagesFromSeanArray));
    }

    @Then("^Lucy hears the following messages:$")
    public void lucy_hears_the_following_messages(DataTable expectedMessages) throws Throwable {
        List<List<String>> actualMessages = new ArrayList<List<String>>();
        List<String> heard = shoutSupport.people.get("Lucy").getMessagesHeard();
        for (String message : heard) {
            actualMessages.add(asList(message));
        }
        expectedMessages.diff(actualMessages);
    }

    @Then("^Larry does not hear Sean's message$")
    public void larry_does_not_hear_Sean_s_message() throws Throwable {
        List<String> heardByLarry = shoutSupport.people.get("Larry").getMessagesHeard();
        List<String> messagesFromSean = shoutSupport.messagesShoutedBy.get("Sean");
        String[] messagesFromSeanArray = messagesFromSean.toArray(new String[messagesFromSean.size()]);
        assertThat(heardByLarry, not(hasItems(messagesFromSeanArray)));
    }

    @Then("^nobody hears Sean's message$")
    public void nobody_hears_Sean_s_message() throws Throwable {
        List<String> messagesFromSean = shoutSupport.messagesShoutedBy.get("Sean");
        String[] messagesFromSeanArray = messagesFromSean.toArray(new String[messagesFromSean.size()]);
        for (Person person : shoutSupport.people.values()) {
            assertThat(person.getMessagesHeard(), not(hasItems(messagesFromSeanArray)));
        }
    }

    @Then("^Sean should have (\\d+) credits$")
    public void sean_should_have_credits(int credits) throws Throwable {
        assertEquals(credits, shoutSupport.people.get("Sean").getCredits());
    }
}
