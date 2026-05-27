package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.ParadaManager;
import co.edu.poligran.paradigmas.backend.vo.ParadaVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ParadaController {

    private ParadaManager manager = new ParadaManager();

    private ObservableList<ParadaVO> datos =
            FXCollections.observableArrayList();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtUbicacion;

    @FXML
    private TableView<ParadaVO> tabla;

    @FXML
    private TableColumn<ParadaVO, Integer> colId;

    @FXML
    private TableColumn<ParadaVO, String> colNombre;

    @FXML
    private TableColumn<ParadaVO, String> colUbicacion;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colUbicacion.setCellValueFactory(
                new PropertyValueFactory<>("ubicacion"));

        tabla.setItems(datos);
        cargarTabla();
    }

    @FXML
    public void crear() {
        try {

            ParadaVO p = new ParadaVO(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    txtUbicacion.getText()
            );

            manager.crear(p);

            cargarTabla();
            limpiar();
            mensaje("Parada creada");

        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }

    @FXML
    public void buscar() {
        try {

            ParadaVO p = manager.buscar(
                    Integer.parseInt(txtId.getText())
            );

            if (p == null) {
                mensaje("Parada no existe");
                return;
            }

            txtNombre.setText(p.getNombre());
            txtUbicacion.setText(p.getUbicacion());

        } catch (Exception e) {
            mensaje("Error al buscar");
        }
    }

    @FXML
    public void actualizar() {
        try {

            ParadaVO p = new ParadaVO(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText(),
                    txtUbicacion.getText()
            );

            manager.actualizar(p);

            cargarTabla();
            limpiar();
            mensaje("Parada actualizada");

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
            mensaje("Parada eliminada");

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
        txtUbicacion.clear();
    }

    private void mensaje(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}

