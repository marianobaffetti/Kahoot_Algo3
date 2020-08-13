package edu.fiuba.algo3.modelo.Excepciones;

public class NoSePuedeIniciarJuegoSiNoHayJugadoresError extends RuntimeException{
    public NoSePuedeIniciarJuegoSiNoHayJugadoresError(String mensaje) {
        super(mensaje);
    }
}
