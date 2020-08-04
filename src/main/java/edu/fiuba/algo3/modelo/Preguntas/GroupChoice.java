package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.List;

public class GroupChoice extends Pregunta {
    private final String texto;

    public GroupChoice(String texto, List<Opcion> opciones) {
        super();
        this.texto = texto;
        this.opciones = opciones;
    }

    protected Resultado obtenerResultado(Respuesta respuesta) {
        var gruposCorrectos = this.opciones
                .stream()
                .allMatch(opcion -> respuesta.concideCon(opcion));

        return new Resultado(gruposCorrectos ? this.opciones.size() : 0, respuesta.obtenerJugador());
    }

    public Boolean respuestaEsCorrecta(Respuesta respuesta) {
        throw new UnsupportedOperationException();
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        throw new UnsupportedOperationException();
    }
}
