package edu.udelp.orientada_objetos.proceso;

import edu.udelp.orientada_objetos.modelo.Circulo;


public class CirculoProcess extends FigurasProcess <Circulo>{
	@Override
	protected Double perimetro(Circulo figura) {
		
		return Math.PI*figura.getRadio()*2;
	}

	@Override
	protected Double area(Circulo figura) {
		// TODO Auto-generated method stub
		return Math.PI*figura.getRadio()*figura.getRadio();
	}
	
}
