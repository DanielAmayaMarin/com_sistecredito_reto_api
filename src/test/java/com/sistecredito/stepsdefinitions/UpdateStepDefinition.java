package com.sistecredito.stepsdefinitions;

import com.sistecredito.models.MemberModel;
import com.sistecredito.questions.ValidarRespuestaEstado;
import com.sistecredito.taks.ConsumoUpdate;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UpdateStepDefinition {

    @When("Se llama la API Update members")
    public void seLlamaLaAPIUpdateMembers(io.cucumber.datatable.DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                ConsumoUpdate.service(MemberModel.setData(dataTable).get(0))
        );
    }
    @Then("Debería actualizar el member correctamente {int}")
    public void deberíaActualizarElMemberCorrectamente(Integer codigo) {
        theActorInTheSpotlight()
                .should(seeThat(ValidarRespuestaEstado.expected(codigo))
                );
    }
}
