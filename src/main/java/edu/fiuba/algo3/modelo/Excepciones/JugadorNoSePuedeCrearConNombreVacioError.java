package edu.fiuba.algo3.modelo.Excepciones;

public class JugadorNoSePuedeCrearConNombreVacioError extends RuntimeException {
    public JugadorNoSePuedeCrearConNombreVacioError(String mensaje) {
        super(mensaje);
    }
}
