package edu.udelp.foros2;

import javafx.beans.property.SimpleStringProperty;

public class Usuario {

	private SimpleStringProperty nombre;
	private SimpleStringProperty apellidoPaterno;
	private SimpleStringProperty apellidoMaterno;
	private SimpleStringProperty email;
	
	public Usuario(String nombre, String apellidoPaterno,String apellidoMaterno, String email) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.apellidoPaterno = new SimpleStringProperty(apellidoPaterno);
		this.apellidoMaterno = new SimpleStringProperty(apellidoMaterno);
		this.email = new SimpleStringProperty(email);
	}
	
	public SimpleStringProperty getNombreProperty() {
		return nombre;
	}
	
	public SimpleStringProperty getApellidoPaternoProperty() {
		return apellidoPaterno;
	}
	
	public SimpleStringProperty getApellidoMaternoProperty() {
		return apellidoMaterno;
	}
	
	public SimpleStringProperty getEmailProperty() {
		return email;
	}
	
	
}