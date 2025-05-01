package controllers;

import edu.udelp.foros2.App;
import edu.udelp.foros2.Convertor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import posts.Post;
import usuarios.Usuario;
import usuarios.UsuarioDTO;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;




public class crearNuevoPostController {


    static String rutaArchivoPosts="archivoPosts";
    static ArrayList<Post> listPost=new ArrayList<>();
    LocalDate fecha;
    private File imagenSeleccionada;
    private File miArchivo;



    @FXML
    private TextArea txtDescripcion;

    @FXML
    private ChoiceBox<Boolean> cbPlus18;
    @FXML
    private ChoiceBox<Boolean> cbNSFW;

    @FXML
    private Label nombreArchivo;
    @FXML
    private ImageView imagen;

    @FXML
    public void initialize() {
        cbPlus18.getItems().addAll(true, false);
        cbNSFW.getItems().addAll(true, false);
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
        long id;
        File archivo = new File(rutaArchivoPosts);
        if(!archivo.exists() || archivo.length() == 0){
            id=0;
        }else{
            id=Convertor.jsonTextoPost().size();
        }




        LoginRegistroController usuario=new LoginRegistroController();
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








        listPost.add(new Post(id,usuario.conversorStringUsuario(),descripcion,urlImagen,rutaArchivo,fecha.toString(),nsfw,plus18));
        Convertor.conversorSimpleStringPost();
        Convertor.textoJsonPost();
        Convertor.getListPostDTO().clear();

        try {
            App.setRoot("foros");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static ArrayList<Post> getListPost(){
        return listPost;
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


