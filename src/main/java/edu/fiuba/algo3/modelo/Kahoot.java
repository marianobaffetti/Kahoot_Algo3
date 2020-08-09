package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Kahoot extends Observable {
    private static Kahoot kahoot;
    private Ronda rondaActual;

    private Kahoot() {
    }

    public static Kahoot getInstance() {
        if (kahoot == null) kahoot = new Kahoot();
        return kahoot;
    }

    public boolean hayRonda() {
        return this.rondaActual !=  null;
    }

    public String obtenerTipoDePregunta() {
        return this.rondaActual.obtenerTipoDePregunta();
    }


    public void iniciar() {
        Jugador pepe = new Jugador("Pepe", new ArrayList<>());
        var pregunta = new PreguntasBuilder().crearVerdaderOFalso(
                "Colón llegó a América en el siglo XV.",
                List.of(new OpcionDefault("Verdadero", true),
                        new OpcionDefault("Falso", false)
                )
        ).get();

        Ronda ronda = new Ronda(pregunta, List.of(pepe));
        this.rondaActual = ronda;

        setChanged();
    }

    public String obtenerTextoDePregunta() {
        return this.rondaActual.obtenerPregunta().obtenerTexto();
    }

    public List<Opcion> obtenerOpciones() {
        return this.rondaActual.obtenerPregunta().obtenerOpciones();
    }
}
