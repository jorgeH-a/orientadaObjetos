package edu.udelp.foros2;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import controllers.RegistroController;
import controllers.crearNuevoPostController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import posts.Post;
import posts.PostDTO;
import usuarios.UsuarioDTO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

import usuarios.Usuario;


public class Convertor {

    static ArrayList<UsuarioDTO> listUsuarioDTO=new ArrayList<>();
    public static ArrayList<PostDTO> listPostDTO = new ArrayList<>();
    static String rutaArchivoUsuario = "archivoUsuarios";
    static String rutaArchivoPosts="archivoPosts";



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
    public static void conversorSimpleStringPost(){
        for(int i = 0; i< crearNuevoPostController.getListPost().size(); i++){

            long id=crearNuevoPostController.getListPost().get(i).getIdProperty();
            UsuarioDTO usuarioDTO=conversorUnico(crearNuevoPostController.getListPost().get(i).getUsuarioPost());
            String descripcion=crearNuevoPostController.getListPost().get(i).getDescripcionProperty().get();
            String imagen=crearNuevoPostController.getListPost().get(i).getImagenProperty().get();
            String archivo=crearNuevoPostController.getListPost().get(i).getArchivoProperty().get();
            String fecha= crearNuevoPostController.getListPost().get(i).getFechaProperty().get();
            boolean nsfw=crearNuevoPostController.getListPost().get(i).getNsfwProperty().get();
            boolean plus18=crearNuevoPostController.getListPost().get(i).getPlus18Property().get();
            listPostDTO.add(new PostDTO(id,usuarioDTO,descripcion,imagen,archivo,fecha,nsfw,plus18,null));
        }
    }




    public static ArrayList<PostDTO> getListPostDTO(){
        return listPostDTO;
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


    public static void textoJsonPost(){
        Gson gson=new Gson();
        ArrayList<PostDTO> postsExistentes = jsonTextoPost();

        postsExistentes.addAll(listPostDTO);


        try (FileWriter writer = new FileWriter(rutaArchivoPosts)) {
            gson.toJson(postsExistentes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static ArrayList<PostDTO> jsonTextoPost(){
        Gson gson = new Gson();
        ArrayList<PostDTO> postsExistentes = new ArrayList<>();
        File archivo = new File(rutaArchivoPosts);

        if (!archivo.exists()) {
            return postsExistentes;
        }
        if (archivo.length() == 0) {
            return postsExistentes;
        }

        try (FileReader reader = new FileReader(rutaArchivoPosts)) {
            Type listType = new TypeToken<ArrayList<PostDTO>>() {}.getType();
            postsExistentes = gson.fromJson(reader, listType);
            if (postsExistentes == null) {
                postsExistentes = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return postsExistentes;
    }








}
