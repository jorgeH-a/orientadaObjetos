package posts;



import comunidad.ComunidadDTO;
import tags.TagsDTO;
import usuarios.UsuarioDTO;
import java.util.ArrayList;


public class PostDTO {

        public long id;
        private UsuarioDTO usuario;
        private String descripcion;
        private String imagen;
        private PostDTO originalPost;
        private String archivo;
        private String fecha;
        private Long calificacionesBuenas;
        private Long calificacionesMalas;
        //private ArrayList calificaciones=new ArrayList();
        private boolean nsfw;
        private boolean plus18;
        private ComunidadDTO comunidadDTO;
        private ArrayList<TagsDTO> tagsDTO=new ArrayList<>();
        private ArrayList<String> comentarios=new ArrayList<>();

        public PostDTO(long id,ComunidadDTO comunidadDTO, UsuarioDTO user, String descripcion, String imagen, String archivo,
                       String fecha, boolean nsfw, boolean plus18, PostDTO originalPost,ArrayList<TagsDTO> tagsDTO) {
            super();
                this.id=id;
                this.comunidadDTO=comunidadDTO;
                this.usuario=user;
                this.descripcion=descripcion;
                this.imagen=imagen;
                this.archivo=archivo;
                this.fecha=fecha;
                this.nsfw=nsfw;
                this.plus18=plus18;
                this.originalPost=originalPost;
                this.tagsDTO=tagsDTO;

        }
        /*
        public PostDTO(long id, UsuarioDTO user, String descripcion, String imagen, String archivo,
                       String fecha, boolean nsfw, boolean plus18, PostDTO originalPost) {
                super();
                this.id=id;
                this.usuario=user;
                this.descripcion=descripcion;
                this.imagen=imagen;
                this.archivo=archivo;
                this.fecha=fecha;
                this.nsfw=nsfw;
                this.plus18=plus18;
                this.originalPost=originalPost;


        }
        */

        public long getId() {
                return id;
        }

        public UsuarioDTO getUsuarioDTO() {
                return usuario;
        }

        public String getDescripcion() {
                return descripcion;
        }

        public String getImagen() {
                return imagen;
        }
        public PostDTO getOriginalPost() {
                return originalPost;
        }

        public String getArchivo() {
                return archivo;
        }

        public String getFecha() {
                return fecha;
        }

        public Long getCalificacionesBuenas() {
                return calificacionesBuenas;
        }

        public boolean isNsfw() {
                return nsfw;
        }

        public boolean isPlus18() {
                return plus18;
        }

        public ComunidadDTO isComunidad() {
                return comunidadDTO;
        }

        public ArrayList<TagsDTO> getTags() {
                return tagsDTO;
        }

        public void setId(long id) {
                this.id = id;
        }

        public void setUsuarioDTO(UsuarioDTO usuario) {
                this.usuario = usuario;
        }

        public void setDescripcion(String descripcion) {
                this.descripcion = descripcion;
        }

        public void setImagen(String imagen) {
                this.imagen = imagen;
        }

        public void setOriginalPost(PostDTO originalPost) {
                this.originalPost = originalPost;
        }

        public void setArchivo(String archivo) {
                this.archivo = archivo;
        }

        public void setFecha(String fecha) {
                this.fecha = fecha;
        }

        public void setCalificacionesBuenas(Long calificacionesBuenas) {
                this.calificacionesBuenas = calificacionesBuenas;
        }

        public void setNsfw(boolean nsfw) {
                this.nsfw = nsfw;
        }

        public void setPlus18(boolean plus18) {
                this.plus18 = plus18;
        }

        public ComunidadDTO getComunidadDTO() {
                return comunidadDTO;
        }

        public void setComunidad(ComunidadDTO comunidad) {
                this.comunidadDTO = comunidad;
        }

        public void setTags(ArrayList<TagsDTO> tagsDTO) {
                this.tagsDTO = tagsDTO;
        }

        public Long getCalificacionesMalas() {
                return calificacionesMalas;
        }

        public void setCalificacionesMalas(Long calificacionesMalas) {
                this.calificacionesMalas = calificacionesMalas;
        }

        public ArrayList<String> getComentarios() {
                return comentarios;
        }

        public void setComentarios(ArrayList comentarios) {
                this.comentarios = comentarios;
        }
}
