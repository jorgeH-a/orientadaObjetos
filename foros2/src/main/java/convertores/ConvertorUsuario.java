package convertores;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controllers.RegistroController;
import usuarios.Usuario;
import usuarios.UsuarioDTO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ConvertorUsuario {

    public static ArrayList<UsuarioDTO> listUsuarioDTO=new ArrayList<>();

    static String rutaArchivoUsuario = "archivoUsuarios";
    public static void conversorSimpleStringUsuario(){
        for (int i = 0; i < RegistroController.getListUsuario().size(); i++){
            String nombre = RegistroController.getListUsuario().get(i).getNombreProperty().get();
            String password =RegistroController.getListUsuario().get(i).getPasswordProperty().get();
            String description = RegistroController.getListUsuario().get(i).getDescriptionProperty().get();
            String genero =RegistroController.getListUsuario().get(i).getGeneroProperty().get();
            String email =RegistroController.getListUsuario().get(i).getEmailProperty().get();
            String fechaNacimiento =RegistroController.getListUsuario().get(i).getFechaNacimientoProperty().get();
            String usuarioStr = RegistroController.getListUsuario().get(i).getUsuarioProperty().get();
            String status =RegistroController.getListUsuario().get(i).getStatusProperty().get();
            listUsuarioDTO.add(new UsuarioDTO(nombre,password,description,genero,email,fechaNacimiento,usuarioStr,status));

        }


    }
    public static UsuarioDTO conversorUnico(Usuario usuario){
        String nombre = usuario.getNombreProperty().get();
        String password =usuario.getPasswordProperty().get();
        String description =usuario.getDescriptionProperty().get();
        String genero =usuario.getGeneroProperty().get();
        String email =usuario.getEmailProperty().get();
        String fechaNacimiento =usuario.getFechaNacimientoProperty().get();
        String usuarioStr = usuario.getUsuarioProperty().get();
        String status =usuario.getStatusProperty().get();
        UsuarioDTO usuarioDTO = new UsuarioDTO(nombre,password,description,genero,email,fechaNacimiento,
                usuarioStr,status);
        return usuarioDTO;
    }
    public static ArrayList<UsuarioDTO> getListUsuarioDTO() {
        return listUsuarioDTO;
    }

    public static void textoJsonUsuario(){

        Gson gson=new Gson();
        ArrayList<UsuarioDTO> usuariosExistentes = jsonTextoUsuario();

        usuariosExistentes.addAll(listUsuarioDTO);


        try (FileWriter writer = new FileWriter(rutaArchivoUsuario)) {
            gson.toJson(usuariosExistentes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void textoJsonUsuarioModificacion(){
        Gson gson=new Gson();
        //ArrayList<UsuarioDTO> usuariosExistentes = jsonTextoUsuario();

        try (FileWriter writer = new FileWriter(rutaArchivoUsuario)) {
            gson.toJson(listUsuarioDTO, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<UsuarioDTO> jsonTextoUsuario(){

        Gson gson = new Gson();

        ArrayList<UsuarioDTO> usuariosExistentes= new ArrayList<>();
        File archivo = new File(rutaArchivoUsuario);
        if (!archivo.exists()) {
            return usuariosExistentes;
        }

        try (FileReader reader = new FileReader(rutaArchivoUsuario)) {
            Type listType = new TypeToken<ArrayList<UsuarioDTO>>() {}.getType();
            usuariosExistentes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuariosExistentes;


    }
}
