package edu.fiuba.algo3;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
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
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/preguntas.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        JsonReader jsonReader = new JsonReader(reader);
        var json = new Gson().fromJson(jsonReader, JsonObject.class);
        var preguntasJson = ((JsonObject) json).get("preguntas");
        var builder = new PreguntasBuilder();

        var preguntas = new ArrayList<Pregunta>();
        ((JsonArray) preguntasJson).forEach(preguntaJson -> {
            var tipo = ((JsonObject) preguntaJson).get("tipo").getAsString();

            if (tipo.equals("VERDADERO_O_FALSO")) {
                var opciones = new ArrayList<Opcion>();
                var opcionesJson = ((JsonObject) preguntaJson).get("opciones");
                ((JsonArray) opcionesJson).forEach(opcionJson -> {
                    opciones.add(new OpcionDefault(
                            ((JsonObject) opcionJson).get("texto").getAsString(),
                            ((JsonObject) opcionJson).get("correcta").getAsBoolean()
                    ));
                });
                var texto = ((JsonObject) preguntaJson).get("texto").getAsString();
                preguntas.add(builder.crearVerdaderOFalso(texto, opciones).get());
            }
        });

        return preguntas;
    }
}