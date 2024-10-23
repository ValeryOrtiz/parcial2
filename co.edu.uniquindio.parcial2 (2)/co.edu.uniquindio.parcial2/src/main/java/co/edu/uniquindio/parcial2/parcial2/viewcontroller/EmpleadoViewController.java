package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.parcial2.controller.EmpleadoController;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.parcial2.model.PrestamoUq;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.parcial2.parcial2.utils.PrestamoUqConstantes.*;

public class EmpleadoViewController {
    EmpleadoController empleadoController;
    PrestamoUq prestamoUq;
    Empleado empleadoSeleccionado;
    ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizarEmpleado;

    @FXML
    private Button btnAgregarEmpleado;

    @FXML
    private Button btnEliminarEmpleado;

    @FXML
    private TableView<Empleado> tableEmpleado;

    @FXML
    private TableColumn<Empleado, String> tcApellido;

    @FXML
    private TableColumn<Empleado, String> tcCedula;

    @FXML
    private TableColumn<Empleado, Integer> tcEdad;

    @FXML
    private TableColumn<Empleado, String> tcNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    @FXML
    void initialize() {
        empleadoController = new EmpleadoController();
        prestamoUq = new PrestamoUq();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerEmpleados();
        tableEmpleado.getItems().clear();
        tableEmpleado.setItems(listaEmpleados);
        listenerSelection();
    }

    @FXML
    void oNActualizarEmpleado(ActionEvent event) {
        actualizarEmpleado();

    }

    private void actualizarEmpleado() {
        Empleado empleado = crearEmpleado();
        if(datosValidos(empleado)) {
            if (empleadoController.actualizarEmpleado(empleadoSeleccionado.getCedula(),empleado)) {
                actualizarListObserver(empleado);
                limpiarCampos();
                tableEmpleado.refresh();
                mostrarMensaje(TITULO_EMPLEADO_ACTUALIZADO, HEADER, BODY_EMPLEADO_ACTUALIZADO, Alert.AlertType.CONFIRMATION);
            } else {
                mostrarMensaje(TITULO_EMPLEADO_NO_ACTUALIZADO, HEADER, BODY_EMPLEADO_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onAgregarEmpleado(ActionEvent event) {
        agregarEmpleado();

    }

    private void agregarEmpleado() {
        Empleado empleado = crearEmpleado();
        if(datosValidos(empleado)) {
            if (empleadoController.crearEmpleado(empleado)) {
                listaEmpleados.addAll(empleado);
                limpiarCampos();
                mostrarMensaje(TITULO_EMPLEADO_AGREGADO, HEADER, BODY_EMPLEADO_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_EMPLEADO_NO_AGREGADO, HEADER, BODY_EMPLEADO_NO_AGREGADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }

    }

    @FXML
    void onEliminarEmpleado(ActionEvent event) {
        eliminarEmpleado();
    }

    private void eliminarEmpleado() {
        if(datosValidos(empleadoSeleccionado)){
            if(empleadoController.eliminarEmpleado(empleadoSeleccionado)){
                listaEmpleados.remove(empleadoSeleccionado);
                limpiarCampos();
                tableEmpleado.refresh();
                mostrarMensaje(TITULO_EMPLEADO_ELIMINADO,HEADER,BODY_EMPLEADO_ELIMINADO,Alert.AlertType.CONFIRMATION);
            } else{
                mostrarMensaje(TITULO_EMPLEADO_NO_ELIMINADO,HEADER,BODY_EMPLEADO_NO_ELIMINADO, Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO,HEADER,BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private Empleado crearEmpleado() {
        return Empleado.builder()
                .nombre(txtNombre.getText())
                .apellido(txtApellido.getText())
                .cedula(txtCedula.getText())
                .edad(Integer.parseInt(txtEdad.getText()))
                .build();
    }

    private boolean datosValidos(Empleado empleado) {
        if (empleado.getNombre().isEmpty() ||
                empleado.getApellido().isEmpty() ||
                txtEdad.getText().isBlank() ||
                empleado.getCedula().isEmpty() ||
                empleado.getEdad()<=0) {
            return false;
        } else {
            return true;
        }
    }

    private void actualizarListObserver(Empleado empleado) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            if (listaEmpleados.get(i).getCedula().equals(empleadoSeleccionado.getCedula())) {
                listaEmpleados.set(i, empleado);
                break;
            }
        }
    }

    private void listenerSelection() {
        tableEmpleado.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            empleadoSeleccionado = newSelection;
            mostrarInformacionEmpleado(empleadoSeleccionado);
        });
    }

    private void mostrarInformacionEmpleado(Empleado empleadoSeleccionado) {
        if(empleadoSeleccionado != null){
            txtNombre.setText(empleadoSeleccionado.getNombre());
            txtApellido.setText(empleadoSeleccionado.getApellido());
            txtCedula.setText(empleadoSeleccionado.getCedula());
            txtEdad.setText(String.valueOf(empleadoSeleccionado.getEdad()));
        }
    }

    private void obtenerEmpleados() {
        listaEmpleados.addAll(empleadoController.obtenerEmpleados());
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellido.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getApellido()));
        tcCedula.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCedula()));
        tcEdad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEdad()));
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtApellido.clear();
        txtCedula.clear();
        txtEdad.clear();
    }

}

