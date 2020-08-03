package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Opciones.Opcion;

import java.util.List;

public class VerdaderoFalso extends Pregunta {
    private final MultipleChoice multipleChoice;

    public VerdaderoFalso(String texto, List<Opcion> opciones) {
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
