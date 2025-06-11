package usuarios;

import java.util.ArrayList;

public class UsuarioBuilder {

    private static Usuario usuario;
    public static UsuarioBuilder create(String tipo) {
        usuario=new Usuario();
        return new UsuarioBuilder();

    }

    public Usuario build() {return usuario;}

    public static Usuario tipoUsuario(String tipo) {
        switch (tipo){
            case "Estandar":
                return new UsuarioEstandar();

            case "Premium":
                return new UsuarioPremium();

        }

        return null;
    }

    public UsuarioBuilder nombre(String nombre) {
        usuario.setNombre(nombre);
        return this;
    }


    public UsuarioBuilder edad(int edad) {
        usuario.setEdad(edad);
        return this;
    }

    public UsuarioBuilder genero(String genero) {
        usuario.setGenero(genero);
        return this;
    }



    public UsuarioBuilder peliculas(ArrayList<String> peliculas) {
        usuario.setPeliculas(peliculas);
        return this;
    }





















}
