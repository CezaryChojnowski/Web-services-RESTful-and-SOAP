package com.rsi.demo.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Products {

    private List<Product> products = new ArrayList<>();

    public Products(){
        if(products.isEmpty()){
            products.add(new Product(500, "Laptop", "Dell" ));
            products.add(new Product(200, "Myszka", "Logitech"));
            products.add(new Product(300, "Laptop", "Dell"));
            products.add(new Product(200, "Torba", "Dell"));
            products.add(new Product(500, "Tablet", "Samsung"));
            products.add(new Product(3000, "Laptop", "IBM"));
        }
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public List<Product> findProductsByProducerAndPriceLowerThan(SearchParam searchParam){
        List<Product> list = new ArrayList<>();
        for(Product p : products){
            if(searchParam.getName() != null){
                if(!p.getName().toLowerCase().startsWith(searchParam.getName().toLowerCase()))
                    continue;
            }
            if(searchParam.getProducer() != null){
                if(!p.getProducer().toUpperCase().startsWith(searchParam.getProducer().toUpperCase()))
                    continue;
            }
            if(searchParam.getPriceLowerThan() > 0){
                if(searchParam.getPriceLowerThan() <= p.getPrice())
                    continue;
            }

            list.add(p);
        }

        return list;
    }
}
