package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Network {
    private final List<Person> listeners = new ArrayList<Person>();
    private final int range;

    public Network(int range) {
        this.range = range;
    }

    public void subscribe(Person person) {
        listeners.add(person);
    }

    public void broadcast(String message, Person shouter) {
        int shouterLocation = shouter.getLocation();
        boolean shortEnough = message.length() <= 180;
        for (Person listener : listeners) {
            boolean withinRange = Math.abs(listener.getLocation() - shouterLocation) <= range;
            if (withinRange && (shortEnough || shouter.getCredits() >= 0)) {
                listener.hear(message);
            }
        }
    }


    }

