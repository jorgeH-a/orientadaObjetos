package convertores;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controllers.crearNuevoPostController;
import tags.Tags;
import tags.TagsDTO;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static convertores.ConvertorUsuario.conversorUnico;

public class ConvertorTags {

    public static ArrayList<TagsDTO> listTagsDTO = new ArrayList<>();
    static String rutaArchivoTags="archivoTags";


    public static void conversorSimpleStringTags(){
        for(int i = 0; i< crearNuevoPostController.getListTags().size(); i++){

            long id=crearNuevoPostController.getListTags().get(i).getId();
            String nombre=crearNuevoPostController.getListTags().get(i).getNombreProperty().get();
            int count=crearNuevoPostController.getListTags().get(i).getCount();
            listTagsDTO.add(new TagsDTO(id,count,nombre));
        }
    }



    public static ArrayList<TagsDTO> conversorUnicoTags(ArrayList<Tags> tags) {

        ArrayList<TagsDTO> lista = new ArrayList<>();
        for (Tags tag : tags) {
            long id = tag.getId();
            String nombre = tag.getNombreProperty().get();
            int count = tag.getCount();

            TagsDTO dto = new TagsDTO(id, count, nombre);
            lista.add(dto);
        }
        return lista;
    }

    public static ArrayList<TagsDTO> getListTagsDTO(){
        return listTagsDTO;
    }


    public static void textoJsonTags(){
        Gson gson=new Gson();
        ArrayList<TagsDTO> tagsExistentes = jsonTextoTags();

        tagsExistentes.addAll(listTagsDTO);

        try (FileWriter writer = new FileWriter(rutaArchivoTags)) {
            gson.toJson(tagsExistentes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void textoJsonTagsModificacion(){
        Gson gson=new Gson();
        //ArrayList<ComunidadDTO> comunidadesExistentes = listComunidadDTO;

        try (FileWriter writer = new FileWriter(rutaArchivoTags)) {
            gson.toJson(listTagsDTO, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static ArrayList<TagsDTO> jsonTextoTags(){
        Gson gson = new Gson();
        ArrayList<TagsDTO> tagsExistentes = new ArrayList<>();
        File archivo = new File(rutaArchivoTags);

        if (!archivo.exists()) {
            return tagsExistentes;
        }
        if (archivo.length() == 0) {
            return tagsExistentes;
        }

        try (FileReader reader = new FileReader(rutaArchivoTags)) {
            Type listType = new TypeToken<ArrayList<TagsDTO>>() {}.getType();
            tagsExistentes = gson.fromJson(reader, listType);
            if (tagsExistentes == null) {
                tagsExistentes = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tagsExistentes;
    }





}
