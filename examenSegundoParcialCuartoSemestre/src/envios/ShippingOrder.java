package envios;

import tipos.Package;

public class ShippingOrder implements Cloneable {
    Package paquete;
    String direccion;
    String destinatario;
    Boolean seguro;
    boolean envioEx;

    public Package getPaquete() {
        return paquete;
    }

    public void setPaquete(Package paquete) {
        this.paquete = paquete;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    public boolean isEnvioEx() {
        return envioEx;
    }

    public void setEnvioEx(boolean envioEx) {
        this.envioEx = envioEx;
    }
}
