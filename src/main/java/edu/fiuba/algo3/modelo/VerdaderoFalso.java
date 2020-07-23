package edu.fiuba.algo3.modelo;

public class VerdaderoFalso {
    private final boolean respuestaCorrecta;

    public VerdaderoFalso(String pregunta, boolean respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public Resultado obtenerResultado(boolean respuestaCorrecta) {
        return new Resultado(this.respuestaCorrecta);
    }
}
