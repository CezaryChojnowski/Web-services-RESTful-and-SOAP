package com.rsi.demo.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@ToString
public class Message extends RepresentationModel<Message> {
    private long id;
    private String message;
    private Date created;
    private String author;
    private List<Comment> comments;
}
