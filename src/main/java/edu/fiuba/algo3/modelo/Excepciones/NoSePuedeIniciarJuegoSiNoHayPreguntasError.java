package edu.fiuba.algo3.modelo.Excepciones;

public class NoSePuedeIniciarJuegoSiNoHayPreguntasError extends RuntimeException {
    public NoSePuedeIniciarJuegoSiNoHayPreguntasError(String mensaje) {
        super(mensaje);
    }
}
