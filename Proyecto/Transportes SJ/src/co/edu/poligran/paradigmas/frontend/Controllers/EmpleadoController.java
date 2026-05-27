package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.EmpleadoManager;
import co.edu.poligran.paradigmas.backend.vo.EmpleadoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmpleadoController {

    private EmpleadoManager manager = new EmpleadoManager();

    private ObservableList<EmpleadoVO> datos =
            FXCollections.observableArrayList();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtSalario;

    @FXML
    private TextField txtCargo;

    @FXML
    private TableView<EmpleadoVO> tabla;

    @FXML
    private TableColumn<EmpleadoVO, Integer> colId;

    @FXML
    private TableColumn<EmpleadoVO, String> colNombre;

    @FXML
    private TableColumn<EmpleadoVO, Double> colSalario;

    @FXML
    private TableColumn<EmpleadoVO, String> colCargo;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colSalario.setCellValueFactory(
                new PropertyValueFactory<>("salario"));

        colCargo.setCellValueFactory(
                new PropertyValueFactory<>("cargo"));

        tabla.setItems(datos);
        cargarTabla();
    }

    @FXML
    public void crear() {
        try {

            EmpleadoVO e = new EmpleadoVO(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    Double.parseDouble(txtSalario.getText()),
                    txtCargo.getText()
            );

            manager.crear(e);

            cargarTabla();
            limpiar();
            mensaje("Empleado creado");

        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }

    @FXML
    public void buscar() {
        try {

            EmpleadoVO e = manager.buscar(
                    Integer.parseInt(txtId.getText())
            );

            if (e == null) {
                mensaje("Empleado no existe");
                return;
            }

            txtNombre.setText(e.getNombre());
            txtSalario.setText(String.valueOf(e.getSalario()));
            txtCargo.setText(e.getCargo());

        } catch (Exception e) {
            mensaje("Error al buscar");
        }
    }

    @FXML
    public void actualizar() {
        try {

            EmpleadoVO e = new EmpleadoVO(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    Double.parseDouble(txtSalario.getText()),
                    txtCargo.getText()
            );

            manager.actualizar(e);

            cargarTabla();
            limpiar();
            mensaje("Empleado actualizado");

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
            mensaje("Empleado eliminado");

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
        txtSalario.clear();
        txtCargo.clear();
    }

    private void mensaje(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}

