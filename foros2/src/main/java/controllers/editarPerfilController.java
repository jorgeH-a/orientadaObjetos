package controllers;

import convertores.ConvertorPost;
import edu.udelp.foros2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import static convertores.ConvertorUsuario.jsonTextoUsuario;
import static convertores.ConvertorUsuario.listUsuarioDTO;
import convertores.ConvertorUsuario;

import usuarios.UsuarioDTO;

import java.io.IOException;
import java.util.ArrayList;

import static controllers.LoginRegistroController.usuarioDTOActual;

public class editarPerfilController {

    ArrayList<UsuarioDTO> usuarioDTO=jsonTextoUsuario();



    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtEmail;
    @FXML
    private ComboBox<String> cbGenero;
    @FXML
    private TextArea txtDescripcion;

    @FXML
    public void initialize() {
        cbGenero.getItems().addAll("Masculino", "Femenino", "Prefiero no decir");

    }


    @FXML
    private void onEditar(ActionEvent event) {
        listUsuarioDTO=usuarioDTO;
        String nombre = txtNombre.getText();
        String password = txtPassword.getText();
        String usuario = txtUsuario.getText();
        String email = txtEmail.getText();
        String genero = cbGenero.getValue();
        String descripcion = txtDescripcion.getText();

        if(nombre==null){
            nombre=usuarioDTOActual.getNombre();
        }
        if(password==null){
            password=usuarioDTOActual.getPassword();
        }
        if(usuario==null){
            usuario=usuarioDTOActual.getUsuario();
        }
        if(email==null){
            email=usuarioDTOActual.getEmail();
        }
        if(genero==null){
            genero=usuarioDTOActual.getGenero();
        }
        if(descripcion==null){
            descripcion=usuarioDTOActual.getDescription();
        }

        for (int i=0;i<listUsuarioDTO.size();i++) {
            if(listUsuarioDTO.get(i).getUsuario()==usuarioDTOActual.getUsuario()){
                listUsuarioDTO.get(i).setNombre(nombre);
                listUsuarioDTO.get(i).setPassword(password);
                listUsuarioDTO.get(i).setUsuario(usuario);
                listUsuarioDTO.get(i).setEmail(email);
                listUsuarioDTO.get(i).setGenero(genero);
                listUsuarioDTO.get(i).setDescription(descripcion);
                ConvertorUsuario.textoJsonUsuarioModificacion();

                listUsuarioDTO.clear();
                usuarioDTO.clear();
                ConvertorUsuario.getListUsuarioDTO().clear();
                break;
            }

        }


        try {
            App.setRoot("perfil");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }


    @FXML
    private void onBack(ActionEvent event) {
        try {
            App.setRoot("perfil");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
