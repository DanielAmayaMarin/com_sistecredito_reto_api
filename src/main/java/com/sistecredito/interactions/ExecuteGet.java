package com.sistecredito.interactions;

import com.sistecredito.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;

public class ExecuteGet implements Interaction {
    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(Endpoints.URL_MEMBERS).with(
                        resource -> resource.header(
                                "Authorization", "Basic " + environmentVariables.getProperty("environments.Authorization.key")
                        )
                )

        );

        if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
            System.out.println("Algo salio mal");
        }
    }

    public static ExecuteGet service(){
        return Instrumented.instanceOf(ExecuteGet.class).withProperties();
    }
}
