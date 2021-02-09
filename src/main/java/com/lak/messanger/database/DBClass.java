package com.lak.messanger.database;

import com.lak.messanger.model.Message;
import com.lak.messanger.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DBClass {

    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<String, Profile> profile = new HashMap<>();

    public DBClass() {

    /*    messages.put(1L, new Message(1, "Hello World", "Lakshitha"));
        messages.put(2L, new Message(2, "Hello World Jersey", "Lakshitha"));*/
    }

    public static Map<Long, Message> getMessages() {
        return messages;
    }

    public static Map<String, Profile> getProfiles() {
        return profile;
    }
}
