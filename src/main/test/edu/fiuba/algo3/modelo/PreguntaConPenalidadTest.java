package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.ProxyConPenalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PreguntaConPenalidadTest {

    @Test
    public void obtenerTipoDevuelveUnStringIdentificandoMultipleChoiceConPenalidad() {
        MultipleChoice pregunta = new MultipleChoice("XXX", List.of(
                new OpcionDefault("", true)
        ));
        ProxyConPenalidad preguntaConPenalidad = new ProxyConPenalidad(pregunta);


        Assertions.assertEquals("MULTIPLE_CHOICE_CON_PENALIDAD", preguntaConPenalidad.obtenerTipo());
    }

    public void obtenerTextoDevuelveTextoConElQueSeCreo() {
        MultipleChoice pregunta = new MultipleChoice("XXX", List.of(
                new OpcionDefault("", true)
        ));
        ProxyConPenalidad preguntaConPenalidad = new ProxyConPenalidad(pregunta);

        Assertions.assertEquals("XXX", preguntaConPenalidad.obtenerTexto());
    }
}
