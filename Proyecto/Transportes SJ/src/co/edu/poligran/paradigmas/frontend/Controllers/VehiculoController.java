package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.VehiculoManager;
import co.edu.poligran.paradigmas.backend.vo.VehiculoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehiculoController {

    private VehiculoManager manager = new VehiculoManager();

    private ObservableList<VehiculoVO> datos = FXCollections.observableArrayList();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtCapacidad;

    @FXML
    private TableView<VehiculoVO> tablaVehiculos;

    @FXML
    private TableColumn<VehiculoVO, Integer> colId;

    @FXML
    private TableColumn<VehiculoVO, String> colPlaca;

    @FXML
    private TableColumn<VehiculoVO, String> colModelo;

    @FXML
    private TableColumn<VehiculoVO, Integer> colCapacidad;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colCapacidad.setCellValueFactory(new PropertyValueFactory<>("capacidad"));

        tablaVehiculos.setItems(datos);
        mostrarTabla();
    }

    @FXML
    public void crearVehiculo() {
        try {
            int id = Integer.parseInt(txtId.getText());
            int capacidad = Integer.parseInt(txtCapacidad.getText());

            VehiculoVO v = new VehiculoVO(
                    id,
                    capacidad,
                    txtPlaca.getText(),
                    txtModelo.getText()
            );

            manager.crear(v);
            mostrarTabla();
            limpiar();
            mensaje("Vehículo creado correctamente");

        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }

    private void mostrarTabla() {
        datos.clear();
        datos.addAll(manager.listar());
        tablaVehiculos.refresh();
    }

    private void limpiar() {
        txtId.clear();
        txtPlaca.clear();
        txtModelo.clear();
        txtCapacidad.clear();
    }

    private void mensaje(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }

    @FXML
    public void buscarVehiculo() {
        try {
            int id = Integer.parseInt(txtId.getText());
            VehiculoVO v = manager.buscar(id);

            if (v == null) {
                mensaje("Vehículo no encontrado");
                return;
            }

            txtPlaca.setText(v.getPlaca());
            txtModelo.setText(v.getModelo());
            txtCapacidad.setText(String.valueOf(v.getCapacidad()));

        } catch (Exception e) {
            mensaje("Error al buscar");
        }
    }

    @FXML
    public void actualizarVehiculo() {
        try {
            int id = Integer.parseInt(txtId.getText());
            int capacidad = Integer.parseInt(txtCapacidad.getText());

            VehiculoVO v = new VehiculoVO(
                    id,
                    capacidad,
                    txtPlaca.getText(),
                    txtModelo.getText()
            );

            manager.actualizar(v);
            mostrarTabla();
            limpiar();
            mensaje("Vehículo actualizado");

        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }

    @FXML
    public void eliminarVehiculo() {
        try {
            int id = Integer.parseInt(txtId.getText());

            manager.eliminar(id);
            mostrarTabla();
            limpiar();
            mensaje("Vehículo eliminado");

        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }
}