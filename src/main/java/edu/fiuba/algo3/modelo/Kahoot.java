package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Utils.Temporizador;
import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeIniciarJuegoSiNoHayJugadoresError;
import edu.fiuba.algo3.modelo.Excepciones.NoSePuedeIniciarJuegoSiNoHayPreguntasError;
import edu.fiuba.algo3.modelo.Excepciones.YaExisteJugadorConEseNombreError;
import edu.fiuba.algo3.modelo.Multiplicadores.EstrategiaDeMultiplicacion;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorX2;
import edu.fiuba.algo3.modelo.Multiplicadores.MultiplicadorX3;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.*;
import java.util.stream.Collectors;

public class Kahoot extends Observable {
    private static Kahoot instance;
    private String estado;
    private int numeroDeRonda;
    private Ronda rondaActual;
    private List<Ronda> rondas;
    private final List<Jugador> jugadores;
    private Iterator<Ronda> iteradorRondas;
    private List<Pregunta> preguntas;
    private String mensaje;

    private Kahoot() {
        this.iteradorRondas = Collections.emptyIterator();
        this.numeroDeRonda = 0;
        this.estado = "MOSTRAR_PREGUNTA";
        this.jugadores = new ArrayList<>();
        this.mensaje = "";
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

    public void iniciarRondas() {
        if (this.jugadores.isEmpty())
            throw new NoSePuedeIniciarJuegoSiNoHayJugadoresError("No se puede iniciar el juego si no hay jugadores.");
        if (this.preguntas == null)
            throw new NoSePuedeIniciarJuegoSiNoHayPreguntasError("No se puede iniciar el juego si no hay preguntas.");
        this.estado = "MOSTRAR_INTRO_PREGUNTA";
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

    public void siguienteRonda() {
        if (this.iteradorRondas.hasNext()) {
            this.estado = "MOSTRAR_INTRO_PREGUNTA";
            this.rondaActual = this.iteradorRondas.next();
            this.rondaActual.iniciar();
            this.numeroDeRonda++;
        } else {
            this.finalizar();
        }
    }

    public void mostrarPregunta() {
        this.estado = "MOSTRAR_PREGUNTA";
        setChanged();
    }

    private void finalizar() {
        this.estado = "MOSTRAR_PUNTAJES";
    }

    public int obtenerNumeroDeRonda() {
        return this.numeroDeRonda;
    }

    public void agregarRespuesta(List<Opcion> opciones) {
        this.rondaActual.agregarRespuesta(new Respuesta(opciones, this.rondaActual.jugadorActual()));
        setChanged();
    }

    public void perderTurno() {
        this.mensaje = "Se le acabó el tiempo a " + this.rondaActual.jugadorActual().obtenerNombre();
        this.rondaActual.siguienteTurno();
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

    public void iniciar() {
        this.estado = "CREAR_JUGADORES";
        setChanged();
    }

    public void agregarJugador(String nombre) {
        try {
            if (this.jugadores.stream().anyMatch(jugador -> jugador.obtenerNombre().equals(nombre))) throw new YaExisteJugadorConEseNombreError("Ya existe un jugador con ese nombre.");

            var multiplicadores = new ArrayList<>(Arrays.asList(
                new MultiplicadorX3(),
                new MultiplicadorX2()
                ));

            this.jugadores.add(new Jugador(nombre, multiplicadores));

        } catch (RuntimeException ex) {
            this.mensaje = ex.getMessage();
        }
        setChanged();
    }

    public Jugador obtenerJugadorActual() {
        return this.rondaActual.obtenerJugadorActual();
    }

    public void usarMultiplicadorX2() {
        setChanged();
        try {
            this.rondaActual.asignarMultiplicadorX2AJugador(this.rondaActual.obtenerJugadorActual());
        } catch (RuntimeException e) {
            this.mensaje = e.getMessage();
        }
    }

    public String obtenerMensaje() {
        return this.mensaje;
    }

    public void limpiarMensaje() {
        this.mensaje = "";
        setChanged();
    }

    public void usarMultiplicadorX3() {
        setChanged();
        try {
            this.rondaActual.asignarMultiplicadorX3AJugador(this.rondaActual.obtenerJugadorActual());
        } catch (RuntimeException e) {
            this.mensaje = e.getMessage();
        }
    }

    public List<Jugador> obtenerGanadores() {
        var puntajeMaximo = this.jugadores
            .stream()
            .max(Comparator.comparing( jugador -> jugador.obtenerPuntaje()))
            .get().obtenerPuntaje();

        return this.jugadores
            .stream()
            .filter(jugador -> jugador.obtenerPuntaje() == puntajeMaximo)
            .collect(Collectors.toList());
    }

    public void usarExclusividad() {
        setChanged();
        try {
            this.rondaActual.usarExclusividad(this.rondaActual.obtenerJugadorActual());
        } catch (RuntimeException e) {
            this.mensaje = e.getMessage();
        }
    }
}
