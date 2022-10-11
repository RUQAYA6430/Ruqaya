package com.ruqaya.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Ruqaya: ";
    }

    @RequestMapping("/hi")
    public String sayHi() {
        return "Hi Ruqaya : ";
    }

    @GetMapping("/Goodmng")
    public String sayGoodmng() {
        return "Good mng Ruqaya: ";
    }
    @RequestMapping("/Bye")
    public String sayBye(){ return "Bye Ruqaya:";}
}
