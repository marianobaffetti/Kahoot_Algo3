package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionGroupChoice;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrderedChoice;
import edu.fiuba.algo3.modelo.Preguntas.GroupChoice;
import edu.fiuba.algo3.modelo.Preguntas.OrderedChoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupChoiceTest {

    @Test
    public void obtenerTipoDevuelveUnStringIdentificandoGroupChoice() {
        GroupChoice pregunta = new GroupChoice("XXX", List.of(
                new OpcionGroupChoice("", "")
        ));

        Assertions.assertEquals("GROUP_CHOICE", pregunta.obtenerTipo());
    }

    public void obtenerTextoDevuelveTextoConElQueSeCreo() {
        GroupChoice pregunta = new GroupChoice("XXX", List.of(
                new OpcionGroupChoice("", "")
        ));

        Assertions.assertEquals("XXX", pregunta.obtenerTexto());
    }
}
