package co.edu.poligran.paradigmas.frontend.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/co/edu/poligran/paradigmas/frontend/views/menu.fxml"
                )
        );

        Scene scene = new Scene(loader.load(), 600, 400);

        scene.getStylesheets().add(
                getClass().getResource(
                        "/co/edu/poligran/paradigmas/frontend/css/style.css"
                ).toExternalForm()
        );

        stage.setTitle("Sistema Transporte");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch();

    }
}