package controllers;

import java.io.IOException;
import java.util.ArrayList;

import edu.udelp.foros2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import usuarios.UsuarioDTO;

import static edu.udelp.foros2.Convertor.jsonTexto;


public class LoginRegistroController {
	 @FXML
	 private TextField txtUsuarioL;
	 
	 @FXML
	 private TextField txtContraseñaL;
	 
	 
	 
	 @FXML
	 public void onClickL(ActionEvent event) {
		
		String usuario=txtUsuarioL.getText();
		String password =txtContraseñaL.getText();
		 ArrayList<UsuarioDTO> usuarios = jsonTexto();

         for (UsuarioDTO usuarioDTO : usuarios) {
             if (usuarioDTO.getUsuario().equals(usuario)
                     && usuarioDTO.getPassword().equals(password)) {

                 try {
                     App.setRoot("foro");
                 } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
             }
         }





	 }

	 @FXML
	 public void onClickR(ActionEvent event) {
		 try {
				App.setRoot("UsuarioRegistro");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 
	 
}
