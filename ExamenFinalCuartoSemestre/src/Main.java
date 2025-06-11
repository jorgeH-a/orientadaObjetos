import factory.UsuarioFactory;
import peliculas.CatalogoPeliculas;
import peliculas.Pelicula;
import usuarios.Usuario;
import usuarios.UsuarioBuilder;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*

        Datos usuarios

        String nombre;
        int edad;
        String genero;
        String tipoUsuario;
        ArrayList<String> peliculas;

        Datos peliculas

        protected String titulo;
        int año;
        String genero;
        int clasificacion;

         */


        ArrayList<String> peliculas = new ArrayList<>();


        Pelicula shkrek = new Pelicula("Shrek",2005,8,"Fantasia");
        Pelicula islaDelTesoro = new Pelicula("Isla Del Tesoro",2004,6,"Fantasia/Acción");
        Pelicula jimmyWick = new Pelicula("Jimmy Wick 3",2018,9,"Acción");
        Pelicula comoDomarTuCaballo = new Pelicula("Como Domar Tu Caballo",2012,10,"Aventuras/Accion");
        Pelicula perroConPantalones = new Pelicula("Perro Con Pantalones",2020,7,"Fantasia/Accion/Aventuras");

        CatalogoPeliculas.getInstance().add(shkrek.getTitulo(),shkrek);
        CatalogoPeliculas.getInstance().add(islaDelTesoro.getTitulo(),islaDelTesoro);
        CatalogoPeliculas.getInstance().add(jimmyWick.getTitulo(),jimmyWick);
        CatalogoPeliculas.getInstance().add(comoDomarTuCaballo.getTitulo(),comoDomarTuCaballo);
        CatalogoPeliculas.getInstance().add(perroConPantalones.getTitulo(),perroConPantalones);





        String estandar="Estandar";
        String premium="Premium";


        Usuario jose=UsuarioFactory.createUsuario(estandar);

        jose.setNombre("Jose");
        jose.setEdad(25);
        jose.setGenero("Masculino");
        jose.setTipoUsuario(estandar);



        Usuario julia = UsuarioFactory.createUsuario(premium);
        julia.setNombre("Julia");
        julia.setEdad(20);
        julia.setGenero("Femenino");
        julia.setTipoUsuario(premium);

        peliculas.add(CatalogoPeliculas.getInstance().get("Shrek").getTitulo());
        peliculas.add(CatalogoPeliculas.getInstance().get("Isla Del Tesoro").getTitulo());
        peliculas.add(CatalogoPeliculas.getInstance().get("Jimmy Wick 3").getTitulo());
        peliculas.add(CatalogoPeliculas.getInstance().get("Como Domar Tu Caballo").getTitulo());
        peliculas.add(CatalogoPeliculas.getInstance().get("Perro Con Pantalones").getTitulo());

        julia.setPeliculas(peliculas);
        System.out.println();
        System.out.println();

        julia.verContenido();
        System.out.println();
        System.out.println();
        peliculas.clear();

        peliculas.add(CatalogoPeliculas.getInstance().get("Shrek").getTitulo());
        peliculas.add(CatalogoPeliculas.getInstance().get("Isla Del Tesoro").getTitulo());
        peliculas.add(CatalogoPeliculas.getInstance().get("Jimmy Wick 3").getTitulo());

        jose.setPeliculas(peliculas);
        System.out.println();
        System.out.println();
        jose.verContenido();
        peliculas.clear();















    }


}










































