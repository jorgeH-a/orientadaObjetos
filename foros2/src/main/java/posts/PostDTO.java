package posts;


import usuarios.Usuario;
import usuarios.UsuarioDTO;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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
        private boolean comunidad;
        private ArrayList tags=new ArrayList();

        public PostDTO(long id, UsuarioDTO user, String descripcion, String imagen, String archivo, String fecha, boolean nsfw, boolean plus18, PostDTO originalPost){
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

        public boolean isComunidad() {
                return comunidad;
        }

        public ArrayList getTags() {
                return tags;
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

        public void setComunidad(boolean comunidad) {
                this.comunidad = comunidad;
        }

        public void setTags(ArrayList tags) {
                this.tags = tags;
        }

        public Long getCalificacionesMalas() {
                return calificacionesMalas;
        }

        public void setCalificacionesMalas(Long calificacionesMalas) {
                this.calificacionesMalas = calificacionesMalas;
        }
}
