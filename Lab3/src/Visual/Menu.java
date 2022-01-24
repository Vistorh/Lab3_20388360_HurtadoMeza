package Visual;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Control.Control;

/**
 * Clase correspondiente a la parte del Visor.
 * Corresponde al menu principal del programa
 * Mediante el cual el usuario interactuara con el programa.
 * @author Victor Hurtado
 */
public class Menu {
    //Atributos
    //se tiene atributo un controlador para acceder a sus metodos
    private Control controlador;
    //Constructor
    /**
     * Crea un menu, usando el controlador.
     * @param //controller Instancia del controlador.
     */

    public Menu(Control controlador) {
        this.controlador = controlador;
    }

    //Getter
    public Control getControlador() {
        return controlador;
    }

    //Metodos

    /**
     * Inicia el menu
     */
    public void desplegarMenu() {
        Scanner input = new Scanner(System.in);
        boolean cerrarMenu = false;
        int opcion;
        String username;
        String password;
        Control ctrl = getControlador();
        while(!cerrarMenu){

            if(!(ctrl.existeOnline())){//reviso online para que se registre o se loge
                //si hay alguien online entonces omito lo del if y entro en el else
                System.out.println("### Bienvenido a Google Docs ###");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. LOGEARSE");
                System.out.println("2. REGISTRARSE");
                System.out.println("3. VISUALIZAR PLATAFORMA");
                System.out.println("4. SALIR");;

                try {
                    System.out.println("Eliga una opcion ");
                    opcion = input.nextInt();
                    switch (opcion){
                        case 1:
                            System.out.println("Login\n");
                            System.out.println("Ingrese su nombre de usuario:");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese su contraseña:");
                            password = input.nextLine();
                            ctrl.login(username,password);
                            break;

                        case 2:
                            System.out.println("Register\n");
                            System.out.println("Ingrese su nombre de usuario:");
                            input.nextLine();
                            username = input.nextLine();
                            System.out.println("Ingrese su contraseña:");
                            password = input.nextLine();
                            ctrl.register(username,password);
                            break;

                        case 3: //visualizar
                            ctrl.visualize();
                            break;

                        case 4: //Salir del programa
                            System.out.println("Saliendo");
                            cerrarMenu = true;
                            break;
                        default:
                            System.out.println("opcion no valida");
                            break;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Solo se admiten numeros dentro del menu");
                    input.next();
                }
            } else {
                System.out.println("### Bienvenido a GoogleDocs###");//agregar nombre de la PL
                System.out.println("## Registrado como: "+ ctrl.entregarOnline().getUsername()+ " ##");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. Crear nuevo documento");
                System.out.println("2. Compartir documento");
                System.out.println("3. Agregar contenido a un documento");
                System.out.println("4. Restaurar versión de un documento");
                System.out.println("5. Visualizar usuario");
                System.out.println("6. Cerrar sesión");
                System.out.println("7. Salir del programa");


                try {
                    System.out.println("Introduzca su opción: ");
                    opcion = input.nextInt();
                    switch (opcion){
                        case 1: //publicar-> post
                            System.out.println("Ingrese el titulo de su Publicacion:");
                            input.nextLine();
                            String tituloPubli = input.nextLine();
                            System.out.println("Ingrese el contenido de su Publicacion:");
                            String contenido = input.nextLine();
                            ctrl.post(tituloPubli, contenido);
                            break;

                        case 2: // share
                            System.out.println("Ingrese la ID de la publicacion");
                            Integer idACompartir = input.nextInt();
                            ArrayList<String> listaTags = new ArrayList<>();
                            System.out.println("Ingrese la cantidad de personas que desee que tengan permisos:");
                            int cantTags = input.nextInt();
                            System.out.println("Cantidad de etiquetados seleccionada: "+cantTags);
                            for (int i = 0; i < cantTags; i++) {
                                System.out.println("Ingrese el usuario numero "+ (i+1));
                                input.nextLine();
                                String tag = input.nextLine();
                                listaTags.add(tag);
                            }
                            System.out.println("Ingrese el tipo de permiso que desee otorgar: ");
                            System.out.println("ingrese 1 para escritura ");
                            System.out.println("ingrese 2 para lectura ");
                            System.out.println("ingrese 3 para comentario ");
                            Integer permiso = input.nextInt();
                            // discriminamos el caso en que haya etiquetados o no
                            if (cantTags == 0) {
                                System.out.println("no a ingresado ningun etiquetado ");
                                break;
                            }else{
                                ctrl.share(idACompartir,listaTags,permiso);
                            }
                            break;

                        case 3: //add
                            System.out.println("Ingrese la ID de la publicacion");
                            Integer idAgregar = input.nextInt();
                            System.out.println("Ingrese el contenido que desea agregar al documento:");
                            input.nextLine();
                            String textoAgregar = input.nextLine();
                            ctrl.agregarTexto(idAgregar, textoAgregar);
                            break;

                        case 4: //rollback
                            System.out.println("Ingrese la ID del documento que desee restaurar");
                            Integer idRestaurar = input.nextInt();
                            System.out.println("Ingrese la ID que de la version a la que desea restaurar:");
                            Integer idVersion = input.nextInt();
                            ctrl.rollback(idRestaurar, idVersion);
                            break;

                        case 5: //visualizar
                            ctrl.visualize();
                            break;

                        case 6://cerrar sesion ->logout
                            System.out.println("Sesion cerrada.\n");
                            //Logout
                            ctrl.logout();
                            break;
                        case 7://salir del programa ->cerrar menu
                            System.out.println("Saliendo del programa\n");
                            cerrarMenu = true;
                            break;
                        default:
                            System.out.println("opcion no valida\n");
                            break;
                    }
                } catch (InputMismatchException e){
                    System.out.println("Solo se admiten numeros dentro del menu");
                    input.next();
                }
            }
        }
        input.close();
    }
}
