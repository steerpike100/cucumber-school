package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Person {
    public static final Pattern BUY_PATTERN = Pattern.compile("buy", Pattern.CASE_INSENSITIVE);
    private final List<String> messagesHeard = new ArrayList<String>();
    private final Network network;
    private final int location;
    private int credits;

    public Person(Network network, int location) {
        this.network = network;
        this.location = location;
        this.credits = 0;
        network.subscribe(this);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }

    public void shout(String message) {
        deductCredits(message);
        network.broadcast(message, this);
    }

    private void deductCredits(String message) {
        if (message.length() <=180) {
            credits -= 2;
        }
        Matcher matcher = BUY_PATTERN.matcher(message);
        while (matcher.find()) {
        credits -= 5;
        }
    }

    public void hear(String message) {
        messagesHeard.add(message);
    }

    public int getLocation() {
        return location;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCredits() {
        return credits;
    }
}
