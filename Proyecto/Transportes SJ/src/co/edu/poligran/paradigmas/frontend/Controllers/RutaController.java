package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.RutaManager;
import co.edu.poligran.paradigmas.backend.vo.HorarioVO;
import co.edu.poligran.paradigmas.backend.vo.RutaVO;
import co.edu.poligran.paradigmas.backend.vo.VehiculoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class RutaController {
    private RutaManager manager = new RutaManager();
    private ObservableList<RutaVO> datos =
            FXCollections.observableArrayList();
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtOrigen;
    @FXML
    private TextField txtDestino;
    @FXML
    private TextField txtHorario;
    @FXML
    private TextField txtVehiculo;
    @FXML
    private TableView<RutaVO> tabla;
    @FXML
    private TableColumn<RutaVO, Integer> colId;
    @FXML
    private TableColumn<RutaVO, String> colOrigen;
    @FXML
    private TableColumn<RutaVO, String> colDestino;
    @FXML
    private TableColumn<RutaVO, Integer> colHorario;
    @FXML
    private TableColumn<RutaVO, Integer> colVehiculo;
    @FXML
    public void initialize() {
        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        colOrigen.setCellValueFactory(
                new PropertyValueFactory<>("origen"));
        colDestino.setCellValueFactory(
                new PropertyValueFactory<>("destino"));
        colHorario.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(
                        cellData.getValue().getHorario().getId()
                ).asObject());
        colVehiculo.setCellValueFactory(cellData ->
                new javafx.beans.property.SimpleIntegerProperty(
                        cellData.getValue().getVehiculo().getId()
                ).asObject());
        tabla.setItems(datos);
        cargarTabla();
    }
    @FXML
    public void crear() {
        try {
            HorarioVO horario = new HorarioVO(
                    Integer.parseInt(txtHorario.getText()),
                    "",
                    "",
                    ""
            );
            VehiculoVO vehiculo = new VehiculoVO(
                    Integer.parseInt(txtVehiculo.getText()),
                    0,
                    "",
                    ""
            );
            RutaVO r = new RutaVO(
                    Integer.parseInt(txtId.getText()),
                    txtOrigen.getText(),
                    txtDestino.getText(),
                    horario,
                    vehiculo
            );
            manager.crear(r);
            cargarTabla();
            limpiar();
            mensaje("Ruta creada");
        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }
    @FXML
    public void buscar() {
        try {
            RutaVO r = manager.buscar(
                    Integer.parseInt(txtId.getText())
            );
            if (r == null) {
                mensaje("No existe");
                return;
            }
            txtOrigen.setText(r.getOrigen());
            txtDestino.setText(r.getDestino());
            txtHorario.setText(String.valueOf(r.getHorario().getId()));
            txtVehiculo.setText(String.valueOf(r.getVehiculo().getId()));
        } catch (Exception e) {

            mensaje("Error");
        }
    }
    @FXML
    public void actualizar() {
        try {
            HorarioVO horario = new HorarioVO(
                    Integer.parseInt(txtHorario.getText()),
                    "",
                    "",
                    ""
            );
            VehiculoVO vehiculo = new VehiculoVO(
                    Integer.parseInt(txtVehiculo.getText()),
                    0,
                    "",
                    ""
            );
            RutaVO r = new RutaVO(
                    Integer.parseInt(txtId.getText()),
                    txtOrigen.getText(),
                    txtDestino.getText(),
                    horario,
                    vehiculo
            );
            manager.actualizar(r);
            cargarTabla();
            limpiar();
            mensaje("Ruta actualizada");
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
            mensaje("Ruta eliminada");
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
        txtOrigen.clear();
        txtDestino.clear();
        txtHorario.clear();
        txtVehiculo.clear();
    }
    private void mensaje(String texto) {
        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}