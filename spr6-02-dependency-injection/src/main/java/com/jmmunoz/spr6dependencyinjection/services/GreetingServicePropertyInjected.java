package com.jmmunoz.spr6dependencyinjection.services;


import org.springframework.stereotype.Service;

// Otra forma de indicar qué implementación de GreetingService queremos que Spring inyecte es indicar un nombre
// en la anotación @Service (dar un nombre al bean) y luego hacer referencia a ella usando la anotación @Qualifier.
// Indicar que por defecto el nombre era greetingServicePropertyInjected y se ha cambiado a propertyGreetingService
@Service("propertyGreetingService")
public class GreetingServicePropertyInjected implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Friends don't let friends to property injection!!!";
    }
}
