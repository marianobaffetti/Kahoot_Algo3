package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleChoice extends Pregunta {
    public MultipleChoice(String texto, List<Opcion> opciones) {
        super(texto);
        this.opciones = opciones;
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.opciones
                .stream()
                .filter(opcion -> opcion.esCorrecta())
                .collect(Collectors.toList());
    }

    @Override
    public String obtenerTipo() {
        return "MULTIPLE_CHOICE";
    }

    public Resultado obtenerResultado(Respuesta respuesta) {
        var correctas = this.obtenerOpcionesCorrectas();
        var puntos = respuesta
                .obtenerOpcionesElegidas()
                .stream()
                .filter(elegida -> correctas.contains(elegida))
                .count();

        return new Resultado((puntos == correctas.size() ? puntos : 0), respuesta.obtenerJugador());
    }

    public Boolean respuestaEsCorrecta(Respuesta respuesta) {
        return respuesta.obtenerOpcionesElegidas()
                .stream()
                .allMatch(opcion -> this.obtenerOpcionesCorrectas().contains(opcion));
    }
}
