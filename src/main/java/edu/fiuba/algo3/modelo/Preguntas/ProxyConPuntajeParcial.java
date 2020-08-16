package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeUtilizarMultiplicadorError;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.List;

public class ProxyConPuntajeParcial extends Pregunta {
    private final Pregunta pregunta;

    public ProxyConPuntajeParcial(Pregunta pregunta) {
        super(pregunta.obtenerTexto());
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

    @Override
    public void asignarMultiplicadorX3AJugador(Jugador jugador) {
        throw new NoSePuedeUtilizarMultiplicadorError();
    }

    @Override
    public String obtenerTipo() {
        return this.pregunta.obtenerTipo() + "_CON_PUNTAJE_PARCIAL";
    }

    public Resultado obtenerResultado(Respuesta respuesta) {
        var correctas = this.obtenerOpcionesCorrectas();
        var elegidas = respuesta.obtenerOpcionesElegidas();

        if (!elegidas.stream().allMatch(opcion1 -> correctas.contains(opcion1)))
            return new Resultado(0, respuesta.obtenerJugador());

        return new Resultado(elegidas.stream().filter(opcion -> correctas.contains(opcion)).count(), respuesta.obtenerJugador());
    }
}
