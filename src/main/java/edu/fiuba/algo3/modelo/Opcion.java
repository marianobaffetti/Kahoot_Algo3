package edu.fiuba.algo3.modelo;

public class Opcion {
    private final String texto;
    private final Boolean esVerdadera;

    public Opcion(String texto, Boolean esVerdadera) {
        this.texto = texto;
        this.esVerdadera = esVerdadera;
    }

    public Boolean esCorrecta() {
        return esVerdadera;
    }
}