package edu.fiuba.algo3.modelo;

public class Jugador {
    private final String nombre;
    private int puntaje;
    private EstrategiaDeMultiplicacion multiplcador;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.multiplcador = new MultiplicadorDefault();
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }

    public void actualizarPuntaje(long puntos) {
        this.puntaje += this.multiplcador.multiplicar(puntos);
        this.reset();
    }

    private void reset() {
        this.multiplcador = new MultiplicadorDefault();
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void usarMultiplicador(EstrategiaDeMultiplicacion multiplicador) {
        this.multiplcador = multiplicador;
    }
}
