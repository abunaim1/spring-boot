package com.shadhinlab.learningSpringBootApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringBoot {

    @GetMapping("/")
    public String Hello(){
        return "Hello World From Naim!";
    }
}
