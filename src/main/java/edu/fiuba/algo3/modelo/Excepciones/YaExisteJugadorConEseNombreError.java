package edu.fiuba.algo3.modelo.Excepciones;

public class YaExisteJugadorConEseNombreError extends RuntimeException{
    public YaExisteJugadorConEseNombreError(String mensaje) {
        super(mensaje);
    }
}
