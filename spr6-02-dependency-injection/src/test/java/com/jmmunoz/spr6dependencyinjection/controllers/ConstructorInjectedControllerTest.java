package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Inyección de Dependencias sin Spring
// Usando el constructor
// Forma óptima de inyectar dependencias
class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    // Notar que aunque es un test, se está imitando lo que hace el Framework Spring.
    // En los tests es buena idea hacer una assertion para que lance un Runtime Error si se le pasa null a GreetingService
    @BeforeEach
    void setUp() {
        controller = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    @Test
    void sayHello() {
        System.out.println(controller.sayHello());
    }
}