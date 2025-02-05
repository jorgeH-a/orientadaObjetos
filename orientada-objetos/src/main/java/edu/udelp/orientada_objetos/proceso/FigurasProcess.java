package edu.udelp.orientada_objetos.proceso;

public abstract class FigurasProcess <T>{
	//metodo abstractos, metodos sin implemetar
	//no se pueden creer metodos privados
	
	public void calcula(T figura) {
		System.out.println("El perimetro es:"+perimetro(figura));
		System.out.println("El area es:"+area(figura));

	}
	protected abstract Double perimetro (T figura);
	protected abstract Double area (T figura);
	
	
}
