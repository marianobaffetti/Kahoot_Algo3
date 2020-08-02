package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class VerdaderoFalso extends Pregunta {
    private final Opcion respuestaCorrecta;
    private final MultipleChoice multipleChoice;

    public VerdaderoFalso(String texto, List<Opcion> opciones) {
        this.respuestaCorrecta = opciones.stream().filter(opcion -> opcion.esCorrecta()).collect(Collectors.toList()).get(0);
        this.multipleChoice = new MultipleChoice(texto, opciones);
    }

    public Resultado obtenerResultado(Respuesta respuesta) {
        var puntos = 0;
        if (this.multipleChoice.respuestaEsCorrecta(respuesta)) {
            puntos = 1;
        }
        return new Resultado(puntos, respuesta.obtenerJugador());
    }

    public Boolean respuestaEsCorrecta(Respuesta respuesta) {
        return this.multipleChoice.respuestaEsCorrecta(respuesta);
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.multipleChoice.obtenerOpcionesCorrectas();
    }

    @Override
    public void asignarMultiplicadorX2AJugador(Jugador jugador) {
        jugador.usarMultiplicador(new MultiplicadorX2());
    }
}
