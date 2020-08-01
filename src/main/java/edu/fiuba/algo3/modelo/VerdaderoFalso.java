package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VerdaderoFalso implements IPregunta {
    private final Opcion respuestaCorrecta;
    private final MultipleChoice multipleChoice;

    public VerdaderoFalso(String texto, List<Opcion> opciones) {
        this.respuestaCorrecta = opciones.stream().filter(opcion -> opcion.esCorrecta()).collect(Collectors.toList()).get(0);
        this.multipleChoice = new MultipleChoice(texto, opciones);
    }

    public List<Resultado> obtenerResultados(List<IRespuesta> respuestas) {
        var resultados = new ArrayList<Resultado>();
        respuestas.forEach(respuesta -> resultados.add(this.obtenerResultado(respuesta)));
        return resultados;
    }

    private Resultado obtenerResultado(IRespuesta respuesta) {
        var puntos = 0;
        if (this.multipleChoice.respuestaEsCorrecta(respuesta)) {
            puntos = 1;
        }
        return new Resultado(puntos, respuesta.obtenerJugador());
    }

    public Boolean respuestaEsCorrecta(IRespuesta respuesta) {
        return this.multipleChoice.respuestaEsCorrecta(respuesta);
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.multipleChoice.obtenerOpcionesCorrectas();
    }
}
