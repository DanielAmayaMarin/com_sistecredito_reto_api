package com.sistecredito.stepsdefinitions;

import com.sistecredito.exceptions.AssertionsServices;
import com.sistecredito.questions.ValidarRespuestaEstado;
import com.sistecredito.taks.ConsumoDelete;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteStepDefinition {

    @When("Se llama la API Delete members {string}")
    public void seLlamaLaAPIDeleteMembers(String id) {
        theActorInTheSpotlight().attemptsTo(
                ConsumoDelete.service(id)
        );
    }
    @Then("Debería ver el código {int}")
    public void deberíaVerElCódigo(Integer codigo) {
        theActorInTheSpotlight()
                .should(seeThat(ValidarRespuestaEstado.expected(codigo))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.NO_SE_ESPERA_LA_RESPUESTA_DE_LOS_SERVICIOS_DE_CÓDIGO_DE_ESTADO)
                );
    }
}
