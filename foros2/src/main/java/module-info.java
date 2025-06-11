module edu.udelp.foros2 {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
    requires com.google.gson;
    requires java.sql;
    requires java.desktop;

    //opens edu.udelp.foros2 to com.google.gson;
    opens edu.udelp.foros2 to javafx.fxml,com.google.gson;
    opens convertores to javafx.fxml,com.google.gson;
    opens controllers to javafx.fxml;
    opens usuarios to com.google.gson;
    opens comunidad to javafx.fxml,com.google.gson;
    opens tags to javafx.fxml,com.google.gson;

    opens posts to com.google.gson;



    exports edu.udelp.foros2;
    exports controllers;
    exports comunidad;


}
