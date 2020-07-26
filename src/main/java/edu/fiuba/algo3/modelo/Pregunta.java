package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Pregunta {

    public ArrayList<Resultado> obtenerResultados(ArrayList<RespuestaVerdaderoFalso> respuestas);
    public Resultado obtenerResultado (RespuestaVerdaderoFalso respuesta);
    public Boolean respuestaEsCorrecta(RespuestaVerdaderoFalso respuesta);
}
