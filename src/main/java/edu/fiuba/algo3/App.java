package edu.fiuba.algo3;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.Utils.PreguntasJsonParser;
import edu.fiuba.algo3.controladores.KahootControlador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.PreguntasBuilder;
import edu.fiuba.algo3.vistas.KahootVista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
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

        try {
            kahootModelo.agregarPreguntas(obtenerPreguntas());
        } catch (IOException e) {
            e.printStackTrace();
        }
        kahootModelo.addObserver(kahootVista);

        var scene = new Scene(kahootVista, 640, 480);
        stage.setScene(scene);
        stage.setTitle(kahootVista.getTitle());
        stage.show();
    }

    private List<Pregunta> obtenerPreguntas() throws IOException {
        var fileInputStream = new FileInputStream("src/main/resources/preguntas.json");
        var parser = new PreguntasJsonParser(new InputStreamReader(fileInputStream));
        return parser.invoke();
    }
}