package com.rsi.demo;

import com.rsi.demo.model.Message;
import net.minidev.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject jsonObject;
        jsonObject = restTemplate.getForObject("http://localhost:8080/messages/1", JSONObject.class);
        System.out.println("response: " + jsonObject);

        jsonObject = restTemplate.getForObject("http://localhost:8080/messages/4", JSONObject.class);
        System.out.println("response: " + jsonObject);

        Message message = new Message();
        message.setMessage("Nowa wiadomość");
        message.setCreated(new Date());
        message.setAuthor("Cezary");
        Message result = restTemplate.postForObject( "http://localhost:8080/messages", message, Message.class);
        System.out.println(result);

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> resultMessages = restTemplate.exchange("http://localhost:8080/messages", HttpMethod.GET, entity, String.class);

        System.out.println(resultMessages);

    }

}
