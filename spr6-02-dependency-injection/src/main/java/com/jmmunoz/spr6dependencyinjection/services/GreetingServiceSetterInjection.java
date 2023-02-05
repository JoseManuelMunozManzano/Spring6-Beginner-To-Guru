package com.jmmunoz.spr6dependencyinjection.services;

import org.springframework.stereotype.Service;

// Implementación de GreetingService con el nombre setterGreetingService
@Service("setterGreetingBean")
public class GreetingServiceSetterInjection implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hey I'm Setting a Greeting!!!";
    }
}
