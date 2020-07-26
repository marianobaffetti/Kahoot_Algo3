package edu.fiuba.algo3.modelo;

public class ProxyConPenalidad {
    private VerdaderoFalso pregunta;

    public ProxyConPenalidad(VerdaderoFalso pregunta) {
        this.pregunta = pregunta;
    }

    public Boolean respuestaEsCorrecta(RespuestaVerdaderoFalso respuesta){
        return this.pregunta.respuestaEsCorrecta(respuesta);
    }
}
