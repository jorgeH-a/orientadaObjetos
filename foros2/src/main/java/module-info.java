module edu.udelp.foros2 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
    requires com.google.gson;

    //opens edu.udelp.foros2 to com.google.gson;
    opens edu.udelp.foros2 to javafx.fxml,com.google.gson;
    opens controllers to javafx.fxml;
    opens usuarios to com.google.gson;
    
    exports edu.udelp.foros2;
    exports controllers;
}
