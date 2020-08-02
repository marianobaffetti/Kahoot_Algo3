package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Pregunta {
    public List<Resultado> obtenerResultados(List<Respuesta> respuestas) {
        return respuestas
                .stream()
                .map(respuesta -> this.obtenerResultado(respuesta))
                .collect(Collectors.toList());
    }

    protected abstract Resultado obtenerResultado(Respuesta respuesta);

    public abstract Boolean respuestaEsCorrecta(Respuesta respuesta);

    public abstract List<Opcion> obtenerOpcionesCorrectas();
}
