package controllers;

import comunidad.ComunidadDTO;
import convertores.ConvertorComunidad;
import convertores.ConvertorPost;
import edu.udelp.foros2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import posts.PostDTO;

import java.io.IOException;
import java.util.ArrayList;

public class comunidadesController {
    public static int comunId;
    @FXML
    private VBox lugarComunidad;

    @FXML
    public void initialize() {
        lugarComunidad.getChildren().clear();

        ArrayList<ComunidadDTO> comunidadDTO = ConvertorComunidad.jsonTextoComunidad();
        int cantidad = comunidadDTO.size();

        for (int i = 0; i < cantidad; i++) {

            Button btnComunidad = new Button("Nombre: " + comunidadDTO.get(i).getNombre()+ "\n"
            + "Usuario creador: " + comunidadDTO.get(i).getUsuarioDTO().getUsuario() + "\n"
            + "Fecha de creacion: " + comunidadDTO.get(i).getFecha() + "\n");
            //btnComunidad.setPrefSize(100, 50);

            int finalI=i;
            btnComunidad.setOnAction(event -> {
                comunId = finalI;

                try {
                    App.setRoot("comunidad");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            });

            lugarComunidad.getChildren().addAll(btnComunidad);

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
    public void onNewComunidad(ActionEvent event) {
        try {
            App.setRoot("crearNuevaComunidad");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
