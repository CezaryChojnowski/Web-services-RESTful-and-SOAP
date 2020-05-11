package com.rsi.demo.domain;

import com.rsi.demo.model.Text;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TextService {

    public List<Text> generateTextList(){

        List<Text> messageList = new ArrayList<>();
        messageList.add(new Text(1L, "Pierwsza wiadomość", new Date(),"User1"));
        messageList.add(new Text(1L, "Druga wiadomość", new Date(),"User2"));
        messageList.add(new Text(1L, "Trzecia wiadomość", new Date(),"User3"));
        return messageList;
    }
}
