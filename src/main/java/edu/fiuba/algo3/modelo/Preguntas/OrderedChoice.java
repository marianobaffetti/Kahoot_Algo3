package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.List;

public class OrderedChoice extends Pregunta {
    private final String texto;

    public OrderedChoice(String texto, List<Opcion> opciones) {
        super();
        this.texto = texto;
        this.opciones = opciones;
    }

    public Resultado obtenerResultado(Respuesta respuesta) {
        var ordenCorrecto = this.opciones
                .stream()
                .allMatch(opcion -> respuesta.concideCon(opcion));

        return new Resultado(ordenCorrecto ? this.opciones.size() : 0, respuesta.obtenerJugador());
    }

    public Boolean respuestaEsCorrecta(Respuesta respuesta) {
        throw new UnsupportedOperationException();
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return null;
    }
}
