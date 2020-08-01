package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoice implements IPregunta {
    private final List<Opcion> opciones;
    private final String texto;

    public MultipleChoice(String texto, List<Opcion> opciones) {
        this.texto = texto;
        this.opciones = opciones;
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        var opcionesCorrectas = new ArrayList<Opcion>();
        this.opciones.forEach(opcion -> {
            if (opcion.esCorrecta()) opcionesCorrectas.add(opcion);
        });
        return opcionesCorrectas;
    }

    public List<Resultado> obtenerResultados(List<IRespuesta> respuestas) {
        var resultados = new ArrayList<Resultado>();
        respuestas.forEach(respuesta -> resultados.add(this.obtenerResultado(respuesta)));
        return resultados;
    }

    private Resultado obtenerResultado(IRespuesta respuesta) {
        var opcionesCorrectas = this.obtenerOpcionesCorrectas();
        var opcionesElegidas = respuesta.obtenerOpcionesElegidas();
        var posicion = 0;
        var puntaje = 1;
        var continuar = true;
        if (opcionesCorrectas.size() == opcionesElegidas.size()) {
            while (continuar && (opcionesElegidas.size() > posicion)) {
                continuar = opcionesCorrectas.contains(opcionesElegidas.get(posicion));
                if (!continuar) {
                    puntaje = 0;
                }
                posicion++;
            }
        } else {
            puntaje = 0;
        }
        return new Resultado(puntaje, respuesta.obtenerJugador());
    }

    public Boolean respuestaEsCorrecta(IRespuesta respuesta) {
        //Obtenemos lista de opciones correctas disponibles
        //Obtenemos lista de opciones elegidas
        //Verificamos que cada opcion elegida este en la lista de opciones correctas
        var opcionesCorrectas = this.obtenerOpcionesCorrectas();
        var opcionesElegidas = respuesta.obtenerOpcionesElegidas();
        var posicion = 0;
        var cantCorrectas = 0;
        var continuar = true;
        while (continuar && (opcionesElegidas.size() > posicion)) {
            continuar = opcionesCorrectas.contains(opcionesElegidas.get(posicion));
            if (continuar) {
                cantCorrectas++;
            }
            posicion++;
        }
        return (cantCorrectas == opcionesCorrectas.size());
    }
}
