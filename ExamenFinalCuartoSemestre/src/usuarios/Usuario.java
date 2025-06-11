package usuarios;

import peliculas.CatalogoPeliculas;
import peliculas.Pelicula;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Usuario {

    protected String nombre;
    protected int edad;
    protected String genero;
    protected String tipoUsuario;
    protected ArrayList<String> peliculas;




    public void verContenido(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Edad: "+edad);
        System.out.println("Genero: "+genero);
        System.out.println("Tipo: "+tipoUsuario);
        System.out.println("Lista de contenidos: ");

        if(tipoUsuario.equals("Estandar")){
            System.out.println(CatalogoPeliculas.getInstance().get("Shrek").getTitulo());
            System.out.println(CatalogoPeliculas.getInstance().get("Isla Del Tesoro").getTitulo());
            System.out.println(CatalogoPeliculas.getInstance().get("Jimmy Wick 3").getTitulo());

        }
        if(tipoUsuario.equals("Premium")){
            System.out.println(CatalogoPeliculas.getInstance().get("Shrek").getTitulo());
            System.out.println(CatalogoPeliculas.getInstance().get("Isla Del Tesoro").getTitulo());
            System.out.println(CatalogoPeliculas.getInstance().get("Jimmy Wick 3").getTitulo());
            System.out.println(CatalogoPeliculas.getInstance().get("Como Domar Tu Caballo").getTitulo());
            System.out.println(CatalogoPeliculas.getInstance().get("Perro Con Pantalones").getTitulo());
        }
        System.out.println();
        System.out.println();
        System.out.println("Peliculas vistas: ");
        for (String pelicula : peliculas) {
            System.out.println(pelicula);
        }
        peliculas.clear();

    }
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String usuario) {
        this.tipoUsuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }



    public ArrayList<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<String> peliculas) {
        this.peliculas = peliculas;
    }


    public Usuario build() {
        return null;
    }
}
