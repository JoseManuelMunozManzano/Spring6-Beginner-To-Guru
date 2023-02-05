package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;

// Inyección de Dependencias sin Spring
// Usando properties
// Forma menos óptima de inyectar dependencias.
// Problema: Si esta clase es instanciada, pero no se inicializa greetingService, obtenemos un NullPointerException
public class PropertyInjectedController {

    // Notar que no es private para poder hacer el test
    GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
