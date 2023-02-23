package com.sistecredito.interactions;

import com.sistecredito.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;

public class ExecuteDelete implements Interaction {

    private String id;
    private EnvironmentVariables environmentVariables;

    public ExecuteDelete(String id){
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

            SerenityRest.reset();
            actor.attemptsTo(
                    Delete.from(Endpoints.URL_MEMBERSID + id ).with(
                            resource -> resource.header(
                                    "Authorization", "Basic " + environmentVariables.getProperty("environments.Authorization.key")
                            )
                    )
            );
            if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
               System.out.println("Error");
            }

    }

    public static ExecuteDelete service(String id){
        return Instrumented.instanceOf(ExecuteDelete.class).withProperties(id);
    }
}
