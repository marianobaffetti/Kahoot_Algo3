package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.MultipleChoice;
import edu.fiuba.algo3.modelo.Preguntas.ProxyConPenalidad;
import edu.fiuba.algo3.modelo.Preguntas.ProxyConPuntajeParcial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PreguntaConPuntajeParcialTest {

    @Test
    public void obtenerTipoDevuelveUnStringIdentificandoMultipleChoiceConPuntajeParcial() {
        MultipleChoice pregunta = new MultipleChoice("XXX", List.of(
                new OpcionDefault("", true)
        ));
        ProxyConPuntajeParcial preguntaConPuntajeParcial = new ProxyConPuntajeParcial(pregunta);


        Assertions.assertEquals("MULTIPLE_CHOICE_CON_PUNTAJE_PARCIAL", preguntaConPuntajeParcial.obtenerTipo());
    }

    public void obtenerTextoDevuelveTextoConElQueSeCreo() {
        MultipleChoice pregunta = new MultipleChoice("XXX", List.of(
                new OpcionDefault("", true)
        ));
        ProxyConPuntajeParcial preguntaConPuntajeParcial = new ProxyConPuntajeParcial(pregunta);

        Assertions.assertEquals("XXX", preguntaConPuntajeParcial.obtenerTexto());
    }
}
