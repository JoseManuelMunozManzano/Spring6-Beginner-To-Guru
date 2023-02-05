package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Inyección de Dependencias sin Spring
// Usando setters
// Mejor que usando properties, pero no la más óptima.
// Problema: Si esta clase es instanciada, pero no se hace setGreetingService, obtenemos un NullPointerException
class SetterInjectedControllerTest {

    SetterInjectedController setterInjectedController;

    @BeforeEach
    void setUp() {
        setterInjectedController = new SetterInjectedController();
        // Si nos olvidamos de establecer el setter, obtenemos un NullPointerException
        setterInjectedController.setGreetingService(new GreetingServiceImpl());
    }

    @Test
    void sayHello() {
        System.out.println(setterInjectedController.sayHello());
    }
}