package edu.fiuba.algo3.modelo.Multiplicadores;

public abstract class EstrategiaDeMultiplicacion {
    protected String nombre;

    public abstract double multiplicar(double puntos);

    public String obtenerNombre() {
        return this.nombre;
    }
}
