package controllers;

import comunidad.Comunidad;
import comunidad.ComunidadDTO;
import convertores.ConvertorComunidad;
import convertores.ConvertorPost;
import convertores.ConvertorTags;
import convertores.ConvertorUsuario;
import edu.udelp.foros2.App;
import edu.udelp.foros2.Convertor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import posts.Post;
import tags.Tags;
import tags.TagsDTO;
import usuarios.Usuario;
import usuarios.UsuarioDTO;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import static controllers.crearNuevaComunidadController.listComunidad;



public class crearNuevoPostController {


    static String rutaArchivoPosts="archivoPosts";
    static String rutaArchivoTags="archivoTags";
    static ArrayList<Post> listPost=new ArrayList<>();
    static ArrayList<Tags> listTags=new ArrayList<>();
    LocalDate fecha;
    private File imagenSeleccionada;
    private File miArchivo;
    Comunidad comunUnico;
    ArrayList<ComunidadDTO> comunidadDTO=ConvertorComunidad.jsonTextoComunidad();
    ArrayList<UsuarioDTO> usuarioDTO= ConvertorUsuario.jsonTextoUsuario();
    ArrayList<TagsDTO> tagsDTO= ConvertorTags.jsonTextoTags();
    Comunidad comunidadForo;
    UsuarioDTO usuarioForo;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private TextField txtTag;

    @FXML
    private ChoiceBox<Boolean> cbPlus18;
    @FXML
    private ChoiceBox<Boolean> cbNSFW;
    @FXML
    private ChoiceBox<String> cbComunidad;

    @FXML
    private Label nombreArchivo;
    @FXML
    private ImageView imagen;

    long idPost;
    long idTag;

    ArrayList<String> listaTags = new ArrayList<>();
    @FXML
    private ListView<String> listViewTags;

    @FXML
    public void initialize() {
        int comunidad=comunidadDTO.size();
        int tags=tagsDTO.size();

        cbPlus18.getItems().addAll(true, false);
        cbNSFW.getItems().addAll(true, false);

        for(int i=0;i<comunidad;i++) {
            cbComunidad.getItems().addAll(comunidadDTO.get(i).getNombre());
        }

        for(int i=0;i<tags;i++) {
            listViewTags.getItems().addAll(tagsDTO.get(i).getNombre());
            listViewTags.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }


    }



    @FXML
    private void onImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", ".*jpg", "*.jpeg"));
        File archivo = fileChooser.showOpenDialog(null);
        if (archivo != null) {
            imagen.setImage(new Image(archivo.toURI().toString()));
            imagenSeleccionada = archivo;
            System.out.println("Imagen guardada: " + imagenSeleccionada.getAbsolutePath());

        }
    }


    @FXML
    private void onArchivo(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));
        File archivo = fileChooser.showOpenDialog(null);
        if (archivo != null) {
            nombreArchivo.setText("Seleccionado: " + archivo.getName());
            miArchivo=archivo;
            System.out.println("Ruta completa: " + miArchivo.getAbsolutePath());
        }

    }


    @FXML
    private void onClick(ActionEvent event) {
        String rutaArchivo=null;
        String urlImagen=null;
        boolean principal=false;


        for(int i=0;i<comunidadDTO.size();i++) {
            if (Objects.equals(comunidadDTO.get(i).getNombre(), "Principal")) {
                principal = true;
                System.out.println(principal);
                break;
            }
        }


        if(!principal){
            for (int i=0;i<usuarioDTO.size();i++) {
                if(usuarioDTO.get(i).getUsuario().equals("Principal")) {
                    usuarioForo= usuarioDTO.get(i);
                    break;
                }

            }
            File archivo = new File(rutaArchivoTags);
            if(!archivo.exists() || archivo.length() == 0){
                idTag=0;
            }else{
                idTag= ConvertorPost.jsonTextoPost().size();
            }


            listTags.add(new Tags(idTag,0,"tag"));



            ConvertorTags.jsonTextoTags();

            ConvertorTags.conversorSimpleStringTags();
            ConvertorTags.textoJsonTags();
            listTags.clear();
            ConvertorTags.getListTagsDTO().clear();

            listComunidad.add(new Comunidad(comunidadDTO.size(),"Principal",LoginRegistroController.conversorStringUsuarioAfuera(usuarioForo),"El oficial","Desde el principio",null,false,false,listTags));


            ConvertorComunidad.conversorSimpleStringComunidad();
            ConvertorComunidad.textoJsonComunidad();
            listComunidad.clear();
            ConvertorComunidad.getListComunidadDTO().clear();

        }


        File archivo = new File(rutaArchivoPosts);
        if(!archivo.exists() || archivo.length() == 0){
            idPost=0;
        }else{
            idPost= ConvertorPost.jsonTextoPost().size();
        }





        LoginRegistroController usuario=new LoginRegistroController();
        comunidadController loQueSea=new comunidadController();
        //usuario.conversorStringUsuario() Este es el Usuario del paquete usuarios, para guardarlos el el Usuario de Post

        String descripcion=txtDescripcion.getText();

        if (miArchivo != null) {
            rutaArchivo = miArchivo.getAbsolutePath();
        }

        if (imagenSeleccionada != null) {
            urlImagen = imagenSeleccionada.getAbsolutePath();
        }


        fecha=LocalDate.now();

        boolean nsfw;
        if(cbNSFW.getValue()!=null){
            nsfw=cbNSFW.getValue();
        }else{
            nsfw=false;
        }
        boolean plus18;
        if(cbPlus18.getValue()){
            plus18=cbPlus18.getValue();
        }else{
            plus18=false;
        }

        comunUnico=null;
        if(cbComunidad.getValue()!=null){
            String comunidad=cbComunidad.getValue();
            for (ComunidadDTO dto : comunidadDTO) {
                if (dto.getNombre().equals(comunidad)) {

                    comunUnico = conversorStringComunidad(dto);
                    break;
                }
            }
        }else{
            //Comunidad comunidadForo = new Comunidad(0,"Principal",null,"El oficial","Desde el principio",null,false,false);
            for (ComunidadDTO dto : comunidadDTO) {
                if (dto.getNombre().equals("Principal")) {
                    comunUnico = conversorStringComunidad(dto);
                    break;
                }
            }

        }

        ObservableList<String> seleccionados = listViewTags.getSelectionModel().getSelectedItems();

        ArrayList<String> tagsList = new ArrayList<>(seleccionados);



        for (int i=0;i<tagsList.size();i++) {
            if (tagsDTO.get(i).getNombre().equals(tagsList.get(i))) {
                listTags.add(new Tags(tagsDTO.get(i).id,tagsDTO.get(i).getCount(),tagsDTO.get(i).getNombre()));

            }
        }



        listPost.add(new Post(idPost,usuario.conversorStringUsuario(),descripcion,urlImagen,rutaArchivo,fecha.toString(),nsfw,plus18,comunUnico,listTags));




        ConvertorPost.conversorSimpleStringPost();
        ConvertorPost.textoJsonPost();
        listPost.clear();
        listTags.clear();
        ConvertorPost.getListPostDTO().clear();

        try {
            App.setRoot("foros");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    public void onBack(ActionEvent event) {

        try {
            App.setRoot("foros");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    public void onCrearTag(ActionEvent event) {


        File archivo = new File(rutaArchivoTags);
        if(!archivo.exists() || archivo.length() == 0){
            idTag=0;
        }else{
            idTag= ConvertorPost.jsonTextoPost().size();
        }



        String tag=txtTag.getText();


        listTags.add(new Tags(idTag,0,tag));

        ConvertorTags.conversorSimpleStringTags();
        ConvertorTags.textoJsonTags();
        listTags.clear();
        ConvertorTags.getListTagsDTO().clear();

    }

    public static ArrayList<Post> getListPost(){
        return listPost;
    }


    public Comunidad conversorStringComunidad(ComunidadDTO comDTO){

        Comunidad comun=new Comunidad(comDTO.getId(),comDTO.getNombre(),conversorStringUsuarioCom(comDTO.getUsuarioDTO()),comDTO.getDescripcion(),
        comDTO.getFecha(),comDTO.getLogo(),comDTO.isNsfw(),comDTO.isPlus18(),conversorStringTags(comDTO.getTagsDTO()));
        return comun;
    }

    public ArrayList<Tags> conversorStringTags(ArrayList<TagsDTO> tagsDTO) {
        ArrayList<Tags> tags = new ArrayList<>();

        if (tagsDTO == null) {
            System.out.println("tagsDTO es null");
            return tags; // Devuelve lista vacía o puedes lanzar una excepción si es crítico
        }

        for (TagsDTO dto : tagsDTO) {
            long id = dto.getId();
            String nombre = dto.getNombre();
            int count = dto.getCount();

            Tags tag = new Tags(id, count, nombre);
            tags.add(tag);
        }

        return tags;
    }

    public Usuario conversorStringUsuarioCom(UsuarioDTO usuarioDTO){
        Usuario usuario=new Usuario(usuarioDTO.getNombre(),usuarioDTO.getPassword(),usuarioDTO.getDescription(),usuarioDTO.getGenero(),usuarioDTO.getEmail(),
                usuarioDTO.getFechaNacimiento(),usuarioDTO.getUsuario(),usuarioDTO.getStatus());
        return usuario;
    }

    public static ArrayList<Tags> getListTags(){
        return listTags;
    }

}

/*
    Menu menu = new Menu("Opciones");

    CheckMenuItem opcion1 = new CheckMenuItem("Opción 1");
    CheckMenuItem opcion2 = new CheckMenuItem("Opción 2");
    CheckMenuItem opcion3 = new CheckMenuItem("Opción 3");

    @FXML
    public void initialize() {
        menu.getItems().addAll(opcion1, opcion2, opcion3);
    }
*/


