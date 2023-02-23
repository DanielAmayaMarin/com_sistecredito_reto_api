package com.sistecredito.taks;

import com.sistecredito.interactions.ExecuteGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumeGet implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecuteGet.service()
        );
    }

    public static ConsumeGet service(){
        return Tasks.instrumented(ConsumeGet.class);
    }
}
