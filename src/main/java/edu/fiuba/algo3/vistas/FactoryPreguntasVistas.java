package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.layout.Pane;

public class FactoryPreguntasVistas {
    public Pane crear(String tipoPregunta, Kahoot kahoot) {
        Pane vista = null;

        switch (tipoPregunta) {
            case "VERDADERO_O_FALSO":
                vista = new VerdaderoFalsoVista(kahoot);
                break;
            case "MULTIPLE_CHOICE":
                /* vista =  new MultipleChoiceVista(kahoot);*/
                break;
            case "ORDERED_CHOICE":
                /* vista = new OrderedChoiceVista(kahoot);*/
                break;
            case "GROUP_CHOICE":
                /* vista = new GroupChoiceVista(kahoot);*/
                break;
            case "VERDADERO_O_FALSO_CON_PENALIDAD":
                /* vista = new VerdaderoOFalsoConPenalidad(kahoot);*/
                break;
        }
        return vista;
    }
}
