package com.rsi.demo.domain;

import com.rsi.demo.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Setter
@Getter
public class ResponseList {

    @XmlElement(name = "products")
    private List<Product> list;

}
