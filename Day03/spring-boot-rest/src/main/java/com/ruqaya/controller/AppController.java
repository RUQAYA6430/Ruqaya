
package com.ruqaya.controller;

        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private MyApp myApp;

    public AppController(MyApp myApp) {
        this.myApp=myApp;
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(name = "a", required = true) String a,@RequestParam(name = "b", required = true) String b) {
        return myApp.sayHello(a,b);
    }

    @GetMapping("/hi")
    public String sayHi(@RequestParam(name = "a", required = true) String a,@RequestParam(name = "b", required = true) String b) {
        return myApp.sayHi(a,b);
    }

    @GetMapping("/bye")
    public String sayBye(@RequestParam(name = "a", required = true) String a,@RequestParam(name = "b", required = true) String b) {
        return myApp.sayBye(a,b);
    }
}