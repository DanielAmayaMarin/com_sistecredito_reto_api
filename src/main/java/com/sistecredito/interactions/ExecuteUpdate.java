package com.sistecredito.interactions;

import com.sistecredito.exceptions.AssertionsServices;
import com.sistecredito.exceptions.ErrorServicesException;
import com.sistecredito.models.MemberModel;
import com.sistecredito.utils.constants.Constantes;
import com.sistecredito.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;
import static io.restassured.http.ContentType.JSON;

public class ExecuteUpdate implements Interaction {
    private MemberModel memberModel;
    private EnvironmentVariables environmentVariables;

    public ExecuteUpdate(MemberModel memberModel){
        this.memberModel = memberModel;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            SerenityRest.reset();
            actor.attemptsTo(
                    Put.to(Endpoints.URL_MEMBERSID + memberModel.getId())
                            .with(request -> request
                                    .contentType(JSON)
                                    .header("Authorization", "Basic " + environmentVariables.getProperty("environments.Authorization.key"))
                                    .body(memberModel.toString())
                                    .relaxedHTTPSValidation()
                            )
            );
            if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
                throw new ErrorServicesException(AssertionsServices.EL_CODIGO_DE_RESPUESTA_ES_DIFERENTE_AL_APROPIADO);
            }
        }catch (RuntimeException ex){
            throw new AssertionsServices(AssertionsServices.Error(Constantes.INTERACTION_EXECUTEUPDATE), ex);
        }
    }

    public static ExecuteUpdate service(MemberModel memberModel){
        return Instrumented.instanceOf(ExecuteUpdate.class).withProperties(memberModel);
    }
}
