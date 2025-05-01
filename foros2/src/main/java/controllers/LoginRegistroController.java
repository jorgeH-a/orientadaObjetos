package controllers;

import java.io.IOException;
import java.util.ArrayList;

import edu.udelp.foros2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import usuarios.Usuario;
import usuarios.UsuarioDTO;

import static edu.udelp.foros2.Convertor.jsonTextoUsuario;


public class LoginRegistroController {


	public static UsuarioDTO usuarioDTOActual;

	@FXML
	 private TextField txtUsuarioL;
	 
	 @FXML
	 private TextField txtContraseñaL;
	 
	 
	 
	 @FXML
	 public void onClickL(ActionEvent event) {

		String usuarioActual=txtUsuarioL.getText();
		String passwordActual =txtContraseñaL.getText();
		ArrayList<UsuarioDTO> usuariosDTO = jsonTextoUsuario();

         for (UsuarioDTO usuarioDTO : usuariosDTO) {
             if (usuarioDTO.getUsuario().equals(usuarioActual)
                     && usuarioDTO.getPassword().equals(passwordActual)) {
				 usuarioDTOActual=usuarioDTO;

                 try {
                     App.setRoot("foros");
                 } catch (IOException e) {
                     // TODO Auto-generated catch block
                     e.printStackTrace();
                 }
             }
         }


	 }
	 public Usuario conversorStringUsuario(){
		 Usuario usuario=new Usuario(usuarioDTOActual.getNombre(),usuarioDTOActual.getPassword(),usuarioDTOActual.getDescription(),usuarioDTOActual.getGenero(),usuarioDTOActual.getEmail(),
				 usuarioDTOActual.getFechaNacimiento(),usuarioDTOActual.getUsuario(),usuarioDTOActual.getStatus());
		return usuario;
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
