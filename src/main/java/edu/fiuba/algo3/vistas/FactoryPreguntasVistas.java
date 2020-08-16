package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.layout.Pane;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class FactoryPreguntasVistas {
    private final Map<String, Class<?>> vistas;

    FactoryPreguntasVistas() {
        this.vistas = Map.of(
                "VERDADERO_O_FALSO", VerdaderoFalsoVista.class,
                "MULTIPLE_CHOICE", MultipleChoiceVista.class
        );
    }

    public Pane crear(String tipoPregunta, Kahoot kahoot) {
        Class<?> clase = this.vistas.get(tipoPregunta);
        Pane vista = null;

        try {
            vista = (Pane) clase.getDeclaredConstructor(Kahoot.class).newInstance(kahoot);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return vista;
    }
}
