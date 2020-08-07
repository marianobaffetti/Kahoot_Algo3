package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeUtilizarExclusividadError;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

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

    @Override
    public void asignarMultiplicadorX3AJugador(Jugador jugador) {
        this.pregunta.asignarMultiplicadorX3AJugador(jugador);
    }

    public Resultado obtenerResultado(Respuesta respuesta) {
        var correctas = this.obtenerOpcionesCorrectas();
        var elegidas = respuesta.obtenerOpcionesElegidas();
        var aciertos = elegidas.stream().filter(opcion -> correctas.contains(opcion)).count();
        var puntos = aciertos - (elegidas.size() - aciertos);

        return new Resultado(puntos, respuesta.obtenerJugador());
    }

    @Override
    public void usarExclusividad(Jugador jugador) {
        throw new NoSePuedeUtilizarExclusividadError();
    }

}