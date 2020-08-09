package edu.fiuba.algo3.modelo.Opciones;

public class OpcionGroupChoice implements Opcion {
    private final String texto;
    private final String grupo;

    public OpcionGroupChoice(String texto, String grupo) {
        this.texto = texto;
        this.grupo = grupo;
    }

    @Override
    public Boolean esCorrecta() {
        throw new UnsupportedOperationException();
    }

    public Boolean coincideCon(Opcion opcion) {
        return opcion.coincideCon(this.texto, this.grupo);
    }

    public <T> Boolean coincideCon(String texto, T condicion) {
        return this.texto == texto && condicion.equals(this.grupo);
    }
}
