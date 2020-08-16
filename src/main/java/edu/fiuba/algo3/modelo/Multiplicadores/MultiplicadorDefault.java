package edu.fiuba.algo3.modelo.Multiplicadores;

public class MultiplicadorDefault extends EstrategiaDeMultiplicacion {

    public MultiplicadorDefault() {
    this.nombre = "MULTIPLICADOR_DEFAULT";
    }

    @Override
    public double multiplicar(double puntos) {
        return puntos;
    }
}
