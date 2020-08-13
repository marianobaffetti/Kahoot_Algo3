package edu.fiuba.algo3.modelo.Excepciones;

public class NoSePuedeUtilizarExclusividadError extends RuntimeException {
    public NoSePuedeUtilizarExclusividadError(String mensaje) {
        super(mensaje);
    }
}
