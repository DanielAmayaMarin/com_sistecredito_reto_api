package com.sistecredito.taks;

import com.sistecredito.interactions.ExecuteUpdate;
import com.sistecredito.models.MemberModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumoUpdate implements Task {

    private MemberModel memberModel;


    public ConsumoUpdate(MemberModel memberModel) {
        this.memberModel = memberModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteUpdate.service(memberModel));
    }

    public static ConsumoUpdate service(MemberModel memberModel) {
        return Tasks.instrumented(ConsumoUpdate.class, memberModel);
    }
}

