package com.rsi.demo.rest.controller;

import com.rsi.demo.domain.MessageService;
import com.rsi.demo.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {

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
    public List<Message> getAllMessages(HttpServletRequest request){
        System.out.println("URI -- "+ request.getRequestURL());
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

    @GetMapping(value = "/byQueryParam")
    public Message getMessageByQueryParam(@RequestParam(name="messageId") Long id){
        return messageService.getMessage(id);
    }

    @GetMapping(value = "/withCustomHeader")
    public List<Message> getMessages(@RequestHeader Map<String, String> headers){
        headers.forEach((key, value) -> System.out.println(String.format("Header '%s' = %s", key, value)));
        return messageService.getAllMessages();
    }
}
