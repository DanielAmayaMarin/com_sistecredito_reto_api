package com.sistecredito.interactions;

import com.sistecredito.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;

public class ExecuteGetId implements Interaction {

    private final String id;
    private EnvironmentVariables environmentVariables;

    public ExecuteGetId(String id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

            SerenityRest.reset();
            actor.attemptsTo(
                    Get.resource(Endpoints.URL_MEMBERSID + id)
                            .with(
                                    resource -> resource.header(
                                            "Authorization", "Basic " + environmentVariables.getProperty("environments.Authorization.key")
                                    )
                            )
            );
            if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
                System.out.println("Error");
            }

    }

    public static ExecuteGetId service(String id){
        return Instrumented.instanceOf(ExecuteGetId.class).withProperties(id);
    }
}
