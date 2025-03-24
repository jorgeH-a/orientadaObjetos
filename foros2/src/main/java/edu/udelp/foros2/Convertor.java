package edu.udelp.foros2;

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




public class Convertor {

    static ArrayList<UsuarioDTO> listUsuarioDTO=new ArrayList<>();
    static String rutaArchivo = "listaUsuarios.json";


    public static void conversorSimpleString(){

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

    public static ArrayList<UsuarioDTO> getListUsuarioDTO() {
        return listUsuarioDTO;
    }

    public static void textoJson(){

        Gson gson=new Gson();
        ArrayList<UsuarioDTO> usuariosExistentes = jsonTexto();

        usuariosExistentes.addAll(listUsuarioDTO);


        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(usuariosExistentes, writer);
            System.out.println("Lista de usuarios actualizada y guardada en JSON exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



    public static ArrayList<UsuarioDTO> jsonTexto(){

        Gson gson = new Gson();

        ArrayList<UsuarioDTO> usuariosExistentes= new ArrayList<>();
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return usuariosExistentes;
        }

        try (FileReader reader = new FileReader(rutaArchivo)) {
            Type listType = new TypeToken<ArrayList<UsuarioDTO>>() {}.getType();
            usuariosExistentes = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuariosExistentes;


    }


    
}
