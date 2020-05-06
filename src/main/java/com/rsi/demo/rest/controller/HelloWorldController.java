package com.rsi.demo.rest.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {

    @GetMapping
    public String basicGet(){
        return "Spring boot";
    }

    @GetMapping("/echo")
    public String bacisGet2(){
        return "Echo";
    }

    @GetMapping(value = "/echo/{parametr}")
    public String getHTML2(@PathVariable("parametr") String parametr){
        return "Przekazano: " + parametr;
    }

    }
