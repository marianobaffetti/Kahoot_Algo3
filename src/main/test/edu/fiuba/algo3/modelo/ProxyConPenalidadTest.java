package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.ProxyConPenalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProxyConPenalidadTest {

    @Test
    public void obtenerTipoDevuelveUnStringIdentificandoMultipleChoiceConPenalidad() {
        MultipleChoice pregunta = new MultipleChoice("XXX", List.of(
                new OpcionDefault("", true)
        ));
        ProxyConPenalidad proxyConPenalidad = new ProxyConPenalidad(pregunta);

        Assertions.assertEquals("MULTIPLE_CHOICE_CON_PENALIDAD", proxyConPenalidad.obtenerTipo());
    }

    public void obtenerTextoDevuelveTextoConElQueSeCreo() {
        MultipleChoice pregunta = new MultipleChoice("XXX", List.of(
                new OpcionDefault("", true)
        ));
        ProxyConPenalidad proxyConPenalidad = new ProxyConPenalidad(pregunta);

        Assertions.assertEquals("XXX", proxyConPenalidad.obtenerTexto());
    }
}
