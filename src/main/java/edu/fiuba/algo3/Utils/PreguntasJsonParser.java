package edu.fiuba.algo3.Utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionDefault;
import edu.fiuba.algo3.modelo.Opciones.OpcionGroupChoice;
import edu.fiuba.algo3.modelo.Opciones.OpcionOrderedChoice;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.PreguntasBuilder;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PreguntasJsonParser {
    private final InputStreamReader reader;

    public PreguntasJsonParser(InputStreamReader reader) {
        this.reader = reader;
    }

    public List<Pregunta> invoke() {
        var jsonReader = new JsonReader(reader);
        var json = new Gson().fromJson(jsonReader, JsonObject.class);
        var preguntasJson = ((JsonObject) json).get("preguntas");
        var builder = new PreguntasBuilder();

        var preguntas = new ArrayList<Pregunta>();
        ((JsonArray) preguntasJson).forEach(preguntaJson -> {
            var tipo = ((JsonObject) preguntaJson).get("tipo").getAsString();

            if (tipo.equals("VERDADERO_O_FALSO") || tipo.equals("MULTIPLE_CHOICE")) {
                var opciones = new ArrayList<Opcion>();
                var opcionesJson = ((JsonObject) preguntaJson).get("opciones");
                ((JsonArray) opcionesJson).forEach(opcionJson -> {
                    opciones.add(new OpcionDefault(
                            ((JsonObject) opcionJson).get("texto").getAsString(),
                            ((JsonObject) opcionJson).get("correcta").getAsBoolean()
                    ));
                });
                var texto = ((JsonObject) preguntaJson).get("texto").getAsString();

                if (tipo.equals("VERDADERO_O_FALSO"))
                    builder.crearVerdaderOFalso(texto, opciones);
                else {
                    builder.crearMultipleChoice(texto, opciones);
                    var puntajeParcial = ((JsonObject) preguntaJson).get("puntajeParcial").getAsBoolean();
                    if (puntajeParcial) {
                        builder.conPuntajeParcial();
                    }
                }
                var penalidad = ((JsonObject) preguntaJson).get("penalidad").getAsBoolean();
                if (penalidad) builder.conPenalidad();

                preguntas.add(builder.get());

            } else if (tipo.equals("GROUP_CHOICE")) {
                var opciones = new ArrayList<Opcion>();
                var opcionesJson = ((JsonObject) preguntaJson).get("opciones");
                ((JsonArray) opcionesJson).forEach(opcionJson -> {
                    opciones.add(new OpcionGroupChoice(
                            ((JsonObject) opcionJson).get("texto").getAsString(),
                            ((JsonObject) opcionJson).get("grupo").getAsString()
                    ));
                });
                var texto = ((JsonObject) preguntaJson).get("texto").getAsString();
                preguntas.add(builder.crearGroupChoice(texto, opciones).get());
            } else if (tipo.equals("ORDERED_CHOICE")) {
                var opciones = new ArrayList<Opcion>();
                var opcionesJson = ((JsonObject) preguntaJson).get("opciones");
                ((JsonArray) opcionesJson).forEach(opcionJson -> {
                    opciones.add(new OpcionOrderedChoice(
                            ((JsonObject) opcionJson).get("texto").getAsString(),
                            ((JsonObject) opcionJson).get("orden").getAsInt()
                    ));
                });
                var texto = ((JsonObject) preguntaJson).get("texto").getAsString();
                preguntas.add(builder.crearOrderedChoice(texto, opciones).get());
            }
        });

        return preguntas;
    }
}
