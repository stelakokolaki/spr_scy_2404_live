package gr.codehub.s101.controller;

import gr.codehub.s101.HomerApplication;
import gr.codehub.s101.service.GreetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/")
public class HelloController {
    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private GreetService gs;

    @GetMapping("hello")
    public String hello() {
        logger.info("somebody said hello!");
        return "Hello to you too!";
    }

    @GetMapping("hello/{name}")
    public String helloSomething(@PathVariable String name){
        return "Hello dear " + name + "!";
    }

    @GetMapping("greet/{name}")
    public String greet(@PathVariable String name){

        String message = gs.greetWithInfo(name);
        return message;
    }

}
