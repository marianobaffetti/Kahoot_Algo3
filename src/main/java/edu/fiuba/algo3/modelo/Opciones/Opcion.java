package edu.fiuba.algo3.modelo.Opciones;

public abstract class Opcion {
    protected final String texto;

    public Opcion(String texto) {
        this.texto = texto;
    }

    public abstract Boolean esCorrecta();

    public abstract Boolean coincideCon(Opcion opcion);

    public abstract <T> Boolean coincideCon(String texto, T condicion);

    public String obtenerTexto() {
        return this.texto;
    };
}
