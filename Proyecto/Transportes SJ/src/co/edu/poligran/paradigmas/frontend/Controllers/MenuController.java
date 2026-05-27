package co.edu.poligran.paradigmas.frontend.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;

public class MenuController {

    @FXML
    private StackPane contenedor;

    @FXML
    public void abrirVehiculos() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/co/edu/poligran/paradigmas/frontend/views/vehiculo.fxml"
                    )
            );

            contenedor.getChildren().clear();

            contenedor.getChildren().add(loader.load());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    @FXML
    public void abrirPasajeros() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/co/edu/poligran/paradigmas/frontend/views/pasajero.fxml"
                    )
            );

            contenedor.getChildren().clear();

            contenedor.getChildren().add(loader.load());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    @FXML
    public void abrirHorarios() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/co/edu/poligran/paradigmas/frontend/views/horario.fxml"
                    )
            );

            contenedor.getChildren().clear();

            contenedor.getChildren().add(loader.load());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    @FXML
    public void abrirRutas() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/co/edu/poligran/paradigmas/frontend/views/ruta.fxml"
                    )
            );

            contenedor.getChildren().clear();

            contenedor.getChildren().add(loader.load());

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}