package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.List;

public class VerdaderoFalso extends Pregunta {
    private final MultipleChoice multipleChoice;

    public VerdaderoFalso(String texto, List<Opcion> opciones) {
        super(texto);
        this.multipleChoice = new MultipleChoice(texto, opciones);
    }

    public Resultado obtenerResultado(Respuesta respuesta) {
        return new Resultado(this.multipleChoice.respuestaEsCorrecta(respuesta) ? 1 : 0, respuesta.obtenerJugador());
    }

    public Boolean respuestaEsCorrecta(Respuesta respuesta) {
        return this.multipleChoice.respuestaEsCorrecta(respuesta);
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.multipleChoice.obtenerOpcionesCorrectas();
    }

    @Override
    public String obtenerTipo() {
        return "VERDADERO_O_FALSO";
    }
}
