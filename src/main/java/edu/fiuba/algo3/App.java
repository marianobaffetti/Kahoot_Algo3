package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.KahootControlador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.PreguntasBuilder;
import edu.fiuba.algo3.modelo.Ronda;
import edu.fiuba.algo3.vistas.KahootVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        var kahootControlador = new KahootControlador();
        var kahootVista = new KahootVista(kahootControlador);
        var kahootModelo = Kahoot.getInstance();
        kahootModelo.agregarJugadores(obtenerJugadores());
        kahootModelo.agregarPreguntas(obtenerPreguntas());
        kahootModelo.addObserver(kahootVista);

        var scene = new Scene(kahootVista, 640, 480);
        stage.setScene(scene);
        stage.setTitle(kahootVista.getTitle());
        stage.show();
    }

    private List<Pregunta> obtenerPreguntas() {
        var pregunta = new PreguntasBuilder().crearVerdaderOFalso(
                "Colón llegó a América en el siglo XV.",
                List.of(new OpcionDefault("Verdadero", true),
                        new OpcionDefault("Falso", false)
                )).get();
        return  List.of(pregunta);
    }

    private List<Jugador> obtenerJugadores() {
        return List.of(new Jugador("Pepe", new ArrayList<>()));
    }
}