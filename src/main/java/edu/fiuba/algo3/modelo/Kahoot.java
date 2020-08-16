package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeIniciarJuegoSiNoHayJugadoresError;
import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeIniciarJuegoSiNoHayPreguntasError;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;

public class Kahoot extends Observable {
    private static Kahoot instance;
    private String estado;
    private int numeroDeRonda;
    private Ronda rondaActual;
    private List<Ronda> rondas;
    private List<Jugador> jugadores;
    private Iterator<Ronda> iteradorRondas;
    private List<Pregunta> preguntas;

    private Kahoot() {
        this.iteradorRondas = Collections.emptyIterator();
        this.numeroDeRonda = 0;
        this.estado = "MOSTRAR_PREGUNTA";
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
        if (this.jugadores == null) throw new NoSePuedeIniciarJuegoSiNoHayJugadoresError();
        if (this.preguntas == null) throw new NoSePuedeIniciarJuegoSiNoHayPreguntasError();
        crearRondas();
        siguienteRonda();
        setChanged();
    }

    public String obtenerTextoDePregunta() {
        return this.rondaActual.obtenerPregunta().obtenerTexto();
    }

    public List<Opcion> obtenerOpciones() {
        return this.rondaActual.obtenerPregunta().obtenerOpciones();
    }

    public void agregarPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;

    }

    private void crearRondas() {
        this.rondas = this.preguntas.stream().map(pregunta -> new Ronda(pregunta, this.jugadores)).collect(Collectors.toList());
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
        } else {
            this.finalizar();
        }
    }

    private void finalizar() {
        this.estado = "MOSTRAR_PUNTAJES";
    }

    public int obtenerNumeroDeRonda() {
        return this.numeroDeRonda;
    }

    public void agregarRespuesta(List<Opcion> opciones) {
        this.rondaActual.agregarRespuesta(new Respuesta(opciones,this.rondaActual.jugadorActual()));
        setChanged();
    }

    public String obtenerEtapa() {
        return this.estado;
    }

    public Ronda obtenerRondaActual() {
        return this.rondaActual;
    }

    public List<Jugador> obtenerJugadores() {
        return this.jugadores;
    }
}
