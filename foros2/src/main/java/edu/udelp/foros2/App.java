package edu.udelp.foros2;

import com.google.gson.Gson;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;




/*
H2 base de datos

i18n
 */
/**
 *
 *
 *
 * JavaFX App
 */



public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
       
        scene = new Scene(loadFXML("loginRegistro"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Parent loadFXML(String fxml)throws IOException{
    	FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource(fxml+".fxml"));
    	return fxmlLoader.load();
    }

    public static void main(String[] args) {

        launch();


    }
}





/*
        Gson gson=new Gson();
        //Gson gson=new GsonBuilder().setPrettyPrinting().create();
        String json="{\"nombre\":\"Luis\""
                +",\"apellidoPaterno\":\"Ochoa\""
                +",\"apellidoMaterno\":\"García\""
                +",\"email\":\"oaalberto@udelp.edu.mx\"}";

        UsuarioDTO usuario=gson.fromJson(json,UsuarioDTO.class);
        System.out.println(usuario.getNombre());
        usuario.setNombre("Luis Alberto");
        json=gson.toJson(usuario);
        System.out.println(json);

  */




















