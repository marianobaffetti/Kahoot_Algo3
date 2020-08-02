package edu.fiuba.algo3.modelo;

public class MultiplicadorDefault implements EstrategiaDeMultiplicacion {
    @Override
    public long multiplicar(long puntos) {
        return puntos;
    }
}
