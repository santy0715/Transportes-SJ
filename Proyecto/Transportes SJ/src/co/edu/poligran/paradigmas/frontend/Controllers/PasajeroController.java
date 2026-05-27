package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.PasajeroManager;
import co.edu.poligran.paradigmas.backend.vo.PasajeroVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PasajeroController {

    private PasajeroManager manager = new PasajeroManager();

    private ObservableList<PasajeroVO> datos =
            FXCollections.observableArrayList();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDocumento;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TableView<PasajeroVO> tabla;

    @FXML
    private TableColumn<PasajeroVO, Integer> colId;

    @FXML
    private TableColumn<PasajeroVO, String> colNombre;

    @FXML
    private TableColumn<PasajeroVO, String> colDocumento;

    @FXML
    private TableColumn<PasajeroVO, String> colTelefono;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colDocumento.setCellValueFactory(
                new PropertyValueFactory<>("documento"));

        colTelefono.setCellValueFactory(
                new PropertyValueFactory<>("telefono"));

        tabla.setItems(datos);
        cargarTabla();
    }

    @FXML
    public void crear() {

        try {

            PasajeroVO p = new PasajeroVO(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    txtDocumento.getText(),
                    txtTelefono.getText()
            );

            manager.crear(p);

            cargarTabla();
            limpiar();
            mensaje("Pasajero creado");

        } catch (Exception e) {

            mensaje(e.getMessage());

        }

    }

    @FXML
    public void buscar() {

        try {

            PasajeroVO p =
                    manager.buscar(
                            Integer.parseInt(txtId.getText())
                    );

            if (p == null) {

                mensaje("No existe");
                return;

            }

            txtNombre.setText(p.getNombre());
            txtDocumento.setText(p.getDocumento());
            txtTelefono.setText(p.getTelefono());

        } catch (Exception e) {

            mensaje("Error al buscar");

        }

    }

    @FXML
    public void actualizar() {

        try {

            PasajeroVO p = new PasajeroVO(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    txtDocumento.getText(),
                    txtTelefono.getText()
            );

            manager.actualizar(p);

            cargarTabla();
            limpiar();
            mensaje("Pasajero actualizado");

        } catch (Exception e) {

            mensaje(e.getMessage());

        }

    }

    @FXML
    public void eliminar() {

        try {

            manager.eliminar(
                    Integer.parseInt(txtId.getText())
            );

            cargarTabla();
            limpiar();
            mensaje("Pasajero eliminado");

        } catch (Exception e) {

            mensaje(e.getMessage());

        }

    }

    private void cargarTabla() {

        datos.clear();
        datos.addAll(manager.listar());
        tabla.refresh();

    }

    private void limpiar() {

        txtId.clear();
        txtNombre.clear();
        txtDocumento.clear();
        txtTelefono.clear();

    }

    private void mensaje(String texto) {

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();

    }

}