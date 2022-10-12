package com.ruqaya.controller;
import org.springframework.stereotype.Component;

@Component
public class MyApp {
    public String sayHello(String a, String b) {
        return a.concat(b);
    }

    public String sayHi(String a, String b) {
        return a.concat(b);
    }

    public String sayBye(String a, String b) {
        return a.concat(b);
    }
}