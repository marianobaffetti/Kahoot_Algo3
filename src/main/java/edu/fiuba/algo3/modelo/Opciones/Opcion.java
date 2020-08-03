package edu.fiuba.algo3.modelo.Opciones;

public interface Opcion {
    Boolean esCorrecta();

    Boolean coincideCon(Opcion opcion);

    <T> Boolean coincideCon(String texto, T condicion);
}
