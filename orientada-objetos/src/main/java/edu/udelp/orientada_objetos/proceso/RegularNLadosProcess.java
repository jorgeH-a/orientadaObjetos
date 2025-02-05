package edu.udelp.orientada_objetos.proceso;

import edu.udelp.orientada_objetos.modelo.RegularNLados;

public class RegularNLadosProcess implements IFiguraProcess<RegularNLados> {
	@Override
	public Double perimetro(RegularNLados figura) {
		return figura.getLado()*figura.getN();
		
	}
	@Override
	public Double area(RegularNLados figura) {
		return (perimetro(figura)*figura.getA())/2;
	}
}
