package edu.fiuba.algo3.modelo;

public class OpcionOrderedChoice implements Opcion {
    private final String texto;
    private final int orden;

    public OpcionOrderedChoice(String texto, int orden) {
        this.texto = texto;
        this.orden = orden;
    }

    public Boolean esCorrecta() {
        return true;
    }

    @Override
    public Boolean coincideCon(String texto, int orden) {
        return this.texto == texto && this.orden == orden;
    }

    public Boolean coincideConAlgunaDe(Respuesta respuesta) {
        return  respuesta.obtenerOpcionesElegidas()
                .stream()
                .anyMatch(opcionElegida -> opcionElegida.coincideCon(this.texto, this.orden));
    }
}