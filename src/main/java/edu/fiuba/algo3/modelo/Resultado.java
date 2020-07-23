package edu.fiuba.algo3.modelo;

public class Resultado {
    private Boolean respuesta;

    public Resultado(Boolean respuesta) {
        this.respuesta = respuesta;
    }
    public Boolean esCorrecto() {
        return this.respuesta;
    }
}
