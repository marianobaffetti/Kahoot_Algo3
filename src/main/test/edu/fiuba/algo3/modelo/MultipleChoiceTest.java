package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MultipleChoiceTest {

    @Test
    public void obtenerTipoDevuelveUnStringIdentificandoMultipleChoice() {
        MultipleChoice pregunta = new MultipleChoice("XXX", List.of(
                new OpcionDefault("", true)
        ));

        Assertions.assertEquals("MULTIPLE_CHOICE", pregunta.obtenerTipo());
    }

    public void obtenerTextoDevuelveTextoConElQueSeCreo() {
        MultipleChoice pregunta = new MultipleChoice("XXX", List.of(
                new OpcionDefault("", true)
        ));

        Assertions.assertEquals("XXX", pregunta.obtenerTexto());
    }
}
