package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ReglasVista extends StackPane {
    public ReglasVista(Kahoot kahoot) {
        VBox vBox = new VBox();
        vBox.setSpacing(5);

        Label lblTitulo = new Label("A TENER EN CUENTA:");
        lblTitulo.setStyle("-fx-text-fill: white;");
        HBox hBox1 = new HBox();
        hBox1.getChildren().add(lblTitulo);
        hBox1.setPadding(new Insets(0, 0, 0, 80));
        vBox.getChildren().add(hBox1);

        this.setStyle("-fx-border-style: solid;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-color: white;"
        );
        
        this.setPadding(new Insets(15, 0, 0, 0));
        this.getChildren().add(vBox);

    }
}
