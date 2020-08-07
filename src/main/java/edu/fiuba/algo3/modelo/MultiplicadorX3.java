package edu.fiuba.algo3.modelo;

public class MultiplicadorX3 extends EstrategiaDeMultiplicacion {
    public MultiplicadorX3() {
        this.nombre = "MULTIPLICADOR_X_3";
    }

    public double multiplicar(double puntos) {
        return puntos * 3;
    }
}
