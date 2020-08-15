package edu.fiuba.algo3.modelo.Opciones;

public class OpcionDefault extends Opcion {
    private final Boolean correcta;

    public OpcionDefault(String texto, Boolean correcta) {
        super(texto);
        this.correcta = correcta;
    }

    public Boolean esCorrecta() {
        return correcta;
    }

    public Boolean coincideCon(Opcion opcion) {
        return opcion.coincideCon(this.texto, this.correcta);
    }

    public <T> Boolean coincideCon(String texto, T condicion) {
        return this.texto == texto && condicion.equals(this.correcta);
    }
}