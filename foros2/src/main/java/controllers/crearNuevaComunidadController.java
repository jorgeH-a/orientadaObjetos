package controllers;

import comunidad.Comunidad;
import comunidad.ComunidadDTO;
import convertores.ConvertorComunidad;
import convertores.ConvertorPost;
import convertores.ConvertorTags;
import edu.udelp.foros2.App;
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

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static controllers.crearNuevoPostController.rutaArchivoTags;

public class crearNuevaComunidadController {

    static String rutaArchivoComunidad="archivoComunidad";
    static ArrayList<Comunidad> listComunidad = new ArrayList<>();
    static ArrayList<Tags> listTags=new ArrayList<>();
    ArrayList<TagsDTO> tagsDTO= ConvertorTags.jsonTextoTags();

    long idTag;
    LocalDate fecha;
    private File imagenSeleccionada;

    @FXML
    private TextField txtTag;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private ChoiceBox<Boolean> cbPlus18;
    @FXML
    private ChoiceBox<Boolean> cbNSFW;

    @FXML
    private ListView<String> listViewTags;

    @FXML
    private ImageView imagen;

    @FXML
    public void initialize() {
        int tags=tagsDTO.size();

        cbPlus18.getItems().addAll(true, false);
        cbNSFW.getItems().addAll(true, false);
        for(int i=0;i<tags;i++) {
            listViewTags.getItems().addAll(tagsDTO.get(i).getNombre());
            listViewTags.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        }
    }
    @FXML
    private void onLogo(ActionEvent event) {
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
    private void onClick(ActionEvent event) {

        String urlImagen=null;
        long id;


        File archivo = new File(rutaArchivoComunidad);
        if(!archivo.exists() || archivo.length() == 0){
            id=0;
        }else{
            id= ConvertorComunidad.jsonTextoComunidad().size();
        }




        LoginRegistroController usuario=new LoginRegistroController();
        //usuario.conversorStringUsuario() Este es el Usuario del paquete usuarios, para guardarlos el el Usuario de Post


        String nombre = txtNombre.getText();
        String descripcion=txtDescripcion.getText();

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
        ObservableList<String> seleccionados = listViewTags.getSelectionModel().getSelectedItems();

        ArrayList<String> tagsList = new ArrayList<>(seleccionados);



        for (int i=0;i<tagsList.size();i++) {
            if (tagsDTO.get(i).getNombre().equals(tagsList.get(i))) {
                listTags.add(new Tags(tagsDTO.get(i).id,tagsDTO.get(i).getCount(),tagsDTO.get(i).getNombre()));

            }
        }

        listComunidad.add(new Comunidad(id,nombre,usuario.conversorStringUsuario(),descripcion,fecha.toString(),urlImagen,nsfw,plus18,listTags));
        ConvertorComunidad.conversorSimpleStringComunidad();
        ConvertorComunidad.textoJsonComunidad();
        listTags.clear();
        listComunidad.clear();
        ConvertorComunidad.getListComunidadDTO().clear();

        try {
            App.setRoot("comunidades");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    public void onBack(ActionEvent event) {

        try {
            App.setRoot("comunidades");
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
    public static ArrayList<Comunidad> getListComunidad(){
        return listComunidad;
    }


}
