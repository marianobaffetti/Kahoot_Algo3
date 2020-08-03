package edu.fiuba.algo3.modelo;

public class OpcionOrderedChoice implements Opcion {
    private final String texto;
    private final int orden;

    public OpcionOrderedChoice(String texto, int orden) {
        this.texto = texto;
        this.orden = orden;
    }

    public Boolean esCorrecta() {
        return true;
    }

    @Override
    public Boolean coincideCon(Opcion opcion) {
        return opcion.coincideCon(this.texto,this.orden);
    }

    @Override
    public <T> Boolean coincideCon(String texto, T condicion) {
        return this.texto == texto && condicion.equals(this.orden);
    }
}