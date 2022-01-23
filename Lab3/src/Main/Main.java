package Main;

import Model.*;
import Control.Control;
import Visual.*;

/**
 * Clase principal
 * @author Victor Hurtado
 */

public class Main {

    public static void main(String[] args) {
        //creo el modelo
        PL plat =new PL();
        //creo el controlador
        Control ctrl = new Control(plat);
        //creo el visual
        Menu menu = new Menu(ctrl);
        System.out.print("despliego menu\n");
        menu.desplegarMenu();

    }
}
