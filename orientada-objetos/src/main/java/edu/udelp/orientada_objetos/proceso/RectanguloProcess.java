package edu.udelp.orientada_objetos.proceso;

import edu.udelp.orientada_objetos.modelo.Rectangulo;

public class RectanguloProcess implements IFiguraProcess<Rectangulo> {
	
	@Override
	public Double perimetro(Rectangulo figura) {
		return figura.getLadoGrande()*2+figura.getLado()*2;
	}
	@Override
	public Double area(Rectangulo figura) {
		return figura.getLadoGrande()*figura.getLado();
	}
}
