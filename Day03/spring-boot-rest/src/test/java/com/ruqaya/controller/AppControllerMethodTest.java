package com.ruqaya.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppControllerMethodTest {

    AppController appController;

    @Test
    public void sayHelloTest(){
        MyApp app=new MyApp();
        appController=new AppController(app);
        String result= appController.sayHello("str1","str2");
        assertEquals("str1str2",result);
    }

    @Test
    public void sayHiTest(){
        MyApp app=new MyApp();
        appController=new AppController(app);
        String result= appController.sayHi("str1","str2");
        assertEquals("str1str2",result);
    }

    @Test
    public void sayByeTest(){
        MyApp app=new MyApp();
        appController=new AppController(app);
        String result= appController.sayBye("str1","str2");
        assertEquals("str1str2",result);
    }
}