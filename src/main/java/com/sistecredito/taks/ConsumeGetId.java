package com.sistecredito.taks;

import com.sistecredito.interactions.ExecuteGetId;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumeGetId implements Task {

    private final String id;

    public ConsumeGetId(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecuteGetId.service(id)
        );
    }

    public static ConsumeGetId service(String id){
        return Tasks.instrumented(ConsumeGetId.class, id);
    }
}
