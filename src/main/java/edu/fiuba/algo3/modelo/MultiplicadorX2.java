package edu.fiuba.algo3.modelo;

public class MultiplicadorX2 extends EstrategiaDeMultiplicacion {
    public MultiplicadorX2() {
        this.nombre = "MULTIPLICADOR_X_2";
    }

    @Override
    public long multiplicar(long puntos) {
        return puntos * 2;
    }
}
