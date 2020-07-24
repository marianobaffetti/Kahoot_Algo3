package edu.fiuba.algo3.modelo;

public class RespuestaVerdaderoFalso {
    private final boolean opcionElegida;
    private final Jugador jugador;

    public RespuestaVerdaderoFalso(boolean opcionElegida, Jugador jugador) {
        this.opcionElegida = opcionElegida;
        this.jugador = jugador;
    }

    public Boolean obtener() {
        return this.opcionElegida;
    }
    public Jugador obtenerJugador() {
        return this.jugador;
    }
}
