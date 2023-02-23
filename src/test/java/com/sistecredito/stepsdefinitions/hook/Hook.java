package com.sistecredito.stepsdefinitions.hook;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class Hook {
    private EnvironmentVariables environmentVariables;
    @Before
    public void configuracionBaseUrl(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Daniel");
        String theRestApiBaseUrl = environmentVariables.optionalProperty("environments.qa.base.url")
                .orElse("environments.dev.base.url");
        theActorInTheSpotlight().whoCan(CallAnApi.at(theRestApiBaseUrl));

    }
}
