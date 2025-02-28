package edu.udelp.preguntas.padres;

public class Persona {
	protected String nombre;
	protected int edad;
	
	public Persona(String nombre,int edad) {
		this.nombre=nombre;
		this.edad=edad;
	}
	
	public void mostrarInformacion() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
	
}
