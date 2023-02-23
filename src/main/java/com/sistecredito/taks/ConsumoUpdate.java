package com.sistecredito.taks;

import com.sistecredito.models.MemberModel;
import com.sistecredito.utils.constants.Endpoints;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import static io.restassured.http.ContentType.JSON;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;

public class ConsumoUpdate implements Task {

    private MemberModel memberModel;
    private EnvironmentVariables environmentVariables;

    public ConsumoUpdate(MemberModel memberModel) {
        this.memberModel = memberModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println();
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
            System.out.println("Error");
        }
    }

    public static ConsumoUpdate service(MemberModel memberModel) {
        return Tasks.instrumented(ConsumoUpdate.class, memberModel);
    }
}

