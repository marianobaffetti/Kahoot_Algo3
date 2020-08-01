package edu.fiuba.algo3.modelo;

import java.util.List;

public interface IPregunta {

    public List<Resultado> obtenerResultados(List<IRespuesta> respuestas);

    public Boolean respuestaEsCorrecta(IRespuesta respuesta);

    public List<Opcion> obtenerOpcionesCorrectas();
}
