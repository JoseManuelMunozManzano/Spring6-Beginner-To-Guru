package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;

// Inyección de Dependencias sin Spring
// Usando setters
// Mejor que usando properties, pero no la más óptima.
// Problema: Si esta clase es instanciada, pero no se hace setGreetingService, obtenemos un NullPointerException
public class SetterInjectedController {

    private GreetingService greetingService;

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
