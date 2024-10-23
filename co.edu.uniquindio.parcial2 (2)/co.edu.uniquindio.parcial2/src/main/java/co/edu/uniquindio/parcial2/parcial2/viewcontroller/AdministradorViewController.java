package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.AdministradorController;
import co.edu.uniquindio.parcial2.parcial2.model.Cliente;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.parcial2.model.PrestamoUq;
import co.edu.uniquindio.parcial2.parcial2.services.Estado;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.parcial2.parcial2.utils.PrestamoUqConstantes.*;

public class AdministradorViewController {
    AdministradorController administradorController;
    ObservableList<Objeto> listaObjetos = FXCollections.observableArrayList();
    ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    PrestamoUq prestamoUq;
    ObservableList<Objeto> listaObjetosDisponibles = FXCollections.observableArrayList();
    ObservableList<Objeto> listaObjetosNoDisponibles = FXCollections.observableArrayList();
    ObservableList<Objeto> listaObjetosPrestamos = FXCollections.observableArrayList();
    ObservableList<Objeto> listaObjetosNoPrestamos = FXCollections.observableArrayList();
    ObservableList<Objeto> listaObjetosCompletos = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnObjetos;

    @FXML
    private Button btnObjetosConPrestamo;

    @FXML
    private Button btnObjetosSinPrestamo;

    @FXML
    private Button btnBuscarObjetoIdentificador;

    @FXML
    private Button btnObtenerListaRangoCliente;

    @FXML
    private Button btnObtenerListaRangoObjeto;

    @FXML
    private TextField txtIdentificadorObjeto;

    @FXML
    private TextField txtRangoCliente;

    @FXML
    private TextField txtRangoObjeto;

    @FXML
    private TextField txtResultadoCantidadObjetoDisponibles;

    @FXML
    private TextField txtResultadoCantidadObjetoNoDisponible;

    @FXML
    private TextArea txtResultadoObjetoEncontrado;

    @FXML
    private TableView<Objeto> tableObjetosPrestamos;

    @FXML
    private TableColumn<Objeto,Estado> tcEstadoTodo;

    @FXML
    private TableColumn<Objeto, String> tcIdObjetoTodo;

    @FXML
    private TableColumn<Objeto, String> tcNombreTodo;

    @FXML
    private TableColumn<Objeto, Prestamo> tcPrestamoTodo;

    @FXML
    private TableView<Cliente> tableCliente;

    @FXML
    private TableView<Objeto> tableObjeto;

    @FXML
    private TableView<Objeto> tableObjetoDisponible;

    @FXML
    private TableView<Objeto> tableObjetoNoDisponible;

    @FXML
    private TableColumn<Cliente, String> tcNombreCliente;

    @FXML
    private TableColumn<Cliente, String> tcApellidoCliente;

    @FXML
    private TableColumn<Cliente, String> tcCedulaCliente;

    @FXML
    private TableColumn<Cliente, Integer> tcEdadCliente;

    @FXML
    private TableColumn<Objeto, Estado> tcEstadoObjeto;

    @FXML
    private TableColumn<Objeto, Estado> tcEstadoObjetoDisponible;

    @FXML
    private TableColumn<Objeto, Estado> tcEstadoObjetoNoDisponible;

    @FXML
    private TableColumn<Objeto, String> tcIdObjeto;

    @FXML
    private TableColumn<Objeto, String> tcIdObjetoDisponible;

    @FXML
    private TableColumn<Objeto, String> tcIdObjetoNoDisponible;

    @FXML
    private TableColumn<Objeto, String> tcNombreObjeto;

    @FXML
    private TableColumn<Objeto, String> tcNombreObjetoDisponible;

    @FXML
    private TableColumn<Objeto, String> tcNombreObjetoNoDisponible;

    @FXML
    private TableColumn<Objeto, Prestamo> tcPrestamoAsociadoObjeto;

    @FXML
    private TableColumn<Objeto, Prestamo> tcPrestamoAsociadoObjetoDisponible;

    @FXML
    private TableColumn<Objeto, Prestamo> tcPrestamoAsociadoObjetoNoDisponible;

    @FXML
    void onBuscarObjetoIdentificador(ActionEvent event) {
        buscarObjetoIdentificador();
    }

    private void buscarObjetoIdentificador() {
        String idObjeto = txtIdentificadorObjeto.getText();
        Objeto objetoEncontrado = administradorController.obtenerObjeto(idObjeto);
        if(objetoEncontrado != null){
            txtResultadoObjetoEncontrado.setText(objetoEncontrado.toString());
            mostrarMensaje(TITULO_OBJETO_ENCONTRADO,HEADER,BODY_OBJETO_ENCONTRADO, Alert.AlertType.INFORMATION);
        } else{
            mostrarMensaje(TITULO_OBJETO_NO_ENCONTRADO,HEADER,BODY_OBJETO_NO_ENCONTRADO, Alert.AlertType.ERROR);
        }
    }

    @FXML
    void onObtenerListaRangoObjeto(ActionEvent event) {
        obtenerListaRangoObjeto();
    }

    private void obtenerListaRangoObjeto() {
        int rango = Integer.parseInt(txtRangoObjeto.getText());
        if(rango >= 0){
            List<Objeto> objetosRango = administradorController.obtenerObjetosRango(rango);
            listaObjetos.clear();
            listaObjetos.addAll(objetosRango);
            txtRangoObjeto.clear();
            mostrarMensaje(TITULO_LISTA_ACTUALIZADA,HEADER,BODY_LISTA_ACTUALIZADA, Alert.AlertType.INFORMATION);
        } else{
            mostrarMensaje(TITULO_RANGO_INCORRECTO,HEADER,BODY_RANGO_INCORRECTO, Alert.AlertType.WARNING);
        }

    }

    @FXML
    void onObtenerListaRangoCliente(ActionEvent event) {
        obtenerListaRangoCliente();

    }

    private void obtenerListaRangoCliente() {
        int rango = Integer.parseInt(txtRangoCliente.getText());
        if(rango >= 0){
            List<Cliente> clientesRango = administradorController.obtenerClientesRango(rango);
            listaClientes.clear();
            listaClientes.addAll(clientesRango);
            txtRangoCliente.clear();
            mostrarMensaje(TITULO_LISTA_ACTUALIZADA,HEADER,BODY_LISTA_ACTUALIZADA, Alert.AlertType.INFORMATION);
        } else{
            mostrarMensaje(TITULO_RANGO_INCORRECTO,HEADER,BODY_RANGO_INCORRECTO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void initialize() {
        administradorController = new AdministradorController();
        prestamoUq = new PrestamoUq();
        initView();
    }

    private void initView() {
        initDataBindingRangoObjeto();
        //obtenerObjetos();
        tableObjeto.getItems().clear();
        tableObjeto.setItems(listaObjetos);
        initDataBindingRangoCliente();
        //obtenerClientes();
        tableCliente.getItems().clear();
        tableCliente.setItems(listaClientes);
        initDataBindingObjetoDisponible();
        obtenerObjetosDisponibles();
        tableObjetoDisponible.getItems().clear();
        tableObjetoDisponible.setItems(listaObjetosDisponibles);
        initDataBindingObjetoNoDisponible();
        obtenerObjetosNoDisponibles();
        tableObjetoNoDisponible.getItems().clear();
        tableObjetoNoDisponible.setItems(listaObjetosNoDisponibles);
        initDataBindingObjetosPrestamos();
        obtenerObjetosPrestamosTodos();
        obtenerObjetosNoPrestamos();
        obtenerObjetosPrestamos();
        tableObjetosPrestamos.getItems().clear();
    }

    private void obtenerObjetosPrestamos() {
        listaObjetosPrestamos.addAll(administradorController.obtenerObjetosPrestamos());

    }

    private void obtenerObjetosNoPrestamos() {
        listaObjetosNoPrestamos.addAll(administradorController.obtenerObjetosNoPrestamos());
    }

    private void obtenerObjetosPrestamosTodos() {
        listaObjetosCompletos.addAll(administradorController.obtenerObjetos());

    }

    private void initDataBindingObjetosPrestamos() {
        tcNombreTodo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrestamoTodo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrestamoAsociado()));
        tcEstadoTodo.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstado()));
        tcIdObjetoTodo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdObjeto()));
    }

    private void obtenerObjetosNoDisponibles() {
        listaObjetosNoDisponibles.addAll(administradorController.obtenerObjetosNoDisponibles());
    }

    private void obtenerObjetosDisponibles() {
        listaObjetosDisponibles.addAll(administradorController.obtenerObjetosDisponibles());
    }

    private void initDataBindingObjetoNoDisponible() {
        tcNombreObjetoNoDisponible.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrestamoAsociadoObjetoNoDisponible.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrestamoAsociado()));
        tcEstadoObjetoNoDisponible.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstado()));
        tcIdObjetoNoDisponible.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdObjeto()));
    }

    private void initDataBindingObjetoDisponible() {
        tcNombreObjetoDisponible.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrestamoAsociadoObjetoDisponible.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrestamoAsociado()));
        tcEstadoObjetoDisponible.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstado()));
        tcIdObjetoDisponible.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdObjeto()));
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void initDataBindingRangoCliente() {
        tcNombreCliente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcApellidoCliente.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getApellido()));
        tcCedulaCliente.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getCedula()));
        tcEdadCliente.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEdad()));
    }

    private void initDataBindingRangoObjeto() {
        tcNombreObjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcPrestamoAsociadoObjeto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrestamoAsociado()));
        tcEstadoObjeto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstado()));
        tcIdObjeto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdObjeto()));
    }


    private void obtenerClientes() {
        listaClientes.addAll(administradorController.obtenerClientes());
    }

    @FXML
    void onObjetosConPrestamo(ActionEvent event) {
        objetosConPrestamo();

    }

    private void objetosConPrestamo() {
        tableObjetosPrestamos.setItems(listaObjetosPrestamos);
    }

    @FXML
    void onObjetosSinPrestamo(ActionEvent event) {
        objetosSinPrestamo();
    }

    private void objetosSinPrestamo() {
        tableObjetosPrestamos.setItems(listaObjetosNoPrestamos);
    }

    @FXML
    void onObjetos(ActionEvent event) {
        objetosCompletos();
    }

    private void objetosCompletos() {
        tableObjetosPrestamos.setItems(listaObjetosCompletos);

    }
}

