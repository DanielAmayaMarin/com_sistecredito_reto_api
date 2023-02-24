package com.sistecredito.stepsdefinitions;

import com.sistecredito.exceptions.AssertionsServices;
import com.sistecredito.questions.ValidarRetornoDatos;
import com.sistecredito.taks.ConsumeGetId;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetIdStepDefinition {
    @When("Se llama la API GetId members {string}")
    public void seLlamaLaAPIGetIdMembers(String id) {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGetId.service(id)
        );
    }
    @Then("Valido que la busqueda sea correcta {string}")
    public void validoQueLaBusquedaSeaCorrecta(String nombre) {
        theActorInTheSpotlight()
                .should(seeThat(
                        ValidarRetornoDatos.expected(nombre))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.LOS_DATOS_DE_LA_RESPUESTA_NO_SON_LOS_CORRECTOS)
                );
    }
}
