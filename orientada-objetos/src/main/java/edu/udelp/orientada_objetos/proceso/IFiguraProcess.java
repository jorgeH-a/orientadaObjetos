package edu.udelp.orientada_objetos.proceso;

public interface IFiguraProcess<T> {
	public default void calcula(T figura) {
		System.out.println("El perimetro es:"+perimetro(figura));
		System.out.println("El area es:"+area(figura));

	}
	Double perimetro (T figura);
	Double area (T figura);
}
