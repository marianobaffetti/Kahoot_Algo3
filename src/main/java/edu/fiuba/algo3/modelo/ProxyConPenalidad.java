package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class ProxyConPenalidad implements IPregunta {
    private final IPregunta pregunta;

    public ProxyConPenalidad(IPregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Boolean respuestaEsCorrecta(IRespuesta respuesta) {
        return this.pregunta.respuestaEsCorrecta(respuesta);
    }

    public List<Resultado> obtenerResultados(List<IRespuesta> respuestas) {
        return respuestas
                .stream()
                .map(respuesta -> this.obtenerResultado(respuesta))
                .collect(Collectors.toList());
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.pregunta.obtenerOpcionesCorrectas();
    }

    private Resultado obtenerResultado(IRespuesta respuesta) {
        var correctas = this.obtenerOpcionesCorrectas();
        var elegidas = respuesta.obtenerOpcionesElegidas();
        var aciertos = elegidas.stream().filter(opcion -> correctas.contains(opcion)).count();
        var puntos = aciertos - (elegidas.size() - aciertos);

        return new Resultado(puntos, respuesta.obtenerJugador());
    }
}
