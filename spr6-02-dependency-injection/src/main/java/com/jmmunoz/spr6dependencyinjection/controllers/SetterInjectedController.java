package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

// Inyección de Dependencias CON Spring
// Usando el estereotipo @Controller indicamos que esta clase es un componente de Spring.
// Usando setters
// Mejor que usando properties, pero no la más óptima.
// Problema: Si esta clase es instanciada, pero no se hace setGreetingService, obtenemos un NullPointerException
@Controller
public class SetterInjectedController {

    //@Autowired
    //@Qualifier("setterGreetingBean")
    private GreetingService greetingService;

    // ERROR ANTERIOR: Para usar inyección usando setter, @Autowired debe estar en el setter, porque si está en
    // la property se hará una inyección usando properties.
    // Esto se puede comprobar descomentando el @Autowired y el @Qualifier del property y comentando el del setter,
    // y con un debug dentro del setter ver que no accedemos dentro.
    //
    // Es obligatorio indicar a Spring que debe inyectar la dependencia utilizando la anotación @Autowired en el setter
    //
    // Indicamos el nombre concreto del bean que queremos inyectar utilizando @Qualifier, en el setter.
    @Autowired
    @Qualifier("setterGreetingBean")
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
