package tipos;

public abstract class Package implements Cloneable {
protected int costo;
protected int peso;
protected int id;


	public void especificaciones(){
		System.out.println("El costo de este paquete es: " + costo);
		System.out.println("El peso de este paquete es: " + peso);
		System.out.println("El numero de serie de este paquete es: " + id);

	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
/*
	public Object clone(){
		return
	}
*/
}
