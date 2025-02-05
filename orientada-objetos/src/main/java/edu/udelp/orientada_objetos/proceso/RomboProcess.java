package edu.udelp.orientada_objetos.proceso;

import edu.udelp.orientada_objetos.modelo.Rombo;

public class RomboProcess {
	public Double perimetro(Rombo rombo) {
		return rombo.getLado()*4;
		
	}
	
	public Double area(Rombo rombo) {
		return (rombo.getMayor()*rombo.getMenor())/2;
	}
}
