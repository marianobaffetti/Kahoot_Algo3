package edu.fiuba.algo3.modelo;

import java.util.List;

public class ProxyConPuntajeParcial extends Pregunta {
    private final Pregunta pregunta;

    public ProxyConPuntajeParcial(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Boolean respuestaEsCorrecta(Respuesta respuesta) {
        return this.pregunta.respuestaEsCorrecta(respuesta);
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.pregunta.obtenerOpcionesCorrectas();
    }

    @Override
    public void asignarMultiplicadorX2AJugador(Jugador jugador) {
        throw new NoSePuedeUtilizarMultiplicadorError();
    }

    public Resultado obtenerResultado(Respuesta respuesta) {
        var correctas = this.obtenerOpcionesCorrectas();
        var elegidas = respuesta.obtenerOpcionesElegidas();

        if (!elegidas.stream().allMatch(opcion1 -> correctas.contains(opcion1)))
            return new Resultado(0, respuesta.obtenerJugador());

        return new Resultado(elegidas.stream().filter(opcion -> correctas.contains(opcion)).count(), respuesta.obtenerJugador());
    }
}
