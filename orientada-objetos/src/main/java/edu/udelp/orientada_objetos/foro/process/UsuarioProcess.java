package edu.udelp.orientada_objetos.foro.process;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.udelp.orientada_objetos.foro.Usuario;
import java.util.regex.Pattern;

/*
Se tiene que acceder al getUsuario por medio de listUsuario, para luego acceder a los usuarios
con el metodo buscarUsuario basta

 */
public class UsuarioProcess {
	
	private Scanner leer=new Scanner(System.in);
	ArrayList<Usuario> listUsuario=new ArrayList<>();
	ArrayList<Usuario> followers=new ArrayList<>();
	ArrayList<Usuario> bloqueados=new ArrayList<>();
	private String NOMBRE_REGEX="^[a-zA-Z]+$";
	private String USUARIO_REGEX="^.+$";
	private String EMAIL_REGEX="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	private String PASSWORD_REGEX="^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d)(?=.*[@$#]).{8,}$";
	
	
	public void registrar() {
		Usuario u=new Usuario();
		String newUser=null;
		String email=null;
		String nombre=null;
		String password=null;
		String descripcion=null;
		int elegirG=9;
		Genero genero=null;
		Estatus est=null;
		String fechaStr=null;
		Date fecha = null;
		
		do {
			System.out.println("Introduzca su email");
			email=leer.nextLine();
			if(!validarEmail(email)) {
				System.out.println("El correo es invalido, porfavor usa un correo valido");
			}
			if(emailExiste(email)) {
				System.out.println("Este email ya existe, porfavor prueba con otro correo");
			}
			
		}while(!validarEmail(email)||emailExiste(email));
		u.setEmail(email);
		
		do {
			System.out.println("Introduzca su nombre");
			nombre=leer.nextLine();
			if(!validarNombre(nombre)) {
				System.out.println("Porfavor usa un nombre valido");
			}
			
		}while(!validarNombre(nombre));
		u.setNombre(nombre);
		
		do {
			System.out.println("Dame el usuario");
			newUser=leer.nextLine();
				if(usuarioExiste(newUser)) {
					System.out.println("Este usuario ya exite, prueba con otro");
				}
				if(!validarUsuario(newUser)) {
					System.out.println("Porfavor da un usuario valido");
				}
			
		}while(usuarioExiste(newUser)||!validarUsuario(newUser));
		u.setUsuario(newUser);
		
		do {
			System.out.println("Dame una contraseña");
			password=leer.nextLine();
			
			if(validarPassword(password)) {
				System.out.println("Contraseña invalida, porfavor ponga una valida");
			}
			
		}while(validarPassword(password));
		u.setPassword(password);
		
		do {
			System.out.println("Introduzca su genero"
					+ "\n1: Masculino"
					+ "\n2: Femenino"
					+ "\n3: Otro");
			elegirG=leer.nextInt();
			leer.nextLine();
			switch(elegirG) {
			case 1:
				u.setGenero(genero.MASCULINO);
				break;
			case 2:
				u.setGenero(genero.FEMENINO);
				break;
			case 3:
				u.setGenero(genero.OTRO);
				break;
			default:
				System.out.println("No es una opcion");
				break;
			}
		}while(elegirG!=1&&elegirG!=2&&elegirG!=3);
		
		do {
		System.out.println("Ingrese su fecha de nacimiento(DD/MM/YYYY)");
		fechaStr=leer.nextLine();
		
		
		//Sacado de chatgpt
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 formato.setLenient(false);
	        try {
	            fecha=formato.parse(fechaStr);
	            System.out.println(fecha);
	        } catch (ParseException e) {
	            System.out.println("Fecha no valida");
	            fecha = null;
	        }
		}while(fecha==null);
		u.setFechaNacimiento(fecha);
		
		
		System.out.println("Introduzca una descripcion");
		descripcion=leer.nextLine();
		u.setDescription(descripcion);
		
		u.setStatus(est.Activo);
		listUsuario.add(u);
		
	}
	
	
	public boolean validarEmail(String email) {
		
		return Pattern.matches(EMAIL_REGEX, email);
	}
	public boolean emailExiste(String email) {
		
		for(int i=0;i<listUsuario.size();i++) {
			
			if(listUsuario.get(i).getEmail().equals(email)) {
				return true;
			}
			
		}
		
		return false;
	}
	public boolean validarNombre(String nombre) {
		
		return Pattern.matches(NOMBRE_REGEX, nombre);
	}
	public boolean validarUsuario(String usuario) {
		
		return Pattern.matches(USUARIO_REGEX, usuario);
	}
	public boolean usuarioExiste(String usuario) {
		
		for(int i=0;i<listUsuario.size();i++) {
			
			if(listUsuario.get(i).getUsuario().equals(usuario)) {
				return true;
			}
		}
		
		return false;
	}
	public boolean validarPassword(String password) {
		
		return Pattern.matches(PASSWORD_REGEX, password);
	}
	enum Genero {
	    MASCULINO,FEMENINO,OTRO
	}
	enum Estatus{
		Activo,Desactivado
	}
	
	public void editar(String nombreUsuario) {
		
		Usuario u=new Usuario();
		int eleccion=0;
		String nombre=null;
		String usuario=null;
		String email=null;
		String password=null;
		String descripcion=null;
		int elegirG=9;
		Genero genero=null;
		u=buscarUsuario(nombreUsuario);
		System.out.println("¿Que quieres editar?"
				+ "\n1: Nombre"
				+ "\n2: Usuario"
				+ "\n3: Email"
				+ "\n4: Password"
				+ "\n5: Descripcion"
				+ "\n6: Genero");
		eleccion=leer.nextInt();
		switch(eleccion) {
		case 1:
			do {
				System.out.println("Introduzca el nombre nuevo");
				nombre=leer.nextLine();
				if(!validarNombre(nombre)) {
					System.out.println("Porfavor usa un nombre valido");
				}
				
			}while(!validarNombre(nombre));
			u.setNombre(nombre);
			break;
		case 2:
			
			do {
				System.out.println("Introduzca nuevo usuario");
				usuario=leer.nextLine();
					if(usuarioExiste(usuario)) {
						System.out.println("Este usuario ya exite, prueba con otro");
					}
					if(!validarUsuario(usuario)) {
						System.out.println("Porfavor da un usuario valido");
					}
				
			}while(usuarioExiste(usuario)||!validarUsuario(usuario));
			u.setUsuario(usuario);
			
			break;
		case 3:
			do {
				System.out.println("Introduzca su nuevo email");
				email=leer.nextLine();
				if(!validarEmail(email)) {
					System.out.println("El correo es invalido, porfavor usa un correo valido");
				}
				if(emailExiste(email)) {
					System.out.println("Este email ya existe, porfavor prueba con otro correo");
				}
				
			}while(!validarEmail(email)||emailExiste(email));
			u.setEmail(email);
			
			break;
		case 4:
			do {
				System.out.println("Dame una contraseña");
				password=leer.nextLine();
				
				if(validarPassword(password)) {
					System.out.println("Contraseña invalida, porfavor ponga una valida");
				}
				
			}while(validarPassword(password));
			u.setPassword(password);
			
			break;
		case 5:
			System.out.println("Introduzca una nueva descripcion");
			descripcion=leer.nextLine();
			u.setDescription(descripcion);
			break;
		case 6:
			do {
				System.out.println("Introduzca un nuevo genero"
						+ "\n1: Masculino"
						+ "\n2: Femenino"
						+ "\n3: Otro");
				elegirG=leer.nextInt();
				switch(elegirG) {
				case 1:
					u.setGenero(genero.MASCULINO);
					break;
				case 2:
					u.setGenero(genero.FEMENINO);
					break;
				case 3:
					u.setGenero(genero.OTRO);
					break;
				default:
					System.out.println("No es una opcion");
					break;
				}
			}while(elegirG!=1&&elegirG!=2&&elegirG!=3);
			
			break;
		default:
			System.out.println("No es una opcion");
			break;

		}


	}
	
	public void darBaja() {
		Estatus est=null;
		String usuario=null;
		String password=null;
		System.out.println("Introduzca su usuario");
		usuario=leer.nextLine();
		System.out.println("Introduzca su contraseña");
		password=leer.nextLine();
		for(int i=0;i<listUsuario.size();i++) {
			if(listUsuario.get(i).getUsuario().equals(usuario)) {
				if(listUsuario.get(i).getPassword().equals(password)) {
					listUsuario.get(i).setStatus(Estatus.Desactivado);
				}
			}
		}
	}
	
	public boolean login() {
		String usuario=null;
		String password=null;
		System.out.println("Introduzca su usuario");
		usuario=leer.nextLine();
		System.out.println("Introduzca su contraseña");
		password=leer.nextLine();
		for(int i=0;i<listUsuario.size();i++) {
			if(listUsuario.get(i).getUsuario().equals(usuario)) {
				if(listUsuario.get(i).getPassword().equals(password)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void follow(String nombreUsuario) {
		Usuario u=new Usuario();
		if(null==buscarFollows(nombreUsuario)) {
			u=buscarUsuario(nombreUsuario);
			if(null!=u) {
				followers.add(u);
			}
			
		}
		
	}
	
	public void unfollow(String nombreUsuario) {
		Usuario u=new Usuario();
		u=buscarFollows(nombreUsuario);
		if(null!=u) {
			followers.remove(u);
		}
	}
	
	public void bloquear(String nombreUsuario) {
		Usuario u=new Usuario();
		u=buscarUsuario(nombreUsuario);
		if(null==buscarBloqueados(nombreUsuario)) {
			bloqueados.add(u);
		}
	}
	
	public Usuario buscarUsuario(String nombreUsuario) {
		for(int i=0;i<listUsuario.size();i++) {
			if(listUsuario.get(i).getUsuario().equals(nombreUsuario)) {
				return listUsuario.get(i);
			}
			
		}
		return null;
	}
	public Usuario buscarFollows(String nombreUsuario) {
		for(int i=0;i<followers.size();i++) {
			if(followers.get(i).getUsuario().equals(nombreUsuario)) {
				return followers.get(i);
			}
			
		}
		return null;
	}
	public Usuario buscarBloqueados(String nombreUsuario) {
		for(int i=0;i<bloqueados.size();i++) {
			if(bloqueados.get(i).getUsuario().equals(nombreUsuario)) {
				return bloqueados.get(i);
			}
			
		}
		return null;
	}
}
