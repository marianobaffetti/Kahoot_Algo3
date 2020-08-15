package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ReglasVista extends StackPane {
    public ReglasVista(Kahoot kahoot) {
        VBox vBox = new VBox();
        vBox.setSpacing(3);

        Label lblTitulo = new Label("A TENER EN CUENTA:");
        lblTitulo.setPadding(new Insets(0, 0, 10, 25));
        lblTitulo.setStyle("-fx-text-fill: white;" +
                    "-fx-font-weight: bold;" +
                    "-fx-font-size: 10pt;"
                );
        vBox.getChildren().add(lblTitulo);

        Label lblPreguntas = new Label("* Tipos te preguntas:");
        lblPreguntas.setStyle("-fx-text-fill: white;" +
                "-fx-font-weight: bold;"
        );
        lblPreguntas.setPadding(new Insets(0, 0, 0, 5));
        vBox.getChildren().add(lblPreguntas);

        vBox.getChildren().add(agregarTiposDePregunta());

        Label lblPreguntasEspeciales = new Label("* Preguntas especiales:");
        lblPreguntasEspeciales.setStyle("-fx-text-fill: white;" +
                "-fx-font-weight: bold;"
        );
        lblPreguntasEspeciales.setPadding(new Insets(5, 0, 0, 5));
        vBox.getChildren().add(lblPreguntasEspeciales);

        vBox.getChildren().add(agregarPreguntasEspeciales());

        Label lblBonificadores = new Label("* Bonificadores:");
        lblBonificadores.setStyle("-fx-text-fill: white;" +
                "-fx-font-weight: bold;"
        );
        lblBonificadores.setPadding(new Insets(5, 0, 0, 5));
        vBox.getChildren().add(lblBonificadores);

        vBox.getChildren().add(agregarBonificadores());

        vBox.setStyle("-fx-border-style: solid;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-color: white;"
        );
        vBox.setPadding(new Insets(10, 20, 10, 10));

        this.setPadding(new Insets(60, 0, 60, 60));
        this.getChildren().add(vBox);

    }

    private VBox agregarBonificadores() {
        Label lblMultiplicadorX2 = new Label("Multiplicador X2");
        lblMultiplicadorX2.setStyle("-fx-text-fill: white;");
        Label lblMultiplicadorX3 = new Label("Multiplicador X3");
        lblMultiplicadorX3.setStyle("-fx-text-fill: white;");
        Label lblExclusividad = new Label("Exclusividad de Puntaje");
        lblExclusividad.setStyle("-fx-text-fill: white;");
        VBox vBox3 = new VBox();
        vBox3.setSpacing(5);
        vBox3.getChildren().add(lblMultiplicadorX2);
        vBox3.getChildren().add(lblMultiplicadorX3);
        vBox3.getChildren().add(lblExclusividad);
        vBox3.setPadding(new Insets(0, 0, 0, 17));
        return vBox3;
    }

    private VBox agregarPreguntasEspeciales() {
        Label lblConPenalidad = new Label("Preguntas con Penalidad");
        lblConPenalidad.setStyle("-fx-text-fill: white;");
        Label lblConPP = new Label("Preguntas con Puntaje Parcial");
        lblConPP.setStyle("-fx-text-fill: white;");
        VBox vBox2 = new VBox();
        vBox2.setSpacing(5);
        vBox2.getChildren().add(lblConPenalidad);
        vBox2.getChildren().add(lblConPP);
        vBox2.setPadding(new Insets(0, 0, 0, 17));
        return vBox2;
    }

    private VBox agregarTiposDePregunta() {
        Label lblTipoPregunta = new Label("Verdadero o Falso");
        lblTipoPregunta.setStyle("-fx-text-fill: white;");
        Label lblTipoPregunta2 = new Label("Multiple Choice");
        lblTipoPregunta2.setStyle("-fx-text-fill: white;");
        Label lblTipoPregunta3 = new Label("Ordered Choice");
        lblTipoPregunta3.setStyle("-fx-text-fill: white;");
        Label lblTipoPregunta4 = new Label("Group Choice");
        lblTipoPregunta4.setStyle("-fx-text-fill: white;");
        VBox vBox1 = new VBox();
        vBox1.setSpacing(5);
        vBox1.getChildren().add(lblTipoPregunta);
        vBox1.getChildren().add(lblTipoPregunta2);
        vBox1.getChildren().add(lblTipoPregunta3);
        vBox1.getChildren().add(lblTipoPregunta4);
        vBox1.setPadding(new Insets(0, 0, 0, 17));
        return vBox1;
    }
}
