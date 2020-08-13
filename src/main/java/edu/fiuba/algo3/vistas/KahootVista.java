package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.KahootControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.Observable;
import java.util.Observer;

public class KahootVista extends StackPane implements Observer {
    private final FactoryPreguntasVistas factory;
    private final KahootControlador controlador;

    public KahootVista(KahootControlador controlador) {
        super();
        this.factory = new FactoryPreguntasVistas();
        this.controlador = controlador;
        iniciar();
    }

    private void iniciar() {
        mostrar(new InicioVista(this.controlador));
    }

    private void mostrar(Pane vista) {
        this.getChildren().clear();
        this.getChildren().add(vista);
    }

    @Override
    public void update(Observable modelo, Object o) {
        var kahoot = (Kahoot) modelo;
        var etapa = kahoot.obtenerEtapa();

        switch (etapa) {
            case "CREAR_JUGADORES":
                mostrar(new CrearJugadoresVista(kahoot));
                break;
            case "MOSTRAR_PREGUNTA":
                mostrar(factory.crear(kahoot.obtenerTipoDePregunta(), kahoot));
                break;
            case "MOSTRAR_PUNTAJES":
                mostrar(new PuntajesFinalesVista(kahoot));
                break;
        }
    }

    public String getTitle() {
        return "Kahoot";
    }
}
