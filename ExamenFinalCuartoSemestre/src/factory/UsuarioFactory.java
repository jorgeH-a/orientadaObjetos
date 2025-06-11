package factory;

import usuarios.Usuario;
import usuarios.UsuarioEstandar;
import usuarios.UsuarioPremium;

public class UsuarioFactory {

    public static Usuario createUsuario(String tipo) {
        switch (tipo){
            case "Estandar":
                return new UsuarioEstandar();

            case "Premium":
                return new UsuarioPremium();

        }

        return null;
    }
}
