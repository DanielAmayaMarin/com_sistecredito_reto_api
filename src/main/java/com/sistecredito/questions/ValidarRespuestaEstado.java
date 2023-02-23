package com.sistecredito.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.apache.http.HttpStatus;

public class ValidarRespuestaEstado implements Question<Boolean> {
    private final int codigo;
    public ValidarRespuestaEstado(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                ResponseConsequence.seeThatResponse("Código de estado de la respuesta de la API del servicio",
                        response -> response
                                .statusCode(codigo))
        );
        return SerenityRest.lastResponse().statusCode() == codigo;
    }
    public static ValidarRespuestaEstado expected(int codigo){
        return new ValidarRespuestaEstado(codigo);
    }
}
