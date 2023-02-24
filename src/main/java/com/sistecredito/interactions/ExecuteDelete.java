package com.sistecredito.interactions;

import com.sistecredito.exceptions.AssertionsServices;
import com.sistecredito.exceptions.ErrorServicesException;
import com.sistecredito.utils.constants.Constantes;
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
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Delete.from(Endpoints.URL_MEMBERSID + id ).with(
                            resource -> resource.header(
                                    "Authorization", "Basic " + environmentVariables.getProperty("environments.Authorization.key")
                            )
                    )
            );
            if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK){
                throw new ErrorServicesException(AssertionsServices.EL_CODIGO_DE_RESPUESTA_ES_DIFERENTE_AL_APROPIADO);
            }
        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_EXECUTEDELETE), ex);
        }


    }

    public static ExecuteDelete service(String id){
        return Instrumented.instanceOf(ExecuteDelete.class).withProperties(id);
    }
}
