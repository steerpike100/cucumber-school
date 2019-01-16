package io.cucumber.shouty;

import cucumber.api.java.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoutSupport {
    public final Map<String, Person> people = new HashMap<String, Person>();
    public final Map<String, List<String>> messagesShoutedBy = new HashMap<String, List<String>>();

    public void seanShout(String message) {
        people.get("Sean").shout(message);
        List<String> messages = messagesShoutedBy.get("Sean");
        if (messages == null) {
            messages = new ArrayList<String>();
            messagesShoutedBy.put("Sean", messages);
        }
        messages.add(message);
    }

    public String longMessage(){
        String longMessage = "";
        for (int i = 0; i < 180; i++) {
            longMessage += "x";
        }

        return longMessage;
    }

    public String overLongMessage(){
        String overLongMessage = "";
        for (int i = 0; i < 181; i++) {
            overLongMessage += "x";
        }

        return overLongMessage;
    }

}
