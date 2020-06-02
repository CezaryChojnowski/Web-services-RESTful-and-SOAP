package com.rsi.demo.domain;

import com.rsi.demo.model.Comment;
import com.rsi.demo.model.Message;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommentService {
    private final MessageService messageService;

    static private Map<Long, Comment> commentHashMap = new HashMap<>();

    public CommentService(MessageService messageService) {
        this.messageService=messageService;
        commentHashMap.put(1L, new Comment(1L, "Pierwszy komentarz", new Date(),"User4" ));
        commentHashMap.put(2L, new Comment(2L, "Drugi Komentarz", new Date(),"User4"));
        commentHashMap.put(3L, new Comment(3L, "Trzeci komepntarz", new Date(),"User5"));
    }

    public List<Comment> getAllCommentsByMessage(Long id){
        Message message = messageService.getMessage(id);
        return message.getComments();
    }

    public Comment createMessage(Comment comment, Long id){
        Message message = messageService.getMessage(id);
        List<Comment> comments = message.getComments();
        comment.setId(commentHashMap.size() + 1L);
        commentHashMap.put(commentHashMap.size() + 1L, comment);
        comments.add(comment);
        return comment;
    }
}