package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class ProxyConPenalidad implements IPregunta {
    private IPregunta pregunta;

    public ProxyConPenalidad(IPregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Boolean respuestaEsCorrecta(IRespuesta respuesta) {
        return this.pregunta.respuestaEsCorrecta(respuesta);
    }

    public List<Resultado> obtenerResultados(List<IRespuesta> respuestas) {
        var resultados = new ArrayList<Resultado>();
        respuestas.forEach(respuesta -> resultados.add(this.obtenerResultado(respuesta)));
        return resultados;
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.pregunta.obtenerOpcionesCorrectas();
    }

    private Resultado obtenerResultado(IRespuesta respuesta) {

        var opcionesCorrectas = this.pregunta.obtenerOpcionesCorrectas();
        var opcionesElegidas = respuesta.obtenerOpcionesElegidas();
        var posicion = 0;
        var puntaje = 0;
        var continuar = true;
        while (opcionesElegidas.size() > posicion) {
            continuar = opcionesCorrectas.contains(opcionesElegidas.get(posicion));
            if (continuar) {
                puntaje++;
            } else {
                puntaje--;
            }
            posicion++;
        }
        return new Resultado(puntaje, respuesta.obtenerJugador());
    }
}
