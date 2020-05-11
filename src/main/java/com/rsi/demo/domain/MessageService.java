package com.rsi.demo.domain;

import com.rsi.demo.model.Message;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageService {

    static private Map<Long, Message> messageMap = new HashMap<>();

    public MessageService(){
        messageMap.put(1L, new Message(1L, "Pierwsza wiadomość", new Date(),"User1"));
        messageMap.put(2L, new Message(2L, "Druga wiadomość", new Date(),"User2"));
        messageMap.put(3L, new Message(3L, "Trzecia wiadomość", new Date(),"User3"));
    }

    public List<Message> getAllMessages(){
        return new ArrayList<>(messageMap.values());
    }

    public Message getMessage(Long id){
        return messageMap.get(id);
    }

    public Message createMessage(Message message){
        message.setId(messageMap.size() + 1L);
        messageMap.put(messageMap.size() + 1L, message);
        return message;
    }

    public Message updateMessage(Long id, Message message){
        messageMap.get(id).setId(message.getId());
        messageMap.get(id).setAuthor(message.getAuthor());
        messageMap.get(id).setCreated(message.getCreated());
        messageMap.get(id).setMessage(message.getMessage());
        return message;
    }

    public Message deleteMessage(Long id){
       return messageMap.remove(id);
    }
}
