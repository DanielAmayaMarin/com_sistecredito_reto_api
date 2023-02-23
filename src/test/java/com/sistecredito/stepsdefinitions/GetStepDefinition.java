package com.sistecredito.stepsdefinitions;

import com.sistecredito.questions.ValidarRespuestaEstado;
import com.sistecredito.questions.ValidarSchema;
import com.sistecredito.taks.ConsumeGet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetStepDefinition {

    @When("Se llama la API Get members")
    public void seLlamaLaAPIGetMembers() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service()
        );
    }
    @Then("Debería ver el código de estado {int}")
    public void deberíaVerElCódigoDeEstado(Integer codigo) {
        theActorInTheSpotlight()
                .should(seeThat(ValidarRespuestaEstado.expected(codigo))
                );
    }
    @Then("Valido el esquema de la respuesta {string}")
    public void validoElEsquemaDeLaRespuesta(String GetJsonSchema) {
        theActorInTheSpotlight()
                .should(seeThat(
                        ValidarSchema.expected(GetJsonSchema))
                );
    }


}
