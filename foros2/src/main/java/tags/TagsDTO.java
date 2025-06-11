package tags;

public class TagsDTO {

    public long id;
    public int count;
    private String nombre;

    public TagsDTO(long id, int count, String nombre) {
        super();
        this.id = id;
        this.count = count;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
