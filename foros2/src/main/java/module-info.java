module edu.udelp.foros2 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;

    opens edu.udelp.foros2 to javafx.fxml;
    opens edu.udelp.foros2.usuarios.controllers to javafx.fxml;
    
    exports edu.udelp.foros2;
    exports edu.udelp.foros2.usuarios.controllers;
}
