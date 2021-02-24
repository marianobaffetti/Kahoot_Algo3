package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.*;
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
        if (nombre.trim().isEmpty()) throw new JugadorNoSePuedeCrearConNombreVacioError("El nombre del jugador no puede estar vacío.");
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
        if (this.multiplicadorEnUso) throw new YaHayUnMultiplicadorEnUsoError("Ya hay un multiplicador en uso.");

        var multiplicadorElegido = this.multiplicadores
                .stream()
                .filter(multiplicador -> multiplicador.obtenerNombre().equals(nombreDeMultiplicador))
                .findFirst();

        if (multiplicadorElegido.isEmpty())
            throw new NoSeEncuentraElMultiplicadorError("No se encuentra el multiplicador.");

        this.multiplicador = multiplicadorElegido.get();
        multiplicadores.remove(multiplicadorElegido.get());
        this.multiplicadorEnUso = true;
    }

    public void usarExclusividad() {
        if (this.exclusividadEnUso) throw new YaHayUnaExclusividadEnUsoError("Ya hay una exclusividad en uso.");

        if (cantidadDeExclusividades == 0)
            throw new NoHayExclusividadesDisponiblesError("No hay exclusividades disponibles.");

        exclusividadEnUso = true;
        cantidadDeExclusividades--;
    }


    public boolean activoExclusividad() {
        return this.exclusividadEnUso;
    }

    public EstrategiaDeMultiplicacion obtenerMultiplicadorEnUso() {
        return this.multiplicador;
    }
}
