package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class MultipleChoice extends Pregunta {
    private final List<Opcion> opciones;
    private final String texto;

    public MultipleChoice(String texto, List<Opcion> opciones) {
        this.texto = texto;
        this.opciones = opciones;
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.opciones
                .stream()
                .filter(opcion -> opcion.esCorrecta())
                .collect(Collectors.toList());
    }

    @Override
    public void asignarMultiplicadorX2AJugador(Jugador jugador) {
        jugador.usarMultiplicador(new MultiplicadorX2());
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
