package edu.udelp.orientada_objetos.proceso;

import edu.udelp.orientada_objetos.modelo.Cuadrado;

public class CuadradoProcess extends FigurasProcess <Cuadrado>{

	@Override
	protected Double perimetro(Cuadrado figura) {
		
		return figura.getLado()*4;
	}

	@Override
	protected Double area(Cuadrado figura) {
		// TODO Auto-generated method stub
		return figura.getLado()*figura.getLado();
	}
	
}
