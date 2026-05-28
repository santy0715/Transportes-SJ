package co.edu.poligran.paradigmas.frontend.Controllers;

import co.edu.poligran.paradigmas.backend.negocio.PersonaManager;
import co.edu.poligran.paradigmas.backend.vo.PersonaVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PersonaController {

    private PersonaManager manager = new PersonaManager();

    private ObservableList<PersonaVO> datos =
            FXCollections.observableArrayList();

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TableView<PersonaVO> tabla;

    @FXML
    private TableColumn<PersonaVO, Integer> colId;

    @FXML
    private TableColumn<PersonaVO, String> colNombre;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        tabla.setItems(datos);
        cargarTabla();
    }

    @FXML
    public void crear() {
        try {

            PersonaVO p = new PersonaVO(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText()
            );

            manager.crear(p);

            cargarTabla();
            limpiar();
            mensaje("Persona creada");

        } catch (Exception e) {
            mensaje(e.getMessage());
        }
    }

    @FXML
    public void buscar() {
        try {

            PersonaVO p = manager.buscar(
                    Integer.parseInt(txtId.getText())
            );

            if (p == null) {
                mensaje("Persona no existe");
                return;
            }

            txtNombre.setText(p.getNombre());

        } catch (Exception e) {
            mensaje("Error al buscar");
        }
    }

    @FXML
    public void actualizar() {
        try {

            PersonaVO p = new PersonaVO(
                    Integer.parseInt(txtId.getText()),
                    txtNombre.getText()
            );

            manager.actualizar(p);

            cargarTabla();
            limpiar();
            mensaje("Persona actualizada");

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
            mensaje("Persona eliminada");

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
    }

    private void mensaje(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}
