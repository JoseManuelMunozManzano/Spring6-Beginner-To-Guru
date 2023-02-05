package com.jmmunoz.spr6dependencyinjection;

import com.jmmunoz.spr6dependencyinjection.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spr602DependencyInjectionApplication {

	public static void main(String[] args) {
		// Como no tenemos Tomcat (no hemos añadido la dependencia web), modificamos el run para que nos lo
		// pase a una variable de contexto de aplicación
		ApplicationContext ctx = SpringApplication.run(Spr602DependencyInjectionApplication.class, args);

		// Vamos al contexto Spring y preguntamos directamente por una instancia de MyController.
		// Este es un ejemplo de como Spring y el contexto Spring ven al controlador que ha sido anotado indicando
		// que es un Spring Bean.
		MyController controller = ctx.getBean(MyController.class);

		System.out.println("In Main Method");

		// Ejecutando el método desde el contexto de Spring.
		System.out.println(controller.sayHello());
	}

}
