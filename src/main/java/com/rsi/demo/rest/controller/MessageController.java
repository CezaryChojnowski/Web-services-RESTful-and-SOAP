package com.rsi.demo.rest.controller;

import com.rsi.demo.domain.MessageService;
import com.rsi.demo.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {

//    @Context
//    private HttpHeaders httpHeaders;

    private final MessageService messageService;

    @GetMapping(value = "{messageId}",
            produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public Message getMessage(@PathVariable("messageId") Long id){
        return messageService.getMessage(id);
    }

    @GetMapping
    public List<Message> getAllMessages(){
        return messageService.getAllMessages();
    }

    @PostMapping
    public Message createNewMessage(@RequestBody Message message){
        return messageService.createMessage(message);
    }

    @PutMapping(value = "/{messageId}")
    public Message updateMessage(@PathVariable("messageId") Long id,
                                 @RequestBody Message message){
        return messageService.updateMessage(id, message);
    }

    @DeleteMapping(value = "/{messageId}")
    public Message removeMessage(@PathVariable("messageId") Long id){
        return messageService.deleteMessage(id);
    }
}
