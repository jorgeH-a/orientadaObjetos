package edu.udelp.orientada_objetos.foro;

import java.util.Date;
import java.util.List;

public class Tema {
	private Long id;
	private String description;
	private String nombre;
	private Categoria categoria;
	private Usuario usuario;
	private Boolean nsfw;
	private Boolean plus18;
	private Date fecha;
	private List<Tags> tags;
	
}
