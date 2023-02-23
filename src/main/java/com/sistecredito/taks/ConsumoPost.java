package com.sistecredito.taks;

import com.sistecredito.interactions.ExecutePost;
import com.sistecredito.models.MemberModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class ConsumoPost implements Task {

    private MemberModel memberModel;

    public ConsumoPost(MemberModel memberModel) {
        this.memberModel = memberModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExecutePost.service(memberModel)
        );
    }

    public static ConsumoPost service(MemberModel memberModel) {
        return Tasks.instrumented(ConsumoPost.class, memberModel);
    }
}

