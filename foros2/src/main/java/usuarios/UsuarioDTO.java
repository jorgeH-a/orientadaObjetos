package usuarios;

import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class UsuarioDTO {

    private String nombre;
    private String password;
    private String description;
    private String genero;
    private String email;
    private String fechaNacimiento;
    private String redesSociales;
    private String usuario;
    private String status;
    private ArrayList<String> followers=new ArrayList<>();
    private ArrayList<String> comunidades=new ArrayList<>();

    public UsuarioDTO(String nombre, String password,String description,String genero, String email,
                   String fechaNacimiento, String usuario, String status) {
        super();
        this.nombre = nombre;
        this.password= password;
        this.description= description;
        this.genero= genero;
        this.email = email;
        this.fechaNacimiento= fechaNacimiento;
        this.usuario= usuario;
        this.status=status;


    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(String redesSociales) {
        this.redesSociales = redesSociales;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<String> followers) {
        this.followers = followers;
    }

    public ArrayList<String> getComunidades() {
        return comunidades;
    }

    public void setComunidades(ArrayList<String > comunidades) {
        this.comunidades = comunidades;
    }
}
