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
public class Comment {
    private long id;
    private String comment;
    private Date created;
    private String author;
}