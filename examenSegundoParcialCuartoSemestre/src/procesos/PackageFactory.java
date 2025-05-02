package procesos;

import tipos.*;
import tipos.Package;

public class PackageFactory {

    public static Package crear (TipoPaquete tipo){
        switch (tipo){
            case SMALLPACKAGE:
                return new SmallPackage();
            case MEDIUMPACKAGE:
                return new MediumPackage();
            case LARGEPACKAGE:
                return new LargePackage();
        }

        return null;
    }


}
