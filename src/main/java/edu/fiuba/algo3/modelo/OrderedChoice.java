package edu.fiuba.algo3.modelo;

import java.util.List;

public class OrderedChoice extends Pregunta {
    private final String texto;
    private final List<Opcion> opciones;

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

    @Override
    public Boolean respuestaEsCorrecta(Respuesta respuesta) {
        return null;
    }

    @Override
    public List<Opcion> obtenerOpcionesCorrectas() {
        return null;
    }

    @Override
    public void asignarMultiplicadorX2AJugador(Jugador jugador) {
        jugador.usarMultiplicador(new MultiplicadorX2());
    }
}
