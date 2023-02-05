package com.jmmunoz.spr6dependencyinjection.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// Existiendo dos implementaciones de GreetingService, cómo sabe Spring que implementación debe inyectar?
// NO LO SABE, por eso hay que indicarlo.
// Una primera forma es, al crear la implementación de la interface, indicar que esta clase es la que siempre debe
// inyectarse si no se indica otra cosa. Para esto existe la anotación @Primary
// Si ahora se ejecutan los tests, por defecto cogerán esta implementación de GreetingService (salvo que en los tests
// se indique otra cosa)
@Primary
@Service
public class GreetingServicePrimary implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello from the Primary Bean!!!";
    }
}
