package com.pratica1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class HelloController {

    @GetMapping("/test")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/name")
    public String myName() {
        return "Olá, meu nome é Caio César de Souza Almeida e meu RA é 12121045";
    }
}