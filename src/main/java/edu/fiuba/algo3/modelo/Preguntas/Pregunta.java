package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Pregunta {
    protected List<Opcion> opciones;

    public List<Resultado> obtenerResultados(List<Respuesta> respuestas) {
        return respuestas
                .stream()
                .map(respuesta -> this.obtenerResultado(respuesta))
                .collect(Collectors.toList());
    }

    protected abstract Resultado obtenerResultado(Respuesta respuesta);

    public abstract Boolean respuestaEsCorrecta(Respuesta respuesta);

    public abstract List<Opcion> obtenerOpcionesCorrectas();

    public void asignarMultiplicadorX2AJugador(Jugador jugador) {
            jugador.usarMultiplicador("MULTIPLICADOR_X_2");
    }

    public void asignarMultiplicadorX3AJugador(Jugador jugador) {
        jugador.usarMultiplicador("MULTIPLICADOR_X_3");
    }

    public List<Opcion> obtenerOpciones() {
        return this.opciones;
    }

    public void usarExclusividad(Jugador jugador){ jugador.usarExclusividad(); }
}
