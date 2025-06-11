package controllers;

import comunidad.ComunidadDTO;
import convertores.ConvertorComunidad;
import convertores.ConvertorUsuario;
import edu.udelp.foros2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import usuarios.UsuarioDTO;

import java.io.IOException;
import java.util.ArrayList;

import static controllers.LoginRegistroController.usuarioDTOActual;

public class perfilController {


    @FXML
    private Label lblNombre;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblDescripcion;

    @FXML
    private Label lblGenero;

    @FXML
    private Label lblFecha;

    @FXML
    public void initialize() {
        lblNombre.setText(usuarioDTOActual.getNombre());
        lblPassword.setText(usuarioDTOActual.getPassword());
        lblUsuario.setText(usuarioDTOActual.getUsuario());
        lblEmail.setText(usuarioDTOActual.getEmail());
        lblDescripcion.setText(usuarioDTOActual.getDescription());
        lblGenero.setText(usuarioDTOActual.getGenero());
        lblFecha.setText(usuarioDTOActual.getFechaNacimiento());

    }

    @FXML
    private void onEditar(ActionEvent event) {
        try {
            App.setRoot("editarPerfil");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void onBack(ActionEvent event) {
        try {
            App.setRoot("foros");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
