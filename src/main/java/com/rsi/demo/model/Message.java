package com.rsi.demo.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
@ToString
public class Message {
    private long id;
    private String message;
    private Date created;
    private String author;
}
