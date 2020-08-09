package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.List;

public class OrderedChoice extends Pregunta {
    public OrderedChoice(String texto, List<Opcion> opciones) {
        super(texto);
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
        throw new UnsupportedOperationException();
    }

    @Override
    public String obtenerTipo() {
        return "ORDERED CHOICE";
    }
}
