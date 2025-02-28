package edu.udelp.preguntas.hijos;

import edu.udelp.preguntas.padres.Vehiculo;

public class Motocicleta extends Vehiculo {
	String tipo;
	public Motocicleta(String marca, String modelo, int año,String tipo) {
		super(marca, modelo, año);
		this.tipo=tipo;
		// TODO Auto-generated constructor stub
	}
	public void mostrarDetalles() {
		System.out.println("Marca: "+marca);
		System.out.println("Modelo: "+modelo);
		System.out.println("Año: "+año);
		System.out.println("Tipo: "+tipo);
		
		
	}
}
