package com.sistecredito.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

public class ValidarRetornoDatos implements Question<Boolean> {

    private String nombre;

    public ValidarRetornoDatos(String nombre){
        this.nombre = nombre;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.should(
                ResponseConsequence.seeThatResponse("Validar los datos de la respuesta",
                        response -> response
                                .assertThat()
                                .and().body("name", Matchers.equalTo(nombre)))
        );
        return true;
    }

    public static ValidarRetornoDatos expected(String nombre){
        return new ValidarRetornoDatos(nombre);
    }
}
