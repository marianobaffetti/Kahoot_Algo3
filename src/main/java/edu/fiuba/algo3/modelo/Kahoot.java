package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoSePuedenAgregarPreguntasSiNoHayJugadoresError;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.*;
import java.util.stream.Collectors;

public class Kahoot extends Observable {
    private static Kahoot instance;
    private int numeroDeRonda;
    private Ronda rondaActual;
    private List<Ronda> rondas;
    private List<Jugador> jugadores;
    private Iterator<Ronda> iteradorRondas;

    private Kahoot() {
        this.iteradorRondas = Collections.emptyIterator();
        this.numeroDeRonda = 0;
    }

    public static Kahoot getInstance() {
        if (instance == null) instance = new Kahoot();
        return instance;
    }

    public boolean hayRondaEnJuego() {
        return this.rondaActual != null;
    }

    public String obtenerTipoDePregunta() {
        return this.rondaActual.obtenerPregunta().obtenerTipo();
    }

    public void iniciar() {
        this.siguienteRonda();
        setChanged();
    }

    public String obtenerTextoDePregunta() {
        return this.rondaActual.obtenerPregunta().obtenerTexto();
    }

    public List<Opcion> obtenerOpciones() {
        return this.rondaActual.obtenerPregunta().obtenerOpciones();
    }

    public void agregarPreguntas(List<Pregunta> preguntas) {
        if (this.jugadores == null) throw new NoSePuedenAgregarPreguntasSiNoHayJugadoresError();
        this.rondas = preguntas.stream().map(pregunta -> new Ronda(pregunta, this.jugadores)).collect(Collectors.toList());
        this.iteradorRondas = this.rondas.iterator();
    }

    public void agregarJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void siguienteRonda() {
        if (this.iteradorRondas.hasNext()) {
            this.rondaActual = this.iteradorRondas.next();
            this.rondaActual.iniciar();
            this.numeroDeRonda++;
        }
    }

    public int obtenerNumeroDeRonda() {
        return this.numeroDeRonda;
    }

    public void agregarRespuesta(Respuesta respuesta) {
        this.rondaActual.agregarRespuesta(respuesta);
    }

    public String obtenerEtapa() {
        return "MOSTRAR_PREGUNTA";
    }

    public Ronda obtenerRondaActual() {
        return this.rondaActual;
    }
}
