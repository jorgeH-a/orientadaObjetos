package tags;

import javafx.beans.property.SimpleStringProperty;

public class Tags {

    public final long id;
    public final int count;

    private final SimpleStringProperty nombre;


    public SimpleStringProperty getNombreProperty() {
        return nombre;
    }

    public long getId() {
        return id;
    }



    public int getCount() {
        return count;
    }


    public Tags(long id, int count, String nombre) {
        this.id = id;
        this.count = count;
        this.nombre = new SimpleStringProperty(nombre);
    }


}
