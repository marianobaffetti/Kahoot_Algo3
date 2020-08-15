package edu.fiuba.algo3.modelo.Multiplicadores;

public abstract class EstrategiaDeMultiplicacion {
    protected String nombre;
    protected Boolean activa = true;

    public abstract double multiplicar(double puntos);

    public String obtenerNombre() {
        return this.nombre;
    }

    public Boolean activo() {
        return this.activa;
    }

    public void desactivar() {
        this.activa = false;
    }
}
