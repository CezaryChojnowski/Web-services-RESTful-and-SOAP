package com.rsi.demo.rest.controller;

import com.rsi.demo.domain.TextService;
import com.rsi.demo.model.Text;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/text")
public class TextController {

    private final TextService textService;

    @GetMapping(produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE
    })
    public List<Text> getText(){
        return textService.generateTextList();
    }
}
