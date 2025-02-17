package edu.udelp.orientada_objetos.foro;

import java.util.Date;

public class Post {
	private Long id;
	private Usuario usuario;
	private String description;
	private String imagen;
	private Post originalPost;
	private String archivo;
	private Date fecha;
	private CalificacionUsuario[] calificaciones;
	private Boolean nsfw;
	private Boolean plus18;
	private Comunidad comunidad;
	private Tags[] tags;
	
	
	
	
}
