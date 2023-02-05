package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Inyección de Dependencias sin Spring
// Usando properties
// Forma menos óptima de inyectar dependencias
// Problema: Si esta clase es instanciada, pero no se inicializa greetingService, obtenemos un NullPointerException
class PropertyInjectedControllerTest {

    PropertyInjectedController propertyInjectedController;

    @BeforeEach
    void setUp() {
        propertyInjectedController = new PropertyInjectedController();
        // Si nos olvidamos de inicializar la property, obtenemos un NullPointerException
        propertyInjectedController.greetingService = new GreetingServiceImpl();
    }

    @Test
    void sayHello() {
        System.out.println(propertyInjectedController.sayHello());
    }
}