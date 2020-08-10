package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.KahootControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.VerdaderoFalso;
import javafx.scene.layout.Pane;

public class FactoryPreguntasVistas {
    public Pane crear(String tipoPregunta, KahootControlador controlador, Kahoot kahoot) {
        Pane vista = null;

        switch (tipoPregunta) {
            case "VERDADERO_O_FALSO":
                vista = new VerdaderoFalsoVista(controlador, kahoot);
                break;
            case "MULTIPLE_CHOICE":
                /* vista =  new MultipleChoiceVista(controlador, kahoot);*/
                break;
            case "ORDERED_CHOICE":
                /* vista = new OrderedChoiceVista(controlador, kahoot);*/
                break;
            case "GROUP_CHOICE":
                /* vista = new GroupChoiceVista(controlador, kahoot);*/
                break;
        }
        return vista;
    }
}
