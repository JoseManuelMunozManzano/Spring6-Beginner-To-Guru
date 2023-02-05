package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;
import com.jmmunoz.spr6dependencyinjection.services.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

// Es un fake controller de prueba
@Controller
public class MyController {

    private final GreetingService greetingService;

    // Dependencias sin Dependency Injection
    // No pasamos al constructor el service, por lo que MyController tiene to-do el control sobre como se crea
    // y se usa GreetingService
    // Esto es muy rígido y NO es lo que se espera al usar el framework de Spring
    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello() {
        System.out.println("I'm in the controller");

        return greetingService.sayGreeting();
    }
}
