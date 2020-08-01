package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class ProxyConPuntajeParcial implements IPregunta {
    private final IPregunta pregunta;

    public ProxyConPuntajeParcial(IPregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Boolean respuestaEsCorrecta(IRespuesta respuesta) {
        return this.pregunta.respuestaEsCorrecta(respuesta);
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        return this.pregunta.obtenerOpcionesCorrectas();
    }

    public List<Resultado> obtenerResultados(List<IRespuesta> respuestas) {
        return respuestas
                .stream()
                .map(respuesta -> this.obtenerResultado(respuesta))
                .collect(Collectors.toList());
    }

    private Resultado obtenerResultado(IRespuesta respuesta) {
        var correctas = this.obtenerOpcionesCorrectas();
        var elegidas = respuesta.obtenerOpcionesElegidas();

        if (!elegidas.stream().allMatch(opcion1 -> correctas.contains(opcion1)))
            return new Resultado(0, respuesta.obtenerJugador());

        return new Resultado(elegidas.stream().filter(opcion -> correctas.contains(opcion)).count(), respuesta.obtenerJugador());
    }
}
