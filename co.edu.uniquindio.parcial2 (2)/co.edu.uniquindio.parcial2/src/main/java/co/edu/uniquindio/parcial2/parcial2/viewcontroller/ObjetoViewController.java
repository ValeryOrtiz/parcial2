package co.edu.uniquindio.parcial2.parcial2.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.parcial2.parcial2.controller.ObjetoController;
import co.edu.uniquindio.parcial2.parcial2.model.Empleado;
import co.edu.uniquindio.parcial2.parcial2.model.Objeto;
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

public class ObjetoViewController {
    ObjetoController objetoController;
    PrestamoUq prestamoUq;
    Objeto objetoSeleccionado;
    ObservableList<Objeto> listaObjetos = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private RadioButton optionDisponible;

    @FXML
    private RadioButton optionNoDisponible;

    @FXML
    private TableView<Objeto> tableObjeto;

    @FXML
    private TableColumn<Objeto, Estado> tcEstado;

    @FXML
    private TableColumn<Objeto, String> tcIdObjeto;

    @FXML
    private TableColumn<Objeto, String> tcNombre;

    @FXML
    private TextField txtIdObjeto;

    @FXML
    private TextField txtNombre;

    @FXML
    void onNoDisponible(ActionEvent event) {
        seleccionNoDisponible();
    }

    private void seleccionNoDisponible() {
        optionNoDisponible.setSelected(true);
        optionDisponible.setSelected(false);
    }

    @FXML
    void onDisponible(ActionEvent event) {
        seleccionDisponible();
    }

    private void seleccionDisponible() {
        optionDisponible.setSelected(true);
        optionNoDisponible.setSelected(false);
    }

    @FXML
    void initialize() {
        objetoController = new ObjetoController();
        prestamoUq = new PrestamoUq();
        initView();
    }

    private void initView() {
        initDataBinding();
        obtenerObjetos();
        tableObjeto.getItems().clear();
        tableObjeto.setItems(listaObjetos);
        listenerSelection();
    }

    @FXML
    void oNActualizarObjeto(ActionEvent event) {
        actualizarObjeto();
    }

    private void actualizarObjeto() {
        Objeto objeto = crearObjeto();
        if (datosValidos(objeto)) {
            if (objetoController.actualizarObjeto(objetoSeleccionado.getIdObjeto(), objeto)) {
                actualizarListObserver(objeto);
                limpiarCampos();
                tableObjeto.refresh();
                mostrarMensaje(TITULO_OBJETO_ACTUALIZADO, HEADER, BODY_OBJETO_ACTUALIZADO, Alert.AlertType.CONFIRMATION);
            } else {
                mostrarMensaje(TITULO_OBJETO_NO_ACTUALIZADO, HEADER, BODY_OBJETO_NO_ACTUALIZADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    @FXML
    void onAgregarObjeto(ActionEvent event) {
        agregarObjeto();
    }

    private void agregarObjeto() {
        Objeto objeto = crearObjeto();
        if(datosValidos(objeto)) {
            if (objetoController.crearObjeto(objeto)) {
                listaObjetos.addAll(objeto);
                limpiarCampos();
                mostrarMensaje(TITULO_OBJETO_AGREGADO, HEADER, BODY_OBJETO_AGREGADO, Alert.AlertType.INFORMATION);
            } else {
                mostrarMensaje(TITULO_OBJETO_NO_AGREGADO, HEADER, BODY_OBJETO_NO_AGREGADO, Alert.AlertType.ERROR);
            }
        } else {
            mostrarMensaje(TITULO_INCOMPLETO, HEADER, BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }

    }

    @FXML
    void onEliminarObjeto(ActionEvent event) {
        eliminarObjeto();

    }

    private void eliminarObjeto() {
        if(datosValidos(objetoSeleccionado)){
            if(objetoController.eliminarObjeto(objetoSeleccionado)){
                listaObjetos.remove(objetoSeleccionado);
                limpiarCampos();
                tableObjeto.refresh();
                mostrarMensaje(TITULO_OBJETO_ELIMINADO,HEADER,BODY_OBJETO_ELIMINADO,Alert.AlertType.CONFIRMATION);
            } else{
                mostrarMensaje(TITULO_OBJETO_NO_ELIMINADO,HEADER,BODY_OBJETO_NO_ELIMINADO, Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje(TITULO_INCOMPLETO,HEADER,BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }
    }

    private void listenerSelection() {
        tableObjeto.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection)->{
            objetoSeleccionado = newSelection;
            mostrarInformacionObjeto(objetoSeleccionado);
        });
    }

    private void obtenerObjetos() {
        listaObjetos.addAll(objetoController.obtenerObjetos());

    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tcEstado.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEstado()));
        tcIdObjeto.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getIdObjeto()));
    }

    private boolean datosValidos(Objeto objeto) {
        if (objeto.getNombre().isEmpty() ||
                objeto.getIdObjeto().isEmpty() ||
                objeto.getEstado() == null) {
            return false;
        }
        return true;
    }

    private Objeto crearObjeto() {
        Estado estado = null;
        if (optionDisponible.isSelected()) {
            estado = Estado.DISPONIBLE;
        } else if (optionNoDisponible.isSelected()) {
            estado = Estado.NO_DISPONIBLE;
        } else {
            mostrarMensaje(TITULO_INCOMPLETO,HEADER,BODY_INCOMPLETO, Alert.AlertType.WARNING);
        }

        return Objeto.builder()
                .nombre(txtNombre.getText())
                .estado(estado)
                .idObjeto(txtIdObjeto.getText())
                .build();
    }

    private void actualizarListObserver(Objeto objeto) {
        for (int i = 0; i < listaObjetos.size(); i++) {
            if (listaObjetos.get(i).getIdObjeto().equals(objetoSeleccionado.getIdObjeto())) {
                listaObjetos.set(i, objeto);
                break;
            }
        }
    }

    private void mostrarInformacionObjeto(Objeto objetoSeleccionado) {
        if (objetoSeleccionado != null) {
            txtNombre.setText(objetoSeleccionado.getNombre());
            txtIdObjeto.setText(objetoSeleccionado.getIdObjeto());
            optionDisponible.setSelected(false);
            optionNoDisponible.setSelected(false);
            if (objetoSeleccionado.getEstado().equals(Estado.DISPONIBLE)) {
                optionDisponible.setSelected(true);
            } else if (objetoSeleccionado.getEstado().equals(Estado.NO_DISPONIBLE)) {
                optionNoDisponible.setSelected(true);
            }
        }
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
        txtIdObjeto.clear();
        optionDisponible.setSelected(false);
        optionNoDisponible.setSelected(false);
    }



}

