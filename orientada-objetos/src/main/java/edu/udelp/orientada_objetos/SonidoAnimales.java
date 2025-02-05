package edu.udelp.orientada_objetos;

import edu.udelp.orientada_objetos.modelo.Animal;
import edu.udelp.orientada_objetos.modelo.Gato;
import edu.udelp.orientada_objetos.modelo.Perro;

public class SonidoAnimales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal a=new Animal();
		a.sonido();
		a=new Perro();
		a.sonido();
		a=new Gato();
		a.sonido();
	}

}
