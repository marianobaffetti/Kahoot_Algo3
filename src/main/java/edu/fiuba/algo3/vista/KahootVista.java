package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.KahootControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.Observable;
import java.util.Observer;

public class KahootVista extends StackPane implements Observer {
    private final FactoryPreguntasVistas factory;
    private KahootControlador controlador;

    public KahootVista(KahootControlador controlador) {
        super();
        this.factory = new FactoryPreguntasVistas();
        iniciar(controlador);
    }

    private void iniciar(KahootControlador controlador) {
        this.controlador = controlador;
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
        var tipoPregunta = kahoot.obtenerTipoDePregunta();

        switch (etapa){
            case "CREAR_JUGADORES":
                //mostrar(new CrearJugadoresVista(this.controlador, kahoot))
                break;
            case "MOSTRAR_PREGUNTA":
                mostrar(factory.crear(tipoPregunta, this.controlador, kahoot));
                break;
            case "MOSTRAR_PUNTAJES":
                //mostrar(new MostrarPuntajesVista(this.controlador, kahoot))
                break;
        }
    }

    public String getTitle() {
        return "Kahoot";
    }
}
