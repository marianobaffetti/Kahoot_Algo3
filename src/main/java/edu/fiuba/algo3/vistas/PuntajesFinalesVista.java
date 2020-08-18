package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PuntajesFinalesVista extends BorderPane {
    public PuntajesFinalesVista(Kahoot kahoot) {
        VBox vBox = new VBox();

        kahoot.obtenerJugadores().forEach((jugador) -> {
            String puntaje = String.valueOf(jugador.obtenerPuntaje()).substring(0, String.valueOf(jugador.obtenerPuntaje()).indexOf("."));
            Label lblResultado = new Label(jugador.obtenerNombre() + ": " + puntaje);
            lblResultado.setStyle("-fx-text-fill: white;" +
                "-fx-font-size: 30;" +
                "-fx-font-weight: bold;"
            );
            String url;
            String mensajeGanadorPerdedor;
            if (kahoot.obtenerGanadores().contains(jugador)) {
                url = "https://kahoot.com/files/2019/11/Ambassadors-GoldCertified.png";
                mensajeGanadorPerdedor = " (GANADOR)";
            } else {
                url = "https://kahoot.com/files/2019/08/Kahoot-Certified-Silver-course-certification.png";
                mensajeGanadorPerdedor = " (PERDEDOR)";
            }
            lblResultado.setText(lblResultado.getText() + mensajeGanadorPerdedor);
            lblResultado.setWrapText(true);
            Image image = new Image(url, 200, 200, true, true);
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setY(-150);
            HBox hBox = new HBox();
            hBox.getChildren().add(imageView);
            hBox.getChildren().add(lblResultado);
            hBox.setMaxWidth(400);

            vBox.getChildren().add(hBox);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
        });


        var urlGif = "https://static.wixstatic.com/media/e4c670_90adda2b7fb44ed897e6bd60abba312b~mv2.gif";
        Image image = new Image(urlGif, 120, 120, false, true);
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setStyle("-fx-background-radius: 90;");
        imageView.setY(-100);
        this.setLeft(imageView);
        var urlGif2 = "https://static.wixstatic.com/media/e4c670_4239ac19130241e890b4747df79a0b3f~mv2.gif";
        Image image2 = new Image(urlGif2, 120, 120, false, true);
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        imageView2.setStyle("-fx-background-radius: 90;");
        imageView2.setY(-100);
        this.setRight(imageView2);

        this.setStyle("-fx-background-color: #9E31F2");
        this.setCenter(vBox);
    }
}
