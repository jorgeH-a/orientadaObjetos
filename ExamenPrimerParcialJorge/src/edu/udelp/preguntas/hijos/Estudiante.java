package edu.udelp.preguntas.hijos;

import edu.udelp.preguntas.padres.Persona;

public class Estudiante extends Persona {
	double promedio;
	public Estudiante(String nombre, int edad,double promedio) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
		this.promedio=promedio;
	}
	
	public void mostrarInformacion() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Edad: "+edad);
		System.out.println("Promedio: "+promedio);
	}

}
