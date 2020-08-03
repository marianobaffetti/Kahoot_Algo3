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

    @Override
    public Boolean coincideCon(Opcion opcion) {
        return opcion.coincideCon(this.texto,this.esVerdadera);
    }

    @Override
    public <T> Boolean coincideCon(String texto, T condicion) {
        return this.texto == texto && condicion.equals(this.esVerdadera);
    }
    }