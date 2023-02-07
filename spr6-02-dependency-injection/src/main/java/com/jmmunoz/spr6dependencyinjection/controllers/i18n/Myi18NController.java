package com.jmmunoz.spr6dependencyinjection.controllers.i18n;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Myi18NController {

    private final GreetingService greetingService;

    // Se indica el Qualifier, pero con ese Qualifier tenemos 2 services y los vamos a inyectar en función
    // del profile que se active en el test
    public Myi18NController(@Qualifier("i18NService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
