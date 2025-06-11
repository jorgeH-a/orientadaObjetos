package convertores;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import comunidad.Comunidad;
import comunidad.ComunidadDTO;
import controllers.crearNuevaComunidadController;
import controllers.crearNuevoPostController;
import posts.PostDTO;
import tags.TagsDTO;
import usuarios.Usuario;
import usuarios.UsuarioDTO;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static convertores.ConvertorTags.conversorUnicoTags;
import static convertores.ConvertorUsuario.conversorUnico;

public class ConvertorComunidad {
    public static ArrayList<ComunidadDTO> listComunidadDTO = new ArrayList<>();
    static String rutaArchivoComunidad="archivoComunidad";


    public static void conversorSimpleStringComunidad(){
        for(int i = 0; i< crearNuevaComunidadController.getListComunidad().size(); i++){

            long id=crearNuevaComunidadController.getListComunidad().get(i).getIdProperty();
            String nombre=crearNuevaComunidadController.getListComunidad().get(i).getNombreProperty().get();

            UsuarioDTO usuarioDTO=conversorUnico(crearNuevaComunidadController.getListComunidad().get(i).getUsuario());
            String descripcion=crearNuevaComunidadController.getListComunidad().get(i).getDescripcionProperty().get();
            String fecha= crearNuevaComunidadController.getListComunidad().get(i).getFechaProperty().get();
            String imagen=crearNuevaComunidadController.getListComunidad().get(i).getLogoProperty().get();
            boolean nsfw=crearNuevaComunidadController.getListComunidad().get(i).getNsfwProperty().get();
            boolean plus18=crearNuevaComunidadController.getListComunidad().get(i).getPlus18Property().get();
            ArrayList<TagsDTO> tagsDTO=conversorUnicoTags(crearNuevoPostController.getListPost().get(i).getTags());



            listComunidadDTO.add(new ComunidadDTO(id,nombre,usuarioDTO,descripcion,fecha,imagen,nsfw,plus18,tagsDTO));
        }
    }

    public static ComunidadDTO conversorUnicoComunidad(Comunidad comunidad){
        long id=comunidad.getId();
        String nombre=comunidad.getNombreProperty().get();
        UsuarioDTO usuarioDTO=conversorUnico(comunidad.getUsuario());
        String descripcion=comunidad.getDescripcionProperty().get();
        String fecha=comunidad.getFechaProperty().get();
        String logo=comunidad.getLogoProperty().get();
        boolean nsfw=comunidad.getNsfwProperty().get();
        boolean plus18=comunidad.getPlus18Property().get();
        ArrayList<TagsDTO> tagsDTO=conversorUnicoTags(comunidad.getTags());

        ComunidadDTO comunidadDTO=new ComunidadDTO(id,nombre,usuarioDTO,descripcion,fecha,logo,nsfw,plus18,tagsDTO);
    return comunidadDTO;
    }

    public static ArrayList<ComunidadDTO> getListComunidadDTO(){
        return listComunidadDTO;
    }


    public static void textoJsonComunidad(){
        Gson gson=new Gson();
        ArrayList<ComunidadDTO> comunidadesExistentes = jsonTextoComunidad();

        comunidadesExistentes.addAll(listComunidadDTO);

        try (FileWriter writer = new FileWriter(rutaArchivoComunidad)) {
            gson.toJson(comunidadesExistentes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void textoJsonComunidadModificacion(){
        Gson gson=new Gson();
        //ArrayList<ComunidadDTO> comunidadesExistentes = listComunidadDTO;

        try (FileWriter writer = new FileWriter(rutaArchivoComunidad)) {
            gson.toJson(listComunidadDTO, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<ComunidadDTO> jsonTextoComunidad(){
        Gson gson = new Gson();
        ArrayList<ComunidadDTO> comunidadesExistentes = new ArrayList<>();
        File archivo = new File(rutaArchivoComunidad);

        if (!archivo.exists()) {
            return comunidadesExistentes;
        }
        if (archivo.length() == 0) {
            return comunidadesExistentes;
        }

        try (FileReader reader = new FileReader(rutaArchivoComunidad)) {
            Type listType = new TypeToken<ArrayList<ComunidadDTO>>() {}.getType();
            comunidadesExistentes = gson.fromJson(reader, listType);
            if (comunidadesExistentes == null) {
                comunidadesExistentes = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comunidadesExistentes;
    }

}
