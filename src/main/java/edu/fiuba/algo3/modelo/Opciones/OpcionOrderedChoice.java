package edu.fiuba.algo3.modelo.Opciones;

public class OpcionOrderedChoice extends Opcion {
    private final int orden;

    public OpcionOrderedChoice(String texto, int orden) {
        super(texto);
        this.orden = orden;
    }

    public Boolean esCorrecta() {
        throw new UnsupportedOperationException();
    }

    public Boolean coincideCon(Opcion opcion) {
        return opcion.coincideCon(this.texto, this.orden);
    }

    public <T> Boolean coincideCon(String texto, T condicion) {
        return this.texto == texto && condicion.equals(this.orden);
    }
}