package com.sistecredito.taks;

import com.sistecredito.interactions.ExecuteDelete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumoDelete implements Task {

    private String id;

    public ConsumoDelete(String id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecuteDelete.service(id)
        );
    }

    public static ConsumoDelete service(String id){
        return Tasks.instrumented(ConsumoDelete.class, id);
    }
}

