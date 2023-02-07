package com.jmmunoz.spr6dependencyinjection.services.i18n;

import com.jmmunoz.spr6dependencyinjection.services.GreetingService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

// Si no activamos ningún profile en los tests, nos va a dar error salvo que indiquemos el default profile,
// que estará activo cuando no indicamos un profile.
// En el ejemplo estamos diciendo: Si no hay un profile disponible, permite que el profile EN se active.
//
// También se puede ver que podemos tener varios profiles disponibles en un service
@Profile({"EN", "default"})
@Service("i18NService")
public class EnglishGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
