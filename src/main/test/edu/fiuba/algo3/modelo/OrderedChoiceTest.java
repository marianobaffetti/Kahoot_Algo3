package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrderedChoice;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.OrderedChoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

public class OrderedChoiceTest {

    @Test
    public void obtenerTipoDevuelveUnStringIdentificandoOrderedChoice() {
        OrderedChoice pregunta = new OrderedChoice("XXX", List.of(
                new OpcionOrderedChoice("", 1)
        ));

        Assertions.assertEquals("ORDERED_CHOICE", pregunta.obtenerTipo());
    }

    public void obtenerTextoDevuelveTextoConElQueSeCreo() {
        OrderedChoice pregunta = new OrderedChoice("XXX", List.of(
                new OpcionOrderedChoice("", 1)
        ));

        Assertions.assertEquals("XXX", pregunta.obtenerTexto());
    }
}
