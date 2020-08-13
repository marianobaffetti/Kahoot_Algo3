package edu.fiuba.algo3.modelo.Excepciones;

public class NoSePuedeUtilizarMultiplicadorError extends RuntimeException {
    public NoSePuedeUtilizarMultiplicadorError(String mensaje) {
        super(mensaje);
    }
}
