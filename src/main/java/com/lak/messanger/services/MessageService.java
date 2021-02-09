package com.lak.messanger.services;

import com.lak.messanger.database.DBClass;
import com.lak.messanger.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {

    private Map<Long, Message> messages = DBClass.getMessages();


    public MessageService(){

        messages.put(1L, new Message(1, "Hello World", "Lakshitha"));
        messages.put(2L, new Message(2, "Hello World Jersey", "Lakshitha"));
    }

    public List<Message> getAllMessages() {

        return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(long id){

        return messages.get(id);
    }

    public List<Message> getAllMessagesFroYear(int year){

        List<Message> messageForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Message message: messages.values()){
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year){
                messageForYear.add(message);
            }
        }
        return messageForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size){

        ArrayList<Message> list = new ArrayList<>(messages.values());
        if(start + size > list.size()) return new ArrayList<Message>();
        return list.subList(start, start+size);
    }

    public Message addMessage(Message message){
        message.setId(messages.size() +1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message){
        if(message.getId() <= 0){
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
