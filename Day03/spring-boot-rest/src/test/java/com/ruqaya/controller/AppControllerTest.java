//
//package com.ruqaya.controller;
//
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class AppControllerTest {
//
//    @InjectMocks
//    AppController appController;
//
//    MyApp myApp;
//
//    @BeforeEach
//    public void setUp(){
//        myApp=mock(MyApp.class);
//        appController=new AppController(myApp);
//    }
//
//    @Test
//    public void sayHelloTest(){
//        when(myApp.sayHello(anyString(),anyString())).thenReturn("Hello Ruqaya");
//        String result= appController.sayHello("a","b");
//        assertEquals("Hello Ruqaya",result);
//
//    }
//
//    @Test
//    public void sayHiTest(){
//        when(myApp.sayHi(anyString(),anyString())).thenReturn("Hi Ruqaya");
//        String result= appController.sayHi("a","b");
//        assertEquals("Hi Ruqaya",result);
//
//    }
//
//    @Test
//    public void sayByeTest(){
//        when(myApp.sayBye(anyString(),anyString())).thenReturn("Bye Ruqaya");
//        String result= appController.sayBye("a","b");
//        assertEquals("Bye Ruqaya",result);
//
//    }
//}