package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.*;

import java.util.List;

public class PreguntasBuilder {
    private Pregunta preguntaActual;

    public PreguntasBuilder crearVerdaderOFalso(String texto, List<Opcion> opciones) {
        this.preguntaActual = new VerdaderoFalso(texto, opciones);
        return this;
    }

    public Pregunta get() {
        return this.preguntaActual;
    }

    public PreguntasBuilder conPenalidad() {
        this.preguntaActual = new ProxyConPenalidad(this.preguntaActual);
        return this;
    }

    public PreguntasBuilder crearMultipleChoice(String texto, List<Opcion> opciones) {
        this.preguntaActual = new MultipleChoice(texto, opciones);
        return this;
    }

    public PreguntasBuilder conPuntajeParcial() {
        this.preguntaActual = new ProxyConPuntajeParcial(this.preguntaActual);
        return this;
    }

    public PreguntasBuilder crearOrderedChoice(String texto, List<Opcion> opciones) {
        this.preguntaActual = new OrderedChoice(texto, opciones);
        return this;
    }

    public PreguntasBuilder crearGroupChoice(String texto, List<Opcion> opciones) {
        this.preguntaActual = new GroupChoice(texto, opciones);
        return this;
    }
}
