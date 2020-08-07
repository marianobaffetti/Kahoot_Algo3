package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoHayExclusividadesDisponiblesError;
import edu.fiuba.algo3.modelo.Excepciones.NoSeEncuentraElMultiplicadorError;
import edu.fiuba.algo3.modelo.Excepciones.YaHayUnMultiplicadorEnUsoError;
import edu.fiuba.algo3.modelo.Excepciones.YaHayUnaExclusividadEnUsoError;
import edu.fiuba.algo3.modelo.Multiplicadores.EstrategiaDeMultiplicacion;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorDefault;

import java.util.List;

public class Jugador {
    private final String nombre;
    private final List<EstrategiaDeMultiplicacion> multiplicadores;
    private double puntaje;
    private EstrategiaDeMultiplicacion multiplicador;
    private boolean multiplicadorEnUso;
    private boolean exclusividadEnUso;
    private int cantidadDeExclusividades;

    public Jugador(String nombre, List<EstrategiaDeMultiplicacion> multiplicadores) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.multiplicador = new MultiplicadorDefault();
        this.multiplicadores = multiplicadores;
        this.multiplicadorEnUso = false;
        this.exclusividadEnUso = false;
        this.cantidadDeExclusividades = 2;
    }

    public double obtenerPuntaje() {
        return this.puntaje;
    }

    public void actualizarPuntaje(double puntos) {
        this.puntaje += this.multiplicador.multiplicar(puntos);
        this.resetear();
    }

    private void resetear() {
        this.multiplicador = new MultiplicadorDefault();
        this.multiplicadorEnUso = false;
        this.exclusividadEnUso = false;
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

    public void usarExclusividad() {
        if (this.exclusividadEnUso) throw new YaHayUnaExclusividadEnUsoError();

        if (cantidadDeExclusividades == 0) throw new NoHayExclusividadesDisponiblesError();

        exclusividadEnUso = true;
        cantidadDeExclusividades--;
    }

    public boolean activoExclusividad() {
        return this.exclusividadEnUso;
    }
}
