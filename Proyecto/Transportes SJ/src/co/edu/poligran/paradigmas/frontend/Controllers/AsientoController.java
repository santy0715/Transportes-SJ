package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.AsientoManager;
import co.edu.poligran.paradigmas.backend.vo.AsientoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AsientoController {
    private AsientoManager manager = new AsientoManager();
    private ObservableList<AsientoVO> datos =
            FXCollections.observableArrayList();
    @FXML
    private TextField txtNumero;
    @FXML
    private TextField txtOcupado;
    @FXML
    private TableView<AsientoVO> tabla;
    @FXML
    private TableColumn<AsientoVO, Integer> colNumero;
    @FXML
    private TableColumn<AsientoVO, Boolean> colOcupado;
    @FXML
    public void initialize() {
        colNumero.setCellValueFactory(
                new PropertyValueFactory<>("numero"));

        colOcupado.setCellValueFactory(
                new PropertyValueFactory<>("ocupado"));

        tabla.setItems(datos);
        cargarTabla();
    }
    @FXML
    public void crear() {
        try {
            AsientoVO a = new AsientoVO(
                    Integer.parseInt(txtNumero.getText())
            );
            a.setOcupado(
                    Boolean.parseBoolean(txtOcupado.getText())
            );
            manager.crear(a);
            cargarTabla();
            limpiar();
            mensaje("Asiento creado");

        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }
    @FXML
    public void buscar() {
        try {
            AsientoVO a = manager.buscar(
                    Integer.parseInt(txtNumero.getText())
            );
            if (a == null) {
                mensaje("Asiento no existe");
                return;
            }
            txtOcupado.setText(String.valueOf(a.isOcupado()));
        } catch (Exception e) {
            mensaje("Error al buscar");
        }
    }
    @FXML
    public void actualizar() {
        try {
            AsientoVO a = new AsientoVO(
                    Integer.parseInt(txtNumero.getText())
            );
            a.setOcupado(
                    Boolean.parseBoolean(txtOcupado.getText())
            );
            manager.actualizar(a);
            cargarTabla();
            limpiar();
            mensaje("Asiento actualizado");
        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }
    @FXML
    public void eliminar() {
        try {
            manager.eliminar(
                    Integer.parseInt(txtNumero.getText())
            );
            cargarTabla();
            limpiar();
            mensaje("Asiento eliminado");

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
        txtNumero.clear();
        txtOcupado.clear();
    }
    private void mensaje(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}