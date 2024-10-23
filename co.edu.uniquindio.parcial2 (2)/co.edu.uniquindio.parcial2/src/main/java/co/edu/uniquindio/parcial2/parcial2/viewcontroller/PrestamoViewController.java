package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.ClienteController;
import co.edu.uniquindio.parcial2.parcial2.controller.PrestamoController;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;
import co.edu.uniquindio.parcial2.parcial2.model.Prestamo;
import co.edu.uniquindio.parcial2.parcial2.model.PrestamoUq;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static co.edu.uniquindio.parcial2.parcial2.utils.PrestamoUqConstantes.*;
import static co.edu.uniquindio.parcial2.parcial2.utils.PrestamoUqConstantes.BODY_RANGO_INCORRECTO;

public class PrestamoViewController {
    PrestamoController prestamoController;
    PrestamoUq prestamoUq;
    ObservableList<Prestamo> listaPrestamosEspecifico = FXCollections.observableArrayList();
    ObservableList<Prestamo> listaPrestamosRango = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnFechaEspecifica;

    @FXML
    private Button btnRango;

    @FXML
    private TableView<Prestamo> tableFechaRango;

    @FXML
    private TableView<Prestamo> tablePrestamoEspecifico;

    @FXML
    private TableColumn<Prestamo, String> tcDescripcionEspecifico;

    @FXML
    private TableColumn<Prestamo, String> tcDescripcionRango;

    @FXML
    private TableColumn<Prestamo, String> tcFechaEntregaEspecifico;

    @FXML
    private TableColumn<Prestamo, String> tcFechaEntregaRango;

    @FXML
    private TableColumn<Prestamo, String> tcFechaPrestamoEspecifico;

    @FXML
    private TableColumn<Prestamo, String> tcFechaPrestamoRango;

    @FXML
    private TableColumn<Prestamo, String> tcIdPrestamoEspecifico;

    @FXML
    private TableColumn<Prestamo, String> tcIdPrestamoRango;

    @FXML
    private TextField txtFechaEspecifica;

    @FXML
    private TextField txtFechaFinal;

    @FXML
    private TextField txtFechaInicial;

    @FXML
    void onActionFechaEspecifica(ActionEvent event) {
        obtenerListaEspecifica();
    }

    @FXML
    void onActionRango(ActionEvent event) {
        obtenerListaRango();
    }

    @FXML
    void initialize() {
        prestamoController = new PrestamoController();
        prestamoUq = new PrestamoUq();
        initView();
    }

    private void initView() {
        initDataBindingRango();
        tableFechaRango.getItems().clear();
        tableFechaRango.setItems(listaPrestamosRango);
        initDataBindingEspecifico();
        tablePrestamoEspecifico.getItems().clear();
        tablePrestamoEspecifico.setItems(listaPrestamosEspecifico);
    }

    private void initDataBindingRango() {
        tcFechaPrestamoRango.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaPrestamo().toString()));
        tcDescripcionRango.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        tcIdPrestamoRango.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroPrestamo()));
        tcFechaEntregaRango.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaEntrega().toString()));
    }

    private void initDataBindingEspecifico() {
        tcFechaPrestamoEspecifico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaPrestamo().toString()));
        tcDescripcionEspecifico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescripcion()));
        tcIdPrestamoEspecifico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroPrestamo()));
        tcFechaEntregaEspecifico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaEntrega().toString()));
    }

    private void obtenerListaRango() {
        LocalDateTime rangoInicial = LocalDateTime.parse(txtFechaInicial.getText());
        LocalDateTime rangoFinal = LocalDateTime.parse(txtFechaFinal.getText());
        List<Prestamo> prestamoRango = prestamoController.obtenerPrestamoRango(rangoInicial, rangoFinal);
        listaPrestamosRango.clear();
        listaPrestamosRango.addAll(prestamoRango);
        txtFechaInicial.clear();
        txtFechaFinal.clear();
        mostrarMensaje(TITULO_LISTA_ACTUALIZADA, HEADER, BODY_LISTA_ACTUALIZADA, Alert.AlertType.INFORMATION);
    }

    private void obtenerListaEspecifica() {
        LocalDateTime rango = LocalDateTime.parse(txtFechaEspecifica.getText());
        List<Prestamo> prestamoRango = prestamoController.obtenerPrestamoEspecifico(rango);
        listaPrestamosEspecifico.clear();
        listaPrestamosEspecifico.addAll(prestamoRango);
        txtFechaEspecifica.clear();
        mostrarMensaje(TITULO_LISTA_ACTUALIZADA, HEADER, BODY_LISTA_ACTUALIZADA, Alert.AlertType.INFORMATION);
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

}
