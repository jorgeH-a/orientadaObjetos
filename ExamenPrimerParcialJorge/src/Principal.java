import edu.udelp.preguntas.hijos.Automovil;
import edu.udelp.preguntas.hijos.Estudiante;
import edu.udelp.preguntas.hijos.Motocicleta;
import edu.udelp.preguntas.hijos.Profesor;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] marca=new String[4];  String[] modelo=new String[4];String[] tipo=new String[4];
		int[] año=new int[4];   int[] puertas=new int[4];
		marca[0]="Toyota";marca[1]="Mazda";marca[2]="Chevrolet";marca[3]="Toyota";
		modelo[0]="23";modelo[1]="2";modelo[2]="5";modelo[3]="12";
		año[0]=2015;año[1]=2005;año[2]=2020;año[3]=2012;
		puertas[0]=4;puertas[1]=4;puertas[2]=2;puertas[3]=4;
		
	
			
		System.out.println("Automoviles");
		
		
			Automovil vehiculo=new Automovil(marca[0], modelo[0], año[0],puertas[0]);
			vehiculo.mostrarDetalles();
			vehiculo=new Automovil(marca[1], modelo[1], año[1],puertas[1]);
			vehiculo.mostrarDetalles();
			vehiculo=new Automovil(marca[2], modelo[2], año[2],puertas[2]);
			vehiculo.mostrarDetalles();
			vehiculo=new Automovil(marca[3], modelo[3], año[3],puertas[3]);
			vehiculo.mostrarDetalles();
		
			
			marca[0]="Toyota";marca[1]="Mazda";marca[2]="Chevrolet";marca[3]="Toyota";
			modelo[0]="23";modelo[1]="2";modelo[2]="5";modelo[3]="12";
			año[0]=2015;año[1]=2005;año[2]=2020;año[3]=2012;
			tipo[0]="Normal";tipo[1]="Scooter";tipo[2]="Scooter";tipo[3]="Carreras";
			System.out.println();
			System.out.println();
			System.out.println();
			
			System.out.println("Motos");
		Motocicleta moto=new Motocicleta(marca[0], modelo[0], año[0],tipo[0]);
		moto.mostrarDetalles();
		moto=new Motocicleta(marca[1], modelo[1], año[1],tipo[1]);
		moto.mostrarDetalles();
		moto=new Motocicleta(marca[2], modelo[2], año[2],tipo[2]);
		moto.mostrarDetalles();
		moto=new Motocicleta(marca[3], modelo[3], año[3],tipo[3]);
		moto.mostrarDetalles();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		Profesor prof=new Profesor("Joaquin", 26, 4000);
		
		prof.mostrarInformacion();
		System.out.println();
		Estudiante est=new Estudiante("Antonio", 20, 7);
		
		est.mostrarInformacion();
		
		System.out.println();
		System.out.println();
		
		prof=new Profesor("Joaquin", 26, 4000);
		Curso cursoUno=new Curso("Matematicas", prof);
		
		est=new Estudiante("Antonio", 20, 7);
		cursoUno.agregarEstudiante(est);
		
		est=new Estudiante("Josue", 23, 8);
		cursoUno.agregarEstudiante(est);
		
		est=new Estudiante("Luis", 20, 8.2);
		cursoUno.agregarEstudiante(est);
		
		cursoUno.mostrarDetallesCurso();
		
		System.out.println();
		System.out.println();
		prof=new Profesor("Toño", 30, 5000);
		Curso cursoDos=new Curso("Historia", prof);
		
		
		est=new Estudiante("Guz",19, 7.5);
		cursoDos.agregarEstudiante(est);
		
		est=new Estudiante("Diego", 22, 9);
		cursoDos.agregarEstudiante(est);
		
		est=new Estudiante("Xavi", 28, 8.4);
		cursoDos.agregarEstudiante(est);
		
		cursoDos.mostrarDetallesCurso();;
		
		
	}

}
