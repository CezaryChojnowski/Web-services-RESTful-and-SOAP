package com.rsi.demo.domain;

import com.rsi.demo.model.Message;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    public List<Message> generateMessagesList(){

        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message(1L, "Pierwsza wiadomość", new Date(),"User1"));
        messageList.add(new Message(1L, "Druga wiadomość", new Date(),"User2"));
        messageList.add(new Message(1L, "Trzecia wiadomość", new Date(),"User3"));
        return messageList;
    }
}
