import java.util.ArrayList;

import edu.udelp.preguntas.hijos.Estudiante;
import edu.udelp.preguntas.hijos.Profesor;

public class Curso {
String nombreCurso;
Profesor profesor;
ArrayList<Estudiante> listaEstudiantes=new ArrayList<>();

public Curso(String nombreCurso,Profesor profesor) {
	this.nombreCurso=nombreCurso;
	this.profesor=profesor;
}

public void agregarEstudiante(Estudiante estudiante){
	
	listaEstudiantes.add(estudiante);
	listaEstudiantes.get(0);
}
public void mostrarDetallesCurso() {
	int i=0;

	System.out.println("Nombre del curso: "+nombreCurso);
	System.out.println("Nombre del profesor: "+profesor.getNombre());
	System.out.println("Estudiantes en el curso:");
	do {
		System.out.println(listaEstudiantes.get(i).getNombre());
	i++;
	}while(listaEstudiantes.size()>i);
	
	
}


}
