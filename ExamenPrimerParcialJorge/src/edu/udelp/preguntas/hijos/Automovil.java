package edu.udelp.preguntas.hijos;

import edu.udelp.preguntas.padres.Vehiculo;

public class Automovil extends Vehiculo {
	int numeroPuertas;
	public Automovil(String marca, String modelo, int año,int numeroPuertas) {
		super(marca, modelo, año);
		this.numeroPuertas=numeroPuertas;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mostrarDetalles() {
		System.out.println("Marca: "+marca);
		System.out.println("Modelo: "+modelo);
		System.out.println("Año: "+año);
		System.out.println("Numero de Puertas: "+numeroPuertas);
		
		
	}
	
}
