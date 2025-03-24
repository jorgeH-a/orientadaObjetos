package controllers;

import java.io.IOException;
import java.util.ArrayList;


import edu.udelp.foros2.App;
import edu.udelp.foros2.Convertor;
import usuarios.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import usuarios.UsuarioDTO;

public class RegistroController {

	static ArrayList<Usuario> listUsuario=new ArrayList<>();

	@FXML
	private ComboBox<String> cbGenero;
	@FXML
    private TextField txtFecha;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtUsuario;
    
    @FXML
    public void initialize() {
        cbGenero.getItems().addAll("Masculino", "Femenino", "Prefiero no decir");
        
    }
    @FXML
    public void onClick(ActionEvent event) {
    	String nombre=txtNombre.getText();
    	String password=txtPassword.getText();
    	String des=txtDescripcion.getText();
    	String genero=cbGenero.getValue();
    	String email=txtEmail.getText();
    	String fecha=txtFecha.getText();
    	String usuario=txtUsuario.getText();
    	String estatus="Activo";
    	
    	
    	listUsuario.add(new Usuario(nombre,password,des,genero,email,fecha,usuario,estatus));
        Convertor.conversorSimpleString();

        Convertor.textoJson();
        Convertor.getListUsuarioDTO().clear();



    	try {
			App.setRoot("loginRegistro");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }
    
    
	public static ArrayList<Usuario> getListUsuario() {
        return listUsuario;
    }
    
    
    /*
    Gson gson = new Gson();

        // Leer el contenido existente del archivo JSON
        FileReader reader = new FileReader("personas.json");
        Type listType = new TypeToken<ArrayList<Persona>>() {}.getType();
        List<Persona> personas = gson.fromJson(reader, listType);
        reader.close();

        // Agregar un nuevo objeto al listado
        Persona nuevaPersona = new Persona("Juan", 30);
        personas.add(nuevaPersona);

        // Escribir el contenido actualizado nuevamente al archivo
        FileWriter writer = new FileWriter("personas.json");
        gson.toJson(personas, writer);
        writer.close();

        System.out.println("Nuevo objeto añadido exitosamente.");
    */

}
