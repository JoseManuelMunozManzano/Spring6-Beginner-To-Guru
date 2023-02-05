package com.jmmunoz.spr6dependencyinjection;

import com.jmmunoz.spr6dependencyinjection.controllers.MyController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

// Spring Dependency Injection en acción en los tests
// Esta anotación indica al test que cree un contexto de Spring
@SpringBootTest
class Spr602DependencyInjectionApplicationTests {

	// Forma 1 de usar MyController: Se inyecta ApplicationContext
	@Autowired
	ApplicationContext applicationContext;

	// Forma 2 de usar MyController: Como es un test podemos inyectar directamente una instancia (bean) de MyController
	@Autowired
	MyController myController;

	// El test de la forma 1
	// Usamos applicationContext para obtener una instancia (bean) de MyController y la usamos
	@Test
	void testGetControllerFromCtx() {
		MyController myController = applicationContext.getBean(MyController.class);

		System.out.println(myController.sayHello());
	}

	// El test de la forma 2
	// myController ya es una instancia (bean) concreta y la usamos
	@Test
	void testAutowiredOfController() {
		System.out.println(myController.sayHello());
	}

	@Test
	void contextLoads() {
	}

}
