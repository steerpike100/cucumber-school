package io.cucumber.shouty;

import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PersonTest {
    private final Network network = mock(Network.class);

    @Test
    public void it_subscribes_to_the_network() {
        Person person = new Person(network, 100);
        verify(network).subscribe(person);
    }

    @Test
    public void it_has_a_location() {
        Person person = new Person(network, 100);
        assertEquals(100, person.getLocation());
    }

    @Test
    public void broadcasts_shouts_to_the_network() {
        String message = "Free bagels!";
        Person sean = new Person(network, 0);
        sean.shout(message);
        verify(network).broadcast(message, sean);
    }

    @Test
    public void remembers_messages_heard() {
        String message = "Free bagels!";
        Person lucy = new Person(network, 100);
        lucy.hear(message);
        assertEquals(asList(message), lucy.getMessagesHeard());
    }

    //Charging for shouts
    @Test
    public void deducts_5_credits_when_the_shouter_mentions_the_word_buy() {
        Person sean = new Person(network,0);
        sean.setCredits(100);
        sean.shout("here is a message containing the word buy");
        assertEquals(95, sean.getCredits());
    }

    @Test
    public void deducts_2_credits_when_shouters_message_is_over_180_chars() {
        Person sean = new Person(network, 0);
        sean.setCredits(100);
        String overlongMessage = String.join("", Collections.nCopies(181, "x"));
        sean.shout(overlongMessage);
        assertEquals(95, sean.getCredits());
    }
}
