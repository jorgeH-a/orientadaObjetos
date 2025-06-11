package controllers;

import convertores.ConvertorUsuario;
import edu.udelp.foros2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import usuarios.UsuarioDTO;

import java.io.IOException;

import static controllers.LoginRegistroController.usuarioDTOActual;
import static convertores.ConvertorUsuario.listUsuarioDTO;


public class usuariosSeguidosController {
    @FXML
    private VBox lugarUsuarios;

    @FXML
    public void initialize() {
        listUsuarioDTO= ConvertorUsuario.jsonTextoUsuario();


        for (UsuarioDTO usuarioDTO : listUsuarioDTO) {
            if (usuarioDTOActual.getUsuario().equals(usuarioDTO.getUsuario())) {
                TextFlow textFlowUsuarios = new TextFlow();

                Text Usuario = new Text("Usuario: " + usuarioDTO.getUsuario() + "\n");
                Text Descripcion = new Text("Descripción: " + usuarioDTO.getDescription() + "\n");
                Text Status = new Text("Status: " + usuarioDTO.getStatus());

                textFlowUsuarios.getChildren().addAll(Usuario, Descripcion, Status);
                lugarUsuarios.getChildren().add(textFlowUsuarios);
            }

        }










    }


    @FXML
    public void onBack(ActionEvent event) {

        try {
            App.setRoot("foros");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
