package com.rsi.demo.rest.controller;

import com.rsi.demo.domain.ResponseList;
import com.rsi.demo.model.Product;
import com.rsi.demo.model.Products;
import com.rsi.demo.model.SearchParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private Products products = new Products();


    @GetMapping
    public ResponseList getAllProducts(){
        List<Product> allProducts = products.getAllProducts();
        ResponseList responseList = new ResponseList();
        responseList.setList(allProducts);
        return responseList;
    }

    @RequestMapping(method= RequestMethod.POST)
    public ResponseList findProducts(@RequestBody SearchParam searchParam){
        ResponseList responseList = new ResponseList();
        List<Product> resLista = products.findProductsByProducerAndPriceLowerThan(searchParam);
        responseList.setList(resLista);
        return responseList;
    }
}
