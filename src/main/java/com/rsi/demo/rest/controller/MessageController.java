package com.rsi.demo.rest.controller;

import com.rsi.demo.domain.CommentService;
import com.rsi.demo.domain.MessageService;
import com.rsi.demo.model.Comment;
import com.rsi.demo.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;
    private final CommentService commentService;

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

    @GetMapping(value = "/query")
    public List<Message> getMessages(@RequestParam("zaczynasie") String par1 ) {
        if (par1 != null){
            return messageService.getAllMessagesStartingWith(par1);
        }
        return messageService.getAllMessages();

    }

    @PostMapping
    public ResponseEntity<Message> createNewMessage(@RequestBody Message message, @NotNull HttpServletRequest request){
        Message result = messageService.createMessage(message);
        String newid = String.valueOf(result.getId());
        String uri = request.getRequestURL() + "/" + newid;
        Response.created(URI.create(uri));
        return ResponseEntity.created(URI.create(uri)).body(result);
    }

    @GetMapping(value = "{messageId}/comments",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public List<Comment> getComments(@PathVariable("messageId") Long id){
        return commentService.getAllCommentsByMessage(id);
    }

    @PostMapping(value = "{messageId}/comments",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public Comment createComment(@RequestBody Comment comment, @PathVariable("messageId") Long id){
        return commentService.createMessage(comment, id);
    }

}
