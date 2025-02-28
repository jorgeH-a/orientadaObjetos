package edu.udelp.preguntas.hijos;

import edu.udelp.preguntas.padres.Persona;

public class Profesor extends Persona {
	double salario;

	public Profesor(String nombre, int edad,double salario) {
		super(nombre, edad);
		this.salario=salario;
		// TODO Auto-generated constructor stub
		
	}

	public void mostrarInformacion() {
		System.out.println("Nombre: "+nombre);
		System.out.println("Edad: "+edad);
		System.out.println("Salario: "+salario);
	}

	


}
