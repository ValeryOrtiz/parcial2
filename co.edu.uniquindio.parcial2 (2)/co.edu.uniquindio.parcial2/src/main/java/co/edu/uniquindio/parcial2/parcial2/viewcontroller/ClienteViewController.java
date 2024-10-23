package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.PrestamoUq;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.parcial2.parcial2.utils.PrestamoUqConstantes.*;

public class ClienteViewController {
    ClienteController clienteController;
    PrestamoUq prestamoUq;
    Cliente clienteSeleccionado;
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminarCliente;

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableColumn<Cliente, String> tcApellido;

    @FXML
    private TableColumn<Cliente, String> tcCedula;

    @FXML
    private TableColumn<Cliente, Integer> tcEdad;

    @FXML
    private TableColumn<Cliente, String> tcNombre;

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
        clienteController = new ClienteController();
        prestamoUq = new PrestamoUq();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerClientes();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaClientes);
        listenerSelection();
    }

    @FXML
    void oNActualizar(ActionEvent event) {
        actualizarCliente();

    }

    private void actualizarCliente() {
        Cliente cliente = crearCliente();
        if(datosValidos(cliente)) {
            if (clienteController.actualizarCliente(clienteSeleccionado.getCedula(),cliente)) {
                actualizarListObserver(cliente);
                limpiarCampos();
                tableCliente.refresh();
                mostrarMensaje(TITULO_CLIENTE_ACTUALIZADO, HEADER, BODY_CLIENTE_ACTUALIZADO, Alert.AlertType.CONFIRMATION);
            } else {
                mostrarMensaje(TITULO_CLIENTE_NO_ACTUALIZADO, HEADER, BODY_CLIENTE_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        } 
    }

    @FXML
    void onAgregar(ActionEvent event) {
        agregarCliente();

    }

    private void agregarCliente() {
        Cliente cliente = crearCliente();
        if(datosValidos(cliente)) {
            if (clienteController.crearCliente(cliente)) {
                listaClientes.addAll(cliente);
                limpiarCampos();
                mostrarMensaje(TITULO_CLIENTE_AGREGADO, HEADER, BODY_CLIENTE_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_CLIENTE_NO_AGREGADO, HEADER, BODY_CLIENTE_NO_AGREGADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
        
    }

    @FXML
    void onEliminarCliente(ActionEvent event) {
        eliminarCliente();
    }

    private void eliminarCliente() {
        if(datosValidos(clienteSeleccionado)){
            if(clienteController.eliminarCliente(clienteSeleccionado)){
                listaClientes.remove(clienteSeleccionado);
                limpiarCampos();
                tableCliente.refresh();
                mostrarMensaje(TITULO_CLIENTE_ELIMINADO,HEADER,BODY_CLIENTE_ELIMINADO,Alert.AlertType.CONFIRMATION);
            } else{
                mostrarMensaje(TITULO_CLIENTE_NO_ELIMINADO,HEADER,BODY_CLIENTE_NO_ELIMINADO, Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO,HEADER,BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private Cliente crearCliente() {
        return Cliente.builder()
                .nombre(txtNombre.getText())
                .apellido(txtApellido.getText())
                .cedula(txtCedula.getText())
                .edad(Integer.parseInt(txtEdad.getText()))
                .build();
    }

    private boolean datosValidos(Cliente cliente) {
        if (cliente.getNombre().isEmpty() ||
                cliente.getApellido().isEmpty() ||
                txtEdad.getText().isBlank() ||
                cliente.getCedula().isEmpty() ||
                cliente.getEdad()<=0) {
            return false;
        } else {
            return true;
        }
    }

    private void actualizarListObserver(Cliente cliente) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCedula().equals(clienteSeleccionado.getCedula())) {
                listaClientes.set(i, cliente);
                break;
            }
        }
    }

    private void listenerSelection() {
        tableCliente.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            clienteSeleccionado = newSelection;
            mostrarInformacionCliente(clienteSeleccionado);
        });
    }

    private void mostrarInformacionCliente(Cliente clienteSeleccionado) {
        if(clienteSeleccionado != null){
            txtNombre.setText(clienteSeleccionado.getNombre());
            txtApellido.setText(clienteSeleccionado.getApellido());
            txtCedula.setText(clienteSeleccionado.getCedula());
            txtEdad.setText(String.valueOf(clienteSeleccionado.getEdad()));
        }
    }

    private void obtenerClientes() {
        listaClientes.addAll(clienteController.obtenerClientes());
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

