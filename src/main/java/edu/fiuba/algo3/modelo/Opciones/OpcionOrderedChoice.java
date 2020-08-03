package edu.fiuba.algo3.modelo.Opciones;

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

    public Boolean coincideCon(Opcion opcion) {
        return opcion.coincideCon(this.texto, this.orden);
    }

    public <T> Boolean coincideCon(String texto, T condicion) {
        return this.texto == texto && condicion.equals(this.orden);
    }
}