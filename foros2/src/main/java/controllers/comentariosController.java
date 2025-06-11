package controllers;

import convertores.ConvertorPost;
import edu.udelp.foros2.App;
import edu.udelp.foros2.Convertor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import posts.PostDTO;

import java.io.IOException;
import java.util.ArrayList;

import static convertores.ConvertorPost.listPostDTO;

public class comentariosController {
    @FXML
    private VBox lugarComentarios;
    @FXML
    private TextField txtComentario;
    ArrayList<PostDTO> postsDTO = ConvertorPost.jsonTextoPost();



    int postComentarioId=foroController.postId;

    @FXML
    public void initialize() {
        lugarComentarios.getChildren().clear();

        int cantidad = postsDTO.get(postComentarioId).getComentarios().size();

        for (int i = 0; i < cantidad; i++) {
            TextFlow textoFlowComentario = new TextFlow();
            Text usuario = new Text(postsDTO.get(postComentarioId).getUsuarioDTO().getUsuario() + ": ");
            Text comentario = new Text(postsDTO.get(postComentarioId).getComentarios().get(i));
            textoFlowComentario.getChildren().addAll(usuario, comentario);
            lugarComentarios.getChildren().add(textoFlowComentario);
        }



    }


    @FXML
    public void onClick(ActionEvent event) {

        String comentario = txtComentario.getText();

        postsDTO.get(postComentarioId).getComentarios().add(comentario);


        txtComentario.clear();
        initialize();

    }


    @FXML
    public void onBack(ActionEvent event) {

        listPostDTO=postsDTO;
        listPostDTO.get(postComentarioId).setComentarios(postsDTO.get(postComentarioId).getComentarios());
        ConvertorPost.textoJsonPostModificacion();

        listPostDTO.clear();
        postsDTO.clear();
        ConvertorPost.getListPostDTO().clear();


        try {
            App.setRoot("foros");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
