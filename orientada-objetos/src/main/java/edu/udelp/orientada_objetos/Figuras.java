package edu.udelp.orientada_objetos;
import edu.udelp.orientada_objetos.modelo.Circulo;
import edu.udelp.orientada_objetos.modelo.Cuadrado;
import edu.udelp.orientada_objetos.modelo.Rectangulo;
import edu.udelp.orientada_objetos.modelo.RegularNLados;
import edu.udelp.orientada_objetos.proceso.CirculoProcess;
import edu.udelp.orientada_objetos.proceso.CuadradoProcess;
import edu.udelp.orientada_objetos.proceso.RectanguloProcess;
import edu.udelp.orientada_objetos.proceso.RegularNLadosProcess;
//lombok
import lombok.Data;


public class Figuras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado cu=new Cuadrado();
		CuadradoProcess c=new CuadradoProcess();
		Circulo ci=new Circulo();
		CirculoProcess cir=new CirculoProcess();
		Rectangulo re=new Rectangulo();
		RectanguloProcess r=new RectanguloProcess();
		RegularNLados reN=new RegularNLados();
		RegularNLadosProcess rN=new RegularNLadosProcess();
		
		cu.setLado(3D);
		c.calcula(cu);
		
		ci.setRadio(4D);
		cir.calcula(ci);
		
		re.setLado(2D);
		re.setLadoGrande(5D);
		r.calcula(re);
		
		reN.setA(4D);
		reN.setLado(5D);
		reN.setN(5D);
		rN.calcula(reN);
		
	}
	
	
	
}
