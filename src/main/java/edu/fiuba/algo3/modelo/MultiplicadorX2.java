package edu.fiuba.algo3.modelo;

public class MultiplicadorX2 implements EstrategiaDeMultiplicacion {
    @Override
    public long multiplicar(long puntos) {
        return puntos * 2;
    }
}
