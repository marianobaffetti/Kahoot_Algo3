package edu.fiuba.algo3.modelo;

public class OpcionDefault implements Opcion {
    private final String texto;
    private final Boolean esVerdadera;

    public OpcionDefault(String texto, Boolean esVerdadera) {
        this.texto = texto;
        this.esVerdadera = esVerdadera;
    }

    public Boolean esCorrecta() {
        return esVerdadera;
    }

    public Boolean coincideCon(String texto, int orden) {
        return true;
    }

    @Override
    public Boolean coincideConAlgunaDe(Respuesta respuesta) {
        return null;
    }
}