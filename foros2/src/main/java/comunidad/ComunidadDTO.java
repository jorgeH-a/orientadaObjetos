package comunidad;




import tags.TagsDTO;
import usuarios.UsuarioDTO;

import java.util.ArrayList;

public class ComunidadDTO {

    public long id;
    private String nombre;
    private String descripcion;
    private String fecha;
    private String logo;
    private UsuarioDTO usuario;
    private boolean nsfw;
    private boolean plus18;
    public int numPersonas;
    private ArrayList<TagsDTO> tagsDTO = new ArrayList<>();
    private ArrayList<String> seguidores = new ArrayList<>();

    public ComunidadDTO(long id,String nombre, UsuarioDTO usuario, String descripcion, String fecha, String logo, boolean nsfw, boolean plus18,ArrayList<TagsDTO> tagsDTO) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.logo = logo;
        this.nsfw=nsfw;
        this.plus18=plus18;
        this.tagsDTO=tagsDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public boolean isPlus18() {
        return plus18;
    }

    public void setPlus18(boolean plus18) {
        this.plus18 = plus18;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public ArrayList<TagsDTO> getTagsDTO() {
        return tagsDTO;
    }

    public ArrayList<String> getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(ArrayList<String> seguidores) {
        this.seguidores = seguidores;
    }
}
