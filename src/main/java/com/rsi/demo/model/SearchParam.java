package com.rsi.demo.model;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class SearchParam {
    String name;
    String producer;
    int priceLowerThan;
}

