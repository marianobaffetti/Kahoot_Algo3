package edu.fiuba.algo3.modelo.Excepciones;

public class YaHayUnMultiplicadorEnUsoError extends RuntimeException {
    public YaHayUnMultiplicadorEnUsoError(String mensaje) {
        super(mensaje);
    }
}
