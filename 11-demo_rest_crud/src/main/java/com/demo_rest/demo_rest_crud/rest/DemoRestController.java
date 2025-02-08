package com.demo_rest.demo_rest_crud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")
@RestController
public class DemoRestController {
    @GetMapping("/hello")
    public String greetings(){
        return "Hello world";
    }
}
