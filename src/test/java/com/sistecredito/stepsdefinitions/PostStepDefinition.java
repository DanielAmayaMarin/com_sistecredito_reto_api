package com.sistecredito.stepsdefinitions;

import com.sistecredito.exceptions.AssertionsServices;
import com.sistecredito.models.MemberModel;
import com.sistecredito.questions.ValidarRespuestaEstado;
import com.sistecredito.taks.ConsumoPost;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostStepDefinition {

    @When("Se llama la API Post members")
    public void seLlamaLaAPIPostMembers(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                ConsumoPost.service(MemberModel.setData(dataTable).get(0))
        );
    }
    @Then("Válido el registro exitoso {int}")
    public void válidoElRegistroExitoso(Integer codigo) {
        theActorInTheSpotlight()
                .should(seeThat(ValidarRespuestaEstado.expected(codigo))
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.NO_SE_ESPERA_LA_RESPUESTA_DE_LOS_SERVICIOS_DE_CÓDIGO_DE_ESTADO)
                );
    }
}
