package edu.fiuba.algo3.modelo;

import java.util.List;

public class ProxyConPenalidad extends Pregunta {
    private final Pregunta pregunta;

    public ProxyConPenalidad(Pregunta pregunta) {
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
        this.pregunta.asignarMultiplicadorX2AJugador(jugador);
    }

    public Resultado obtenerResultado(Respuesta respuesta) {
        var correctas = this.obtenerOpcionesCorrectas();
        var elegidas = respuesta.obtenerOpcionesElegidas();
        var aciertos = elegidas.stream().filter(opcion -> correctas.contains(opcion)).count();
        var puntos = aciertos - (elegidas.size() - aciertos);

        return new Resultado(puntos, respuesta.obtenerJugador());
    }

}
