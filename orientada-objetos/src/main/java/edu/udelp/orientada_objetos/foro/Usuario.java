package edu.udelp.orientada_objetos.foro;

import java.util.Date;

import lombok.Data;

@Data
public class Usuario {
	private String nombre;
	private String password;
	private String description;
	private Enum genero;
	private String email;
	private Date fechaNacimiento;
	private String redesSociales;
	private Comunidad[] comunidades;
	private Usuario[] followers;
	private String usuario;
	private Enum status;
	
	
	
}
