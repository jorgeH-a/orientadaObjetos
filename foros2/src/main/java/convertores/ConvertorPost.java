package convertores;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import comunidad.ComunidadDTO;
import controllers.crearNuevoPostController;
import posts.PostDTO;
import tags.TagsDTO;
import usuarios.UsuarioDTO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static convertores.ConvertorComunidad.conversorUnicoComunidad;
import static convertores.ConvertorTags.conversorUnicoTags;
import static convertores.ConvertorUsuario.conversorUnico;


public class ConvertorPost {
    public static ArrayList<PostDTO> listPostDTO = new ArrayList<>();
    static String rutaArchivoPosts="archivoPosts";



    public static void conversorSimpleStringPost(){
        for(int i = 0; i< crearNuevoPostController.getListPost().size(); i++){

            long id=crearNuevoPostController.getListPost().get(i).getIdProperty();
            UsuarioDTO usuarioDTO=conversorUnico(crearNuevoPostController.getListPost().get(i).getUsuarioPost());
            ComunidadDTO comunidadDTO=conversorUnicoComunidad(crearNuevoPostController.getListPost().get(i).getComunidad());
            String descripcion=crearNuevoPostController.getListPost().get(i).getDescripcionProperty().get();
            String imagen=crearNuevoPostController.getListPost().get(i).getImagenProperty().get();
            String archivo=crearNuevoPostController.getListPost().get(i).getArchivoProperty().get();
            String fecha= crearNuevoPostController.getListPost().get(i).getFechaProperty().get();
            boolean nsfw=crearNuevoPostController.getListPost().get(i).getNsfwProperty().get();
            boolean plus18=crearNuevoPostController.getListPost().get(i).getPlus18Property().get();
            ArrayList<TagsDTO> tagsDTO=conversorUnicoTags(crearNuevoPostController.getListPost().get(i).getTags());
            listPostDTO.add(new PostDTO(id,comunidadDTO,usuarioDTO,descripcion,imagen,archivo,fecha,nsfw,plus18,null,tagsDTO));
        }
    }




    public static ArrayList<PostDTO> getListPostDTO(){
        return listPostDTO;
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
    public static void textoJsonPostModificacion(){
        Gson gson=new Gson();
        ArrayList<PostDTO> postsExistentes = listPostDTO;

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
