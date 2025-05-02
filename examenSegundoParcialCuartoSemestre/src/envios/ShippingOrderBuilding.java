package envios;

import tipos.Package;

/*
Package paquete;
    String direccion;
    String destinatario;
    String seguro;
    boolean envioEx;
 */
public class ShippingOrderBuilding {
    private static ShippingOrder shippingOrder;


    public static  ShippingOrderBuilding crear(){
        shippingOrder=new ShippingOrder();
        return new ShippingOrderBuilding() ;

    }

    public ShippingOrder build(){
        return shippingOrder;
    }
    public ShippingOrderBuilding paquete(Package paquete){
        shippingOrder.setPaquete(paquete);
        return this;
    }
    public ShippingOrderBuilding direccion(String direccion){
        shippingOrder.setDireccion(direccion);
        return this;
    }
    public ShippingOrderBuilding destinatario(String destinatario){
        shippingOrder.setDestinatario(destinatario);
        return this;
    }
public ShippingOrderBuilding seguro(boolean seguro){
        shippingOrder.setSeguro(seguro);
        return this;
}
public ShippingOrderBuilding envioEx(boolean envioEx){
        shippingOrder.setEnvioEx(envioEx);
        return this;
}
}
