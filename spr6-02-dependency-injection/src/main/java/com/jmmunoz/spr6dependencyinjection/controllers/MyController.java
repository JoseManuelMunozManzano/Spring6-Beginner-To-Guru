package com.jmmunoz.spr6dependencyinjection.controllers;

import org.springframework.stereotype.Controller;

// Es un fake controller de prueba
@Controller
public class MyController {

    public String sayHello() {
        System.out.println("I'm in the controller");

        return "Hello Everyone!!";
    }
}
