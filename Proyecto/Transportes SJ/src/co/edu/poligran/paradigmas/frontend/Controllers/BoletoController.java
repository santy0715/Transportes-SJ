package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.BoletoManager;
import co.edu.poligran.paradigmas.backend.vo.AsientoVO;
import co.edu.poligran.paradigmas.backend.vo.BoletoVO;
import co.edu.poligran.paradigmas.backend.vo.PasajeroVO;
import co.edu.poligran.paradigmas.backend.vo.RutaVO;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BoletoController {

    private BoletoManager manager = new BoletoManager();

    private ObservableList<BoletoVO> datos =
            FXCollections.observableArrayList();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtPasajero;

    @FXML
    private TextField txtRuta;

    @FXML
    private TextField txtAsiento;

    @FXML
    private TableView<BoletoVO> tabla;

    @FXML
    private TableColumn<BoletoVO, Integer> colId;

    @FXML
    private TableColumn<BoletoVO, Double> colPrecio;

    @FXML
    private TableColumn<BoletoVO, String> colFecha;

    @FXML
    private TableColumn<BoletoVO, Integer> colPasajero;

    @FXML
    private TableColumn<BoletoVO, Integer> colRuta;

    @FXML
    private TableColumn<BoletoVO, Integer> colAsiento;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(
                        cellData.getValue().getId()
                ).asObject());

        colPrecio.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(
                        cellData.getValue().getPrecio()
                ).asObject());

        colFecha.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getFecha()
                ));

        colPasajero.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(
                        cellData.getValue().getPasajero().getId()
                ).asObject());

        colRuta.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(
                        cellData.getValue().getRuta().getId()
                ).asObject());

        colAsiento.setCellValueFactory(cellData ->
                new SimpleIntegerProperty(
                        cellData.getValue().getAsiento().getNumero()
                ).asObject());

        tabla.setItems(datos);
        cargarTabla();
    }

    @FXML
    public void crear() {
        try {

            PasajeroVO pasajero = new PasajeroVO(
                    Integer.parseInt(txtPasajero.getText()),
                    "",
                    "",
                    ""
            );

            RutaVO ruta = new RutaVO(
                    Integer.parseInt(txtRuta.getText()),
                    "",
                    "",
                    null,
                    null
            );

            AsientoVO asiento = new AsientoVO(
                    Integer.parseInt(txtAsiento.getText())
            );

            BoletoVO b = new BoletoVO(
                    Integer.parseInt(txtId.getText()),
                    Double.parseDouble(txtPrecio.getText()),
                    txtFecha.getText(),
                    pasajero,
                    ruta,
                    asiento
            );

            manager.crear(b);

            cargarTabla();
            limpiar();
            mensaje("Boleto creado");

        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }

    @FXML
    public void buscar() {
        try {

            BoletoVO b = manager.buscar(
                    Integer.parseInt(txtId.getText())
            );

            if (b == null) {
                mensaje("Boleto no existe");
                return;
            }

            txtPrecio.setText(String.valueOf(b.getPrecio()));
            txtFecha.setText(b.getFecha());
            txtPasajero.setText(String.valueOf(b.getPasajero().getId()));
            txtRuta.setText(String.valueOf(b.getRuta().getId()));
            txtAsiento.setText(String.valueOf(b.getAsiento().getNumero()));

        } catch (Exception e) {
            mensaje("Error al buscar");
        }
    }

    @FXML
    public void actualizar() {
        try {

            PasajeroVO pasajero = new PasajeroVO(
                    Integer.parseInt(txtPasajero.getText()),
                    "",
                    "",
                    ""
            );

            RutaVO ruta = new RutaVO(
                    Integer.parseInt(txtRuta.getText()),
                    "",
                    "",
                    null,
                    null
            );

            AsientoVO asiento = new AsientoVO(
                    Integer.parseInt(txtAsiento.getText())
            );

            BoletoVO b = new BoletoVO(
                    Integer.parseInt(txtId.getText()),
                    Double.parseDouble(txtPrecio.getText()),
                    txtFecha.getText(),
                    pasajero,
                    ruta,
                    asiento
            );

            manager.actualizar(b);

            cargarTabla();
            limpiar();
            mensaje("Boleto actualizado");

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
            mensaje("Boleto eliminado");

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
        txtPrecio.clear();
        txtFecha.clear();
        txtPasajero.clear();
        txtRuta.clear();
        txtAsiento.clear();
    }

    private void mensaje(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}