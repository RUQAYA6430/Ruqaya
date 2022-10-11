package com.ruqaya.calculator;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public  class CalculatorController {

    @GetMapping("/add")

    public double addition(@RequestParam(name = "a", required = true) double a,@RequestParam(name = "b", required = true) double b) {
        return a+b;
    }

    @GetMapping("/sub")
    public double subtraction(@RequestParam(name = "a", required = true) double a,@RequestParam(name = "b", required = true) double b) {
        return a-b;
    }

    @GetMapping("/mul")
    public double multiplication(@RequestParam(name = "a", required = true) double a,@RequestParam(name = "b", required = true) double b) {
        return a*b;
    }

    @GetMapping("/div")
    public double division(@RequestParam(name = "a", required = true) double a,@RequestParam(name = "b", required = true) double b) {

        return a/b;
    }
}
