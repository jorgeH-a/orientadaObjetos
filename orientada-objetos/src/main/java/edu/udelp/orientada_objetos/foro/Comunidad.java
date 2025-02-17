package edu.udelp.orientada_objetos.foro;

import java.util.Date;

public class Comunidad {
	private Long id;
	private String nombre;
	private String description;
	private Date fechaCreacion;
	private String logo;
	private Usuario creador;
	private Boolean plus18;
	private Boolean nsfw;
	private Integer numPersonas;
	private Tags[] tags;
	
	
}
