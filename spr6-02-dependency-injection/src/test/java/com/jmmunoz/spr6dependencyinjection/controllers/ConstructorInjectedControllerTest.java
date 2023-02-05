package com.jmmunoz.spr6dependencyinjection.controllers;

import com.jmmunoz.spr6dependencyinjection.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// Inyección de Dependencias CON Spring
// Usando el estereotipo @SpringBootTest indicamos a JUnit que queremos cargar el contexto de Spring. Cuando se
//   ejecute el contexto Spring, mirará la configuración del contexto de aplicación determinado para nuestra aplicación,
//   hará el escaneo de componentes dentro del paquete y sub-paquetes donde está la clase main.
// Usando el constructor
// Forma óptima de inyectar dependencias
@SpringBootTest
class ConstructorInjectedControllerTest {

    // Spring, para poder hacer la inyección de dependencias con constructor, necesita la anotación @Autowired
    // en el property
    @Autowired
    ConstructorInjectedController controller;

    @Test
    void sayHello() {
        System.out.println(controller.sayHello());
    }
}