package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

// Inyección de Dependencias CON Spring
// Usando el estereotipo @Controller indicamos que esta clase es un componente de Spring.
// Usando properties
// Forma menos óptima de inyectar dependencias.
// Problema: Si esta clase es instanciada, pero no se inicializa greetingService, obtenemos un NullPointerException
@Controller
public class PropertyInjectedController {

    // Notar que no es private para poder hacer el test.
    // Spring, para poder hacer la inyección de dependencias con properties, necesita la anotación @Autowired
    // No se recomienda esta forma de inyectar dependencias usando Spring.
    // Esta anotación no es necesaria utilizando la inyección de dependencias usando constructor.
    //
    // Vamos a inyectar la implementación de GreetingService siguiente usando el nombre dado al bean en la anotación
    // @Service:
    @Qualifier("propertyGreetingService")
    @Autowired
    GreetingService greetingService;

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
