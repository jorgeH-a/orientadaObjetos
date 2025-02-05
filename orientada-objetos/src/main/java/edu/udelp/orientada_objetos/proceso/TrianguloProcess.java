package edu.udelp.orientada_objetos.proceso;

import edu.udelp.orientada_objetos.modelo.Triangulo;

public class TrianguloProcess {
	public Double perimetro(Triangulo Triangulo) {
		return Triangulo.getLado()+Triangulo.getLado1()+Triangulo.getLado2();
		
	}
	
	public Double area(Triangulo triangulo) {
		return (triangulo.getLado()*triangulo.getAltura())/2;
	}
}
