package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoSeEncuentraElMultiplicadorError;
import edu.fiuba.algo3.modelo.Excepciones.YaHayUnMultiplicadorEnUsoError;

import java.util.List;
import java.util.Optional;

public class Jugador {
    private final String nombre;
    private final List<EstrategiaDeMultiplicacion> multiplicadores;
    private int puntaje;
    private EstrategiaDeMultiplicacion multiplicador;
    private boolean multiplicadorEnUso;

    public Jugador(String nombre, List<EstrategiaDeMultiplicacion> multiplicadores) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.multiplicador = new MultiplicadorDefault();
        this.multiplicadores = multiplicadores;
        this.multiplicadorEnUso = false;
    }

    public int obtenerPuntaje() {
        return this.puntaje;
    }

    public void actualizarPuntaje(long puntos) {
        this.puntaje += this.multiplicador.multiplicar(puntos);
        this.resetearMultiplicadores();
    }

    private void resetearMultiplicadores() {
        this.multiplicador = new MultiplicadorDefault();
        this.multiplicadorEnUso = false;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public void usarMultiplicador(String nombreDeMultiplicador) {
        if (this.multiplicadorEnUso) throw new YaHayUnMultiplicadorEnUsoError();

        var mulitiplicadorElegido = this.multiplicadores
                .stream()
                .filter(multiplicador -> multiplicador.obtenerNombre().equals(nombreDeMultiplicador))
                .findFirst();

        if (mulitiplicadorElegido.isEmpty()) throw new NoSeEncuentraElMultiplicadorError();

        this.multiplicador = mulitiplicadorElegido.get();
        this.multiplicadorEnUso = true;
    }
}
