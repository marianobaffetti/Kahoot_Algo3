package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice {
    private final ArrayList<Opcion> respuestasCorrecta;
    private final String texto;

    public MultipleChoice(String texto, ArrayList<Opcion> respuestasCorrecta) {
        this.texto = texto;
        this.respuestasCorrecta = respuestasCorrecta;
    }

    public Boolean respuestaEsCorrecta(RespuestaMultipleChoice respuesta){
        return true;
    }
}
