package edu.udelp.foros2.usuarios.controllers;

import java.io.IOException;

import edu.udelp.foros2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import edu.udelp.foros2.usuarios.Usuario;
import edu.udelp.foros2.usuarios.controllers.*;



public class LoginRegistroController {
	 @FXML
	 private TextField txtUsuarioL;
	 
	 @FXML
	 private TextField txtContraseñaL;
	 
	 
	 
	 @FXML
	 public void onClickL(ActionEvent event) {
		
		String usuario=txtUsuarioL.getText();
		String contraseña=txtContraseñaL.getText();
		
		
		int i=0;
		do {
			
			if(RegistroController.getListUsuario().get(i).getUsuarioProperty().get().equals(usuario)
					&&RegistroController.getListUsuario().get(i).getPasswordProperty().get().equals(contraseña)) {
				
				try {
					App.setRoot("foro");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
			i++;
		}while(RegistroController.getListUsuario().size()<i);
		
		
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
