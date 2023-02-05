package com.jmmunoz.spr6dependencyinjection.services;

import org.springframework.stereotype.Service;

// Para usar el Framework Spring, lo primero es anotar esta clase con el estereotipo de Spring @Service
// Con esto indicamos que esta clase es un componente que Spring puede manejar y que es inyectable.
@Service
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello Everyone From Base Service!!!";
    }
}
