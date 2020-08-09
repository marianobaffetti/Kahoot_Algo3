package edu.fiuba.algo3.modelo;

public abstract class EstrategiaDeMultiplicacion {
    protected String nombre;

    public abstract long multiplicar(long puntos);

    public String obtenerNombre() {
        return this.nombre;
    }
}
