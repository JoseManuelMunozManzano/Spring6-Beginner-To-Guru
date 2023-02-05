package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

// Inyección de Dependencias CON Spring
// Usando el estereotipo @Controller indicamos que esta clase es un componente de Spring.
// Usando el constructor
// Forma óptima de inyectar dependencias y la que debemos hacer
@Controller
public class ConstructorInjectedController {

    // Buena práctica de programación que puede hacerse al usar el constructor: hacer final la property
    private final GreetingService greetingService;

    // Solo puede instanciarse esta clase si se pasa GreetingService (no es posible NullPointerException)
    // Siendo ahora un componente Spring, Spring SABE que debe inyectar una clase que implemente GreetingService.
    //
    // Ahora mismo se está inyectando por defecto la implementación de GreetingService que tiene la anotación @Primary.
    // Para poder seleccionar por completo que implementación queremos inyectar se usa la anotación @Qualifier y
    // se indica el nombre de la clase con la primera letra siempre en minúscula.
    public ConstructorInjectedController(@Qualifier("greetingServiceImpl") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
