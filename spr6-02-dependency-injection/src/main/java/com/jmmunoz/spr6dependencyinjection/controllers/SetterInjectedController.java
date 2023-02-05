package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// Inyección de Dependencias CON Spring
// Usando el estereotipo @Controller indicamos que esta clase es un componente de Spring.
// Usando setters
// Mejor que usando properties, pero no la más óptima.
// Problema: Si esta clase es instanciada, pero no se hace setGreetingService, obtenemos un NullPointerException
@Controller
public class SetterInjectedController {

    // Es obligatorio indicar a Spring que debe inyectar la dependencia.
    // Podemos anotar la property o el setter con la anotación @Autowired
    @Autowired
    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
