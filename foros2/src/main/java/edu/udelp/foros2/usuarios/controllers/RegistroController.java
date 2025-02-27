package edu.udelp.foros2.usuarios.controllers;

import java.io.IOException;
import java.util.ArrayList;

import edu.udelp.foros2.App;
import edu.udelp.foros2.usuarios.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistroController {

	ArrayList<Usuario> listUsuario=new ArrayList<>();
	@FXML
	private ComboBox<String> cbGenero;
	@FXML
    private TextField txtFecha;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtUsuario;
    
    @FXML
    public void initialize() {
        cbGenero.getItems().addAll("Masculino", "Femenino", "Prefiero no decir");
        
    }
    
    public void onClick(ActionEvent event) {
    	String nombre=txtNombre.getText();
    	String password=txtPassword.getText();
    	String des=txtDescripcion.getText();
    	String genero=cbGenero.getValue();
    	String email=txtEmail.getText();
    	String fecha=txtFecha.getText();
    	String usuario=txtUsuario.getText();
    	String estatus="Activo";
    	
    	
    	listUsuario.add(new Usuario(nombre,password,des,genero,email,fecha,usuario,estatus));
    	
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("Bienvenido");
    	alert.setHeaderText("Usuario: "+usuario);
    	alert.setContentText("Nombre: "+nombre+
    			"\nEmail: "+email);

    	alert.showAndWait();
    	
    }
    
    
    
    
    
    
    

}
