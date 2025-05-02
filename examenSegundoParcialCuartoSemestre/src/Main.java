import envios.ShippingOrder;
import envios.ShippingOrderBuilding;
import procesos.PackageFactory;
import tipos.Package;
import tipos.SmallPackage;
import tipos.TipoPaquete;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
int elegirPaquete=0;
String direccion=null;

            Package paqueteLargo=PackageFactory.crear(TipoPaquete.LARGEPACKAGE);
            paqueteLargo.setPeso(40);
            paqueteLargo.setCosto(50);
            paqueteLargo.setId(001);

            System.out.println("Paquete Largo: ");
        System.out.println(paqueteLargo.getPeso());
        System.out.println(paqueteLargo.getCosto());
        System.out.println(paqueteLargo.getId());


            Package paqueteMedio=PackageFactory.crear(TipoPaquete.MEDIUMPACKAGE);
            paqueteMedio.setPeso(25);
            paqueteMedio.setCosto(30);
            paqueteMedio.setId(002);
System.out.println("Paquete Medio: ");
        System.out.println(paqueteMedio.getPeso());
        System.out.println(paqueteMedio.getCosto());
        System.out.println(paqueteMedio.getId());

            Package paqueteChico=PackageFactory.crear(TipoPaquete.SMALLPACKAGE);


            paqueteChico.setPeso(10);
            paqueteChico.setCosto(15);
            paqueteChico.setId(003);

        System.out.println("Paquete Chico: ");

        System.out.println(paqueteChico.getPeso());
        System.out.println(paqueteChico.getCosto());
        System.out.println(paqueteChico.getId());





        ShippingOrder ships=new ShippingOrderBuilding().crear().paquete(paqueteChico).direccion("Ciudad de Mexico, Calle toronto")
                .destinatario("Jose").seguro(true).envioEx(true).build();



        System.out.println("Peso del paquete de envio: "+ships.getPaquete().getPeso());
        System.out.println("Costo del paquete de envio: "+ships.getPaquete().getCosto());
        System.out.println("ID del paquete de envio: "+ships.getPaquete().getId());




        System.out.println("Direccion del paquete: "+ships.getDireccion());
        System.out.println("Destinatario del paquete: "+ships.getDestinatario());
        System.out.println("Tiene seguro el paquete: "+ships.isSeguro());
        System.out.println("Es express el paquete: "+ships.isEnvioEx());










    }
}