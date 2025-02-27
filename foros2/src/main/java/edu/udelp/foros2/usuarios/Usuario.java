package edu.udelp.foros2.usuarios;

import java.util.ArrayList;



import javafx.beans.property.SimpleStringProperty;




public class Usuario {
	private SimpleStringProperty nombre;
	private SimpleStringProperty password;
	private SimpleStringProperty description;
	private SimpleStringProperty genero;
	private SimpleStringProperty email;
	private SimpleStringProperty fechaNacimiento;
	private SimpleStringProperty redesSociales;
	private SimpleStringProperty usuario;
	private SimpleStringProperty status;
	private ArrayList followers=new ArrayList();
	private ArrayList comunidades=new ArrayList();
	
	

	public SimpleStringProperty getNombreProperty() {
		return nombre;
	}

	public SimpleStringProperty getPasswordProperty() {
		return password;
	}

	public SimpleStringProperty getDescriptionProperty() {
		return description;
	}

	public SimpleStringProperty getGeneroProperty() {
		return genero;
	}

	public SimpleStringProperty getEmailProperty() {
		return email;
	}

	public SimpleStringProperty getFechaNacimientoProperty() {
		return fechaNacimiento;
	}

	public SimpleStringProperty getRedesSocialesProperty() {
		return redesSociales;
	}

	public SimpleStringProperty getUsuarioProperty() {
		return usuario;
	}

	public SimpleStringProperty getStatusProperty() {
		return status;
	}

	public ArrayList getFollowersProperty() {
		return followers;
	}

	public ArrayList getComunidadesProperty() {
		return comunidades;
	}

	public Usuario(String nombre, String password,String description,String genero, String email,
			String fechaNacimiento, String usuario, String status) {
		super();
		this.nombre = new SimpleStringProperty(nombre);
		this.password= new SimpleStringProperty(password);
		this.description= new SimpleStringProperty(description);
		this.genero= new SimpleStringProperty(genero);
		this.email = new SimpleStringProperty(email);
		this.fechaNacimiento= new SimpleStringProperty(fechaNacimiento);
		this.usuario= new SimpleStringProperty(usuario);
		this.status=new SimpleStringProperty(status);
		
		
	}

	
	
	
	
	
}
