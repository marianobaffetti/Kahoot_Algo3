package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface IPregunta {

    public ArrayList<Resultado> obtenerResultados(ArrayList<IRespuesta> respuestas);

    public Boolean respuestaEsCorrecta(IRespuesta respuesta);

    public ArrayList<Opcion> obtenerOpcionesCorrectas();
}
