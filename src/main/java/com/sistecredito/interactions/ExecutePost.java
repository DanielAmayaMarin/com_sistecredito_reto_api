package com.sistecredito.interactions;

import com.sistecredito.models.MemberModel;
import com.sistecredito.utils.constants.Endpoints;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.util.EnvironmentVariables;
import org.apache.http.HttpStatus;
import static io.restassured.http.ContentType.JSON;

public class ExecutePost implements Interaction {

    private MemberModel memberModel;
    private EnvironmentVariables environmentVariables;

    public ExecutePost(MemberModel memberModel){
        this.memberModel = memberModel;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            SerenityRest.reset();
            actor.attemptsTo(
                    Post.to(Endpoints.URL_MEMBERS)
                            .with(request -> request
                                    .contentType(JSON)
                                    .header("Authorization", "Basic " + environmentVariables.getProperty("environments.Authorization.key"))
                                    .body(memberModel.toString())
                                    .relaxedHTTPSValidation())
            );
            if(SerenityRest.lastResponse().statusCode() != HttpStatus.SC_CREATED){
                System.out.println("Error");
            }
    }

    public static ExecutePost service(MemberModel memberModel){
        return Instrumented.instanceOf(ExecutePost.class).withProperties(memberModel);
    }
}
