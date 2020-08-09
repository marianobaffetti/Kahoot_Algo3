package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VerdaderoFalsoTest {

    @Test
    public void obtenerTipoDevuelveUnStringIdentificandoVerdaderoFalso() {
        VerdaderoFalso pregunta = new VerdaderoFalso("XXX", List.of(
                new OpcionDefault("", true)
        ));

        Assertions.assertEquals("VERDADERO_O_FALSO", pregunta.obtenerTipo());
    }

    public void obtenerTextoDevuelveTextoConElQueSeCreo() {
        VerdaderoFalso pregunta = new VerdaderoFalso("XXX", List.of(
                new OpcionDefault("", true)
        ));

        Assertions.assertEquals("XXX", pregunta.obtenerTexto());
    }
}
