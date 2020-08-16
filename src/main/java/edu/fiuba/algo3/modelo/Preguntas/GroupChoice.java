package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionGroupChoice;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Resultado;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroupChoice extends Pregunta {
    private final OrderedChoice orderderdChoice;

    public GroupChoice(String texto, List<Opcion> opciones) {
        super(texto);
        this.opciones = opciones;
        this.orderderdChoice = new OrderedChoice(texto, opciones);
    }

    protected Resultado obtenerResultado(Respuesta respuesta) {
        return this.orderderdChoice.obtenerResultado(respuesta);
    }

    public Boolean respuestaEsCorrecta(Respuesta respuesta) {
        throw new UnsupportedOperationException();
    }

    public List<Opcion> obtenerOpcionesCorrectas() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String obtenerTipo() {
        return "GROUP_CHOICE";
    }

    public List<String> obtenerGrupos() {
        return this.opciones.stream()
                .map( opcion -> ((OpcionGroupChoice) opcion) .obtenerGrupo())
                .distinct()
                .collect(Collectors.toList());
    }
}
