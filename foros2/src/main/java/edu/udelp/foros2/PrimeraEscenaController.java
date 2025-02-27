package edu.udelp.foros2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import edu.udelp.foros2.Usuario;

public class PrimeraEscenaController {

    @FXML
    private Label idNombre;

    @FXML
    private TextField txtNombre;
    
    @FXML
    private TableView<Usuario> tableView;
    
    
    @FXML
    public void initialize() {
    	TableColumn< Usuario, String>nombreColumn= new TableColumn<>("Nombre");
    	nombreColumn.setCellValueFactory(cellData -> cellData.getValue().getNombreProperty());
    	
    	TableColumn< Usuario, String>apellidoPaternoColumn= new TableColumn<>("ApellidoPaterno");
    	apellidoPaternoColumn.setCellValueFactory(cellData -> cellData.getValue().getApellidoPaternoProperty());
    	
    	TableColumn< Usuario, String>apellidoMaternoColumn= new TableColumn<>("ApellidoMaterno");
    	apellidoMaternoColumn.setCellValueFactory(cellData -> cellData.getValue().getApellidoMaternoProperty());
    	
    	TableColumn< Usuario, String>emailColumn= new TableColumn<>("Email");
    	emailColumn.setCellValueFactory(cellData -> cellData.getValue().getEmailProperty());
    	
    	tableView.getColumns().addAll(nombreColumn,apellidoPaternoColumn,apellidoMaternoColumn,emailColumn);
    	
    }
    
    @FXML
    void onClick(ActionEvent event) {
    	ObservableList<Usuario> movies=FXCollections.observableArrayList(
    			new Usuario("The Batman","Robert Pattinson","299","7"));
    	tableView.setItems(movies);
    	String value=txtNombre.getText();
    	idNombre.setText(UsuarioSingleton.getInstance().getValue(value));
    	
    }
    
/*
    @FXML
    void onClick7(ActionEvent event) {
    	ObservableList<Usuario> movies = FXCollections.observableArrayList(
                new Usuario("The Batman","Robert Pattinson","299","7"));
        
        tableView.setItems(movies);
        String value = txtNombre.getText();
        
    	idNombre.setText(UsuarioSingleton.getInstance().getValue(value));
    	
    }
*/
}

