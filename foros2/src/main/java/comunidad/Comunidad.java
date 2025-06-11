package comunidad;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import tags.Tags;
import tags.TagsDTO;
import usuarios.Usuario;

import java.util.ArrayList;

public class Comunidad {

    public final long id;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty descripcion;
    private final SimpleStringProperty fecha;
    private final SimpleStringProperty logo;
    private final Usuario usuario;
    private final SimpleBooleanProperty nsfw;
    private final SimpleBooleanProperty plus18;
    public int numPersonas;
    private  ArrayList<Tags> tags = new ArrayList<>();
    private ArrayList<String> seguidores = new ArrayList<>();


    public long getId() {
        return id;
    }

    public SimpleStringProperty descripcionProperty() {
        return descripcion;
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public long getIdProperty() {
        return id;
    }

    public SimpleStringProperty getNombreProperty() {
        return nombre;
    }



    public boolean isNsfw() {
        return nsfw.get();
    }

    public SimpleBooleanProperty nsfwProperty() {
        return nsfw;
    }

    public boolean isPlus18() {
        return plus18.get();
    }

    public SimpleBooleanProperty plus18Property() {
        return plus18;
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public SimpleStringProperty getDescripcionProperty() {
        return descripcion;
    }

    public String getFecha() {
        return fecha.get();
    }

    public SimpleStringProperty getFechaProperty() {
        return fecha;
    }



    public SimpleStringProperty getLogoProperty() {
        return logo;
    }

    public Usuario getUsuario() {
        return usuario;
    }



    public SimpleBooleanProperty getNsfwProperty() {
        return nsfw;
    }



    public SimpleBooleanProperty getPlus18Property() {
        return plus18;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public ArrayList<String> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(ArrayList<String> seguidores) {
        this.seguidores = seguidores;
    }

    public Comunidad(long id, String nombre, Usuario usuario, String descripcion, String fecha, String logo, boolean nsfw, boolean plus18,ArrayList<Tags> tags) {
        super();
        this.id = id;
        this.nombre = new SimpleStringProperty(nombre);
        this.usuario = usuario;
        this.descripcion = new SimpleStringProperty(descripcion);
        this.fecha = new SimpleStringProperty(fecha);
        this.logo = new SimpleStringProperty(logo);
        this.nsfw=new SimpleBooleanProperty(nsfw);
        this.plus18=new SimpleBooleanProperty(plus18);
        this.tags=tags;
    }


}
