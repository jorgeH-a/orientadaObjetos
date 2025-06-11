package peliculas;

import java.util.HashMap;
import java.util.Map;

public class CatalogoPeliculas {

    private static CatalogoPeliculas instance=null;
    public final Map<String, Pelicula> peliculas=new HashMap<>();
    private CatalogoPeliculas() {}

    public static CatalogoPeliculas getInstance() {
        if(instance==null) {
            instance=new CatalogoPeliculas();
        }
        return instance;
    }

    public void add(String titulo, Pelicula pelicula) {this.peliculas.put(titulo,pelicula);}
    public Pelicula get(String titulo) {
        return peliculas.get(titulo);
    }


}
