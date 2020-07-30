package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class PreguntasBuilder {
    private IPregunta preguntaActual;

    public PreguntasBuilder crearVerdaderOFalso(String texto, ArrayList<Opcion> opciones) {
        this.preguntaActual = new VerdaderoFalso("Colón llegó a América en el siglo XV.", opciones);
        return this;
    }

    public IPregunta get() {
        return this.preguntaActual;
    }

    public PreguntasBuilder conPenalidad() {
        this.preguntaActual = new ProxyConPenalidad(this.preguntaActual);
        return this;
    }

    public PreguntasBuilder crearMultipleChoice(String texto, ArrayList<Opcion> opciones) {
        this.preguntaActual = new MultipleChoice("Colón llegó a América en el siglo XV.", opciones);
        return this;
    }

    public PreguntasBuilder conPuntajeParcial() {
        this.preguntaActual = new ProxyConPuntajeParcial(this.preguntaActual);
        return this;
    }
}
