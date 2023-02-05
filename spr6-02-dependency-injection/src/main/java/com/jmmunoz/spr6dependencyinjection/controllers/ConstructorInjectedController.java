package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;

// Inyección de Dependencias sin Spring
// Usando el constructor
// Forma óptima de inyectar dependencias y la que debemos hacer
public class ConstructorInjectedController {

    // Buena práctica de programación que puede hacerse al usar el constructor: hacer final la property
    private final GreetingService greetingService;

    // Solo puede instanciarse esta clase si se pasa GreetingService (no es posible NullPointerException)
    public ConstructorInjectedController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
