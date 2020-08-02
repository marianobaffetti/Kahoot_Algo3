package edu.fiuba.algo3.modelo;

public interface Opcion {
    Boolean esCorrecta();
    Boolean coincideCon(String texto, int orden);
    Boolean coincideConAlgunaDe(Respuesta respuesta);
}
