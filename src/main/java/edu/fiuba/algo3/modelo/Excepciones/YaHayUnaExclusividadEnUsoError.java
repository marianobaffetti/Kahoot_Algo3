package edu.fiuba.algo3.modelo.Excepciones;

public class YaHayUnaExclusividadEnUsoError extends RuntimeException {
    public YaHayUnaExclusividadEnUsoError(String mensaje) {
        super(mensaje);
    }
}
