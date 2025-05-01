package posts;

import comunidad.Comunidad;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;

import javafx.beans.property.SimpleStringProperty;
import tags.Tags;
import usuarios.Usuario;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Post {
    private final long id;

    private final Usuario usuario;
    private final SimpleStringProperty descripcion;
    private final SimpleStringProperty imagen;
    private Post originalPost;
    private final SimpleStringProperty archivo;
    private final SimpleStringProperty fecha;
    private final ArrayList<CalificacionUsuario> calificaciones=new ArrayList();
    private final SimpleBooleanProperty nsfw;
    private final SimpleBooleanProperty plus18;
    private Comunidad comunidad;
    private ArrayList<Tags> tags = new ArrayList<>();



    public long getIdProperty() {
        return id;
    }

    public Usuario getUsuarioPost() {
        return usuario;
    }

    public SimpleStringProperty getDescripcionProperty() {
        return descripcion;
    }

    public SimpleStringProperty getImagenProperty() {
        return imagen;
    }

    public Post getOriginalPost() {
        return originalPost;
    }

    public SimpleStringProperty getArchivoProperty() {
        return archivo;
    }

    public SimpleStringProperty getFechaProperty() {
        return fecha;
    }

    public ArrayList<CalificacionUsuario> getCalificaciones() {
        return calificaciones;
    }

    public SimpleBooleanProperty getNsfwProperty() {
        return nsfw;
    }

    public SimpleBooleanProperty getPlus18Property() {
        return plus18;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public Post (long id, Usuario user, String descripcion, String imagen, String archivo, String fecha, boolean nsfw, boolean plus18){
        super();

        this.id=id;
        this.usuario=user;
        this.descripcion=new SimpleStringProperty(descripcion);
        this.imagen=new SimpleStringProperty(imagen);
        this.archivo=new SimpleStringProperty(archivo);
        this.fecha=new SimpleStringProperty(fecha);
        this.nsfw=new SimpleBooleanProperty(nsfw);
        this.plus18=new SimpleBooleanProperty(plus18);



    }





}
