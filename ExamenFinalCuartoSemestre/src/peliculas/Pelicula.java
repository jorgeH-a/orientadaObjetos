package peliculas;

public class Pelicula {

protected String titulo;
protected int año;
protected String genero;
protected int clasificacion;

    public Pelicula(String titulo, int año, int clasificacion, String genero) {
        this.titulo = titulo;
        this.año = año;
        this.clasificacion = clasificacion;
        this.genero = genero;
    }

    public int getAño() {
        return año;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getClasificacion() {
        return clasificacion;
    }
}
