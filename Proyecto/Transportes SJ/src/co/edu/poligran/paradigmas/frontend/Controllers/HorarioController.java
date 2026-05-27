package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.HorarioManager;
import co.edu.poligran.paradigmas.backend.vo.HorarioVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HorarioController {

    private HorarioManager manager =
            new HorarioManager();

    private ObservableList<HorarioVO> datos =
            FXCollections.observableArrayList();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtSalida;

    @FXML
    private TextField txtLlegada;

    @FXML
    private TextField txtDia;

    @FXML
    private TableView<HorarioVO> tabla;

    @FXML
    private TableColumn<HorarioVO, Integer> colId;

    @FXML
    private TableColumn<HorarioVO, String> colSalida;

    @FXML
    private TableColumn<HorarioVO, String> colLlegada;

    @FXML
    private TableColumn<HorarioVO, String> colDia;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colSalida.setCellValueFactory(
                new PropertyValueFactory<>("horaSalida"));

        colLlegada.setCellValueFactory(
                new PropertyValueFactory<>("horaLlegada"));

        colDia.setCellValueFactory(
                new PropertyValueFactory<>("dia"));

        tabla.setItems(datos);
        cargarTabla();

    }

    @FXML
    public void crear() {

        try {

            HorarioVO h = new HorarioVO(
                    Integer.parseInt(txtId.getText()),
                    txtSalida.getText(),
                    txtLlegada.getText(),
                    txtDia.getText()
            );

            manager.crear(h);

            cargarTabla();
            limpiar();
            mensaje("Horario creado");

        } catch (Exception e) {

            mensaje(e.getMessage());

        }

    }

    @FXML
    public void buscar() {

        try {

            HorarioVO h =
                    manager.buscar(
                            Integer.parseInt(txtId.getText())
                    );

            if (h == null) {

                mensaje("No existe");
                return;

            }

            txtSalida.setText(h.getHoraSalida());
            txtLlegada.setText(h.getHoraLlegada());
            txtDia.setText(h.getDia());

        } catch (Exception e) {

            mensaje("Error");

        }

    }

    @FXML
    public void actualizar() {

        try {

            HorarioVO h = new HorarioVO(
                    Integer.parseInt(txtId.getText()),
                    txtSalida.getText(),
                    txtLlegada.getText(),
                    txtDia.getText()
            );

            manager.actualizar(h);

            cargarTabla();
            limpiar();
            mensaje("Horario actualizado");

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
            mensaje("Horario eliminado");

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
        txtSalida.clear();
        txtLlegada.clear();
        txtDia.clear();

    }

    private void mensaje(String texto) {

        Alert alert =
                new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();

    }

}