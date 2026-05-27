package co.edu.poligran.paradigmas.frontend.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;

public class MenuController {

    @FXML
    private StackPane contenedor;

    @FXML
    public void abrirVehiculos() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/vehiculo.fxml");
    }

    @FXML
    public void abrirPasajeros() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/pasajero.fxml");
    }

    @FXML
    public void abrirHorarios() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/horario.fxml");
    }

    @FXML
    public void abrirRutas() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/ruta.fxml");
    }

    @FXML
    public void abrirBoletos() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/boleto.fxml");
    }

    @FXML
    public void abrirParadas() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/parada.fxml");
    }

    @FXML
    public void abrirAsientos() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/asiento.fxml");
    }

    @FXML
    public void abrirPersonas() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/persona.fxml");
    }

    @FXML
    public void abrirEmpleados() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/empleado.fxml");
    }

    @FXML
    public void abrirConductores() {
        cargarVista("/co/edu/poligran/paradigmas/frontend/Views/conductor.fxml");
    }

    private void cargarVista(String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            contenedor.getChildren().clear();
            contenedor.getChildren().add(loader.load());
        } catch (Exception e) {
            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error al cargar vista");
            alert.setContentText("No se pudo abrir: " + ruta);
            alert.showAndWait();
        }
    }
}