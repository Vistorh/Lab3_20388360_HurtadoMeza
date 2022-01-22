package Visual;
import java.util.ArrayList;
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
     * @param controller Instancia del controlador.
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
                System.out.println("### Bienvenido a Wibogram ###");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. LOGEARSE");
                System.out.println("2. REGISTRARSE");
                System.out.println("3. VISUALIZAR RED SOCIAL");
                System.out.println("4. SALIR");

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
                            ctrl.register(username, password);

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
                System.out.println("### Bienvenido a Wibogram ###");//agregar nombre de la RS
                System.out.println("## Registrado como: "+ ctrl.entregarOnline().getUsername()+ " ##");
                System.out.println("Escoja la opción que desea realizar: ");
                System.out.println("1. Realizar publicación");
                System.out.println("2. Seguir a un usuario");
                System.out.println("3. Compartir publicación");
                System.out.println("4. Visualizar red social");
                System.out.println("5. Likear");
                System.out.println("6. Comentar");
                System.out.println("7. Cerrar sesión");
                System.out.println("8. Salir del programa");


                try {
                    System.out.println("Introduzca su opción: ");
                    opcion = input.nextInt();
                    switch (opcion){
                        case 1: //publicar-> post
                            System.out.println("Ingrese el tipo de su Publicacion:");
                            input.nextLine();
                            String tipoPost = input.nextLine();
                            System.out.println("Ingrese el contenido de su Publicacion:");
                            String contenido = input.nextLine();
                            System.out.println("¿Cuantos etiquetados tendra?, 0 si no desea etiquetar a nadie");
                            Integer canEt = input.nextInt();
                            if(canEt==0){
                                //si no etiqueta creo la publicacion con etiquetaos vacios y listo
                                ArrayList<String> et = new ArrayList<>();
                                //Se llama a post
                                ctrl.post(tipoPost, contenido,et);
                                break;
                            }
                            else{
                                //si etiqueta creo una lista de tamanio cantET y agrego uno a uno los etiquetados
                                int i;
                                ArrayList<String> et = new ArrayList<>();
                                for(i=0;i<canEt;i++){
                                    System.out.println("Ingrese el nombre del usuario a etiquetar:");
                                    input.nextLine();
                                    String userET = input.nextLine();
                                    et.add(userET);
                                }
                                //Se llama a post
                                ctrl.post(tipoPost, contenido,et);
                                break;
                            }
                        case 2://seguir -> follow
                            System.out.println("Ingrese el nombre del usuario a seguir:");
                            input.nextLine();
                            String userET = input.nextLine();
                            ctrl.follow(userET);
                            break;
                        case 3://compartir->share
                            System.out.println("cual es la id del post que desea compartir:");
                            input.nextLine();
                            Integer idPost = input.nextInt();
                            System.out.println("¿Cuantos etiquetados tendra?, 0 si no desea etiquetar a nadie:");
                            input.nextLine();
                            Integer canEt2 = input.nextInt();
                            if(canEt2==0){
                                //si no etiqueta creo la publicacion con etiquetaos vacios y listo
                                ArrayList<String> et = new ArrayList<>();
                                ctrl.share(idPost, et);
                                break;
                            }
                            else{
                                //si etiqueta creo una lista de tamanio cantET y agrego uno a uno los etiquetados
                                int i;
                                ArrayList<String> et = new ArrayList<>();
                                for(i=0;i<canEt2;i++){
                                    System.out.println("Ingrese el nombre del usuario a etiquetar:");
                                    input.nextLine();
                                    String userET2 = input.nextLine();
                                    et.add(userET2);
                                }
                                ctrl.share(idPost, et);
                                break;
                            }
                        case 4://visualuzar ->visualize
                            System.out.println("debo llamar a visualize\n");
                            ctrl.visualize();
                            break;
                        case 5://like
                            System.out.println("Si su like es a un comentario debe agregar un 0 en la id de la publicacion");
                            System.out.println("Si su like es a una publicacion debe agregar un 0 en la id del comentario");
                            System.out.println("Id Publicacion");
                            input.nextLine();
                            Integer idPubliLIKE = input.nextInt();
                            System.out.println("Id Comentario");
                            input.nextLine();
                            Integer idComentLIKE= input.nextInt();
                            ctrl.like(idPubliLIKE, idComentLIKE);
                            break;
                        case 6://comentar
                            System.out.println("Si su comentario es a un comentario debe agregar un 0 en la id de la publicacion");
                            System.out.println("Si su comentario es a una publicacion debe agregar un 0 en la id del comentario");
                            System.out.println("Id Publicacion");
                            input.nextLine();
                            Integer idPubliComent = input.nextInt();
                            System.out.println("Id Comentario");
                            input.nextLine();
                            Integer idComentComent= input.nextInt();
                            System.out.println("Ingrese el comentario:");
                            input.nextLine();
                            String textoComentario = input.nextLine();
                            ctrl.comment(idPubliComent,idComentComent,textoComentario);
                            break;
                        case 7://cerrar sesion ->logout
                            System.out.println("Sesion cerrada.\n");
                            //Logout
                            ctrl.logout();
                            break;
                        case 8://salir del programa ->cerrar menu
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
