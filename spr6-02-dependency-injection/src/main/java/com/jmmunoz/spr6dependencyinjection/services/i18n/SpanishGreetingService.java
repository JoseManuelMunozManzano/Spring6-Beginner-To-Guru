package com.jmmunoz.spr6dependencyinjection.services.i18n;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Con los Profiles puede controlarse lo que se inyecta en el contexto y lo que no
// Como puede verse, en el @Service el nombre que aparece en este service y en EnglishGreetingService es el mismo.
// Lo que los diferencia en el Profile
@Profile("ES")
@Service("i18NService")
public class SpanishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
