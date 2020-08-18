package edu.fiuba.algo3.modelo.Excepciones;

public class JugadorNoSePedeCrearConNombreVacioError extends RuntimeException {
    public JugadorNoSePedeCrearConNombreVacioError(String mensaje) {
        super(mensaje);
    }
}
