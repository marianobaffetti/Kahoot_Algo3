package edu.fiuba.algo3.modelo.Opciones;

public class OpcionDefault extends Opcion {
    private final Boolean esVerdadera;

    public OpcionDefault(String texto, Boolean esVerdadera) {
        super(texto);
        this.esVerdadera = esVerdadera;
    }

    public Boolean esCorrecta() {
        return esVerdadera;
    }

    public Boolean coincideCon(Opcion opcion) {
        return opcion.coincideCon(this.texto, this.esVerdadera);
    }

    public <T> Boolean coincideCon(String texto, T condicion) {
        return this.texto == texto && condicion.equals(this.esVerdadera);
    }
}