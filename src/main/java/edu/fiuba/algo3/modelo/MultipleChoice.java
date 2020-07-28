package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoice implements IPregunta{
    private final ArrayList<Opcion> opciones;
    private final String texto;

    public MultipleChoice(String texto, ArrayList<Opcion> opciones) {
        this.texto = texto;
        this.opciones = opciones;
    }

    public ArrayList<Opcion> obtenerOpcionesCorrectas(){
        var opcionesCorrectas = new ArrayList<Opcion>();
        this.opciones.forEach(opcion ->{
            if(opcion.esCorrecta()) opcionesCorrectas.add(opcion);
        });
        return opcionesCorrectas;
    }

    public ArrayList<Resultado> obtenerResultados(ArrayList<IRespuesta> respuestas){
        new UnsupportedOperationException();
        return new ArrayList<Resultado>();
    }

    public Boolean respuestaEsCorrecta(IRespuesta respuesta){
        //Obtenemos lista de opciones correctas disponibles
        //Obtenemos lista de opciones elegidas
        //Verificamos que cada opcion elegida este en la lista de opciones correctas
        var opcionesCorrectas = this.obtenerOpcionesCorrectas();
        var opcionesElegidas = respuesta.obtenerOpcionesElegidas();
        var posicion = 0;
        var cantCorrectas = 0;
        var continuar = true;
        while (continuar && (opcionesElegidas.size() > posicion)){
            continuar = opcionesCorrectas.contains(opcionesElegidas.get(posicion));
            if (continuar){
                cantCorrectas++;
            }
            posicion ++;
        }
        return (cantCorrectas == opcionesCorrectas.size());
    }
}
