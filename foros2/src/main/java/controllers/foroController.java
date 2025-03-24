package controllers;

import java.io.IOException;

import edu.udelp.foros2.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class foroController {

	
	 @FXML
	 public void onClick(ActionEvent event) {
		 
		 try {
				App.setRoot("loginRegistro");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
}
