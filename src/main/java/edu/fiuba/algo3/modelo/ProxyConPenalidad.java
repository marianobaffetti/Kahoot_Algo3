package edu.fiuba.algo3.modelo;

import java.util.ArrayList;


public class ProxyConPenalidad implements IPregunta{
    private VerdaderoFalso pregunta;

    public ProxyConPenalidad(VerdaderoFalso pregunta) {
        this.pregunta = pregunta;
    }

    public Boolean respuestaEsCorrecta(IRespuesta respuesta){
        return this.pregunta.respuestaEsCorrecta(respuesta);
    }

    public ArrayList<Resultado> obtenerResultados(ArrayList<IRespuesta> respuestas) {
        var resultados = new ArrayList<Resultado>();
        respuestas.forEach(respuesta -> resultados.add(this.obtenerResultado(respuesta)));
        return resultados;
    }

    public ArrayList<Opcion> obtenerOpcionesCorrectas() {
        return this.pregunta.obtenerOpcionesCorrectas();
    }

    private Resultado obtenerResultado(IRespuesta respuesta){

        var opcionesCorrectas = this.pregunta.obtenerOpcionesCorrectas();
        var opcionesElegidas = respuesta.obtenerOpcionesElegidas();
        var posicion = 0;
        var puntaje = 0;
        var continuar = true;
        while (opcionesElegidas.size() > posicion) {
            continuar = opcionesCorrectas.contains(opcionesElegidas.get(posicion));
            if (continuar) {
                puntaje++;
            }
            else{
                puntaje--;
            }
            posicion++;
        }
        return new Resultado(puntaje,respuesta.obtenerJugador());
    }

}
