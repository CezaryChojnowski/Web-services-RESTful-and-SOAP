package com.rsi.demo;

import com.rsi.demo.model.Products;
import com.rsi.demo.model.SearchParam;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


import javax.ws.rs.ClientErrorException;
import java.util.Arrays;

//
// implements CommandLineRunner
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(getAllProducts());
//
//        System.out.println(findProducts("", "d", 500));
//    }
//
//    public ResponseEntity<Products> getAllProducts()  throws ClientErrorException, IllegalStateException {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//        ResponseEntity<Products> resultMessages = restTemplate.exchange("http://localhost:8080/products", HttpMethod.GET, entity, Products.class);
//        return resultMessages;
//    }
//
//    public String findProducts(String name, String producer, int price){
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        SearchParam searchParam = new SearchParam(name,producer,price);
//        HttpEntity<SearchParam> entity = new HttpEntity<SearchParam>(searchParam, headers);
//        return restTemplate.postForObject("http://localhost:8080/products", entity, String.class);
//    }

    //------------------------------------------------------------------------------------------------------------------------------------------------
//    @Override
//    public void run(String... args) throws Exception{
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        JSONObject jsonObject;
//        jsonObject = restTemplate.getForObject("http://localhost:8080/messages/1", JSONObject.class);
//        System.out.println("response: " + jsonObject);
//
//        jsonObject = restTemplate.getForObject("http://localhost:8080/messages/4", JSONObject.class);
//        System.out.println("response: " + jsonObject);
//
//        Message message = new Message();
//        message.setMessage("Nowa wiadomość");
//        message.setCreated(new Date());
//        message.setAuthor("Cezary");
//        Message result = restTemplate.postForObject( "http://localhost:8080/messages", message, Message.class);
//        System.out.println(result);
//
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
//
//        ResponseEntity<String> resultMessages = restTemplate.exchange("http://localhost:8080/messages", HttpMethod.GET, entity, String.class);
//
//        System.out.println(resultMessages);
//    }
//------------------------------------------------------------------------------------------------------------------------------------------------


}
