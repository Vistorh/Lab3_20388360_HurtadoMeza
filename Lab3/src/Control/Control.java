package Control;
import Model.*;
import java.util.ArrayList;

/**
 *clase  correspondiente al controlador
 *en esta clase esta la mayoria de metodos solicitados
 * @author Victor Hurtado
 */
public class Control {
    //atributos
    //el control tiene como atributos las clases del modelo
    //modelo
    private PL plataforma;
    //constructor
    public Control(PL plataforma) {
        this.plataforma = plataforma;
    }

    //getters
    public PL getPlataforma() {
        return plataforma;
    }

    //metodos
    //ahora creare los metodos solicitados en el laboratorio

    /**
     * revisar si existe algun usuario online
     * @return  true o false
     */
    public boolean existeOnline(){
        PL plataforma =getPlataforma();
        return plataforma.isConectado();
    }
    /**
     * retorna el usuario conectado
     * @return  un usuario
     */
    public Usuario entregarOnline(){
        PL plataforma =getPlataforma();
        return plataforma.getUserOn();
    }


    //metodos importantes
    /**
     *metodo que permite registrarse si el nombre es valido
     * @param username es el nombre del usuario
     * @param pass contraseña del usuario
     */
    //funcion register (parte de authentication)
    public void register(String username,String pass){
        PL plat = getPlataforma();
        int i;
        for (i = 0; i < plat.getUsers().size();i++){
            if (plat.getUsers().get(i).getUsername().equals(username)) {
                System.out.println("Nickname no disponible\n");
                return;//utilizo el return para cerrar el ciclo
            }
        }
        Usuario nUser = new Usuario(username, pass);
        plat.getUsers().add(nUser);
        System.out.println("Registrado con exito\n");
    }

    /**
     *metodo que permite logearse si los datos de ingreso son validos
     * @param username es el nombre del usuario
     * @param pass contraseña del usuario
     */
    //funcion login (parte de authentication)
    public void login(String username,String pass){
        PL plat = getPlataforma();
        int i;
        for (i = 0; i < plat.getUsers().size();i++) {
            ///recorro la lista de users, comparando con cada uno nombre y pass
            if ( plat.getUsers().get(i).getUsername().equals(username) && plat.getUsers().get(i).getPassword().equals(pass) ) {
                //si encuentro un usuario con ese nombre y contraseña entonces lo logeo
                //establezco el booleano en conectado true y cambio el usuario userOn
                plat.setConectado(true);
                plat.setUserOn(plat.getUsers().get(i));
                return;//utilizo el return para cerrar el ciclo
            }
        }
        //si no encuentro el user entonces le digo que algun dato esta mal
        System.out.println("Alguno dato es incorrecto\n");
    }

    /**
     *metodo para desconectar a un usuario de la plataforma
     */
    //funcion logut (parte de authentication)
    public void logout(){
        PL plat = getPlataforma();
        plat.setConectado(false);
        //al cambiar este booleano a false, simboliza que no hay nadie conectado, sin embargo la var
        //userOn seguira manteniendo al ultimo usuario que se logeo
    }

    /**
     * Permite crear una publicacion dentro de la red social
     * @param titulo el tipo de publicacion
     * @param contenido el contenido como texto de la publicacion
     */
    public void post(String titulo, String contenido){
        PL plataforma = getPlataforma();
        Usuario autor = plataforma.getUserOn();
        // creamos la publicacion
        Publicaciones newPost = new Publicaciones(titulo, contenido, autor);
        // agregamos la pregunta a la plataforma
        plataforma.getPublis().add(newPost);
        // se agrega la publicacion a la lista de publicaciones del usuario
        autor.getPublicacionesRealizadas().add(newPost);
        System.out.println("Se a subido el documento con exito");

    }


    /**
     * permite otorgar permisos dada una id, permisos y los nombres
     * @param id de la publicacion a compartir
     * @param listaTags lista de los etiquetados
     * @param permiso el permiso otorgado
     */
    public void share(Integer id,ArrayList<String> listaTags,Integer permiso){
        PL plataforma = getPlataforma();
        Integer counter = 0;
        Usuario userConectado = plataforma.getUserOn();
        ArrayList<String> listaFinal = new ArrayList<>();
        // verificamos que los etiquetados existan en la plataforma
        for (int i = 0; i < listaTags.size(); i++) {
            for (int j = 0; j < plataforma.getUsers().size(); j++) {
                if (plataforma.getUsers().get(j).getUsername().equals(listaTags.get(i))) {
                    listaFinal.add(plataforma.getUsers().get(j).getUsername());
                    counter++;
                }
            }
        }
        // si se encontro que no existia ninguno se le informa al usuario
        if (counter == 0) {
            System.out.println("ninguno de los usuarios etiquetados existe, intentelo nuevamente");
            return;
        }
        // buscamos si la publicacion existe
        for (int i = 0; i < plataforma.getPublis().size(); i++) {
            if (plataforma.getPublis().get(i).getIdPubli() == id) {
                if (plataforma.getPublis().get(i).getAutorPubli().equals(userConectado)) {
                    if (permiso == 1) {
                        //plataforma.getPublis().get(i).setEscritura(listaTags);
                        plataforma.getPublis().get(i).addEscritura(listaFinal);
                        System.out.println("Publicacion compartida con exito!");
                        return;
                    }
                    if (permiso == 2) {
                        //plataforma.getPublis().get(i).setLectura(listaTags);
                        plataforma.getPublis().get(i).addLectura(listaFinal);
                        System.out.println("Publicacion compartida con exito!");
                        return;
                    } if(permiso == 3) {
                        //plataforma.getPublis().get(i).setComentario(listaTags);
                        plataforma.getPublis().get(i).addComentario(listaFinal);
                        System.out.println("Publicacion compartida con exito!");
                        return;
                    }else {
                        System.out.println("no a otorgado ninguno de los 3 permisos antes mencionados");
                        return;
                    }
                }else{
                    for(int j = 0; j < plataforma.getPublis().get(i).getEscritura().size(); j++) {
                        String conectado = plataforma.getUserOn().getUsername();
                        if (plataforma.getPublis().get(i).getEscritura().get(j).equals(conectado)) {
                            if (permiso == 1) {
                                plataforma.getPublis().get(i).addEscritura(listaFinal);
                                System.out.println("Publicacion compartida con exito!");
                                return;
                            }
                            if (permiso == 2) {
                                plataforma.getPublis().get(i).addLectura(listaFinal);
                                System.out.println("Publicacion compartida con exito!");
                                return;
                            } if(permiso == 3) {
                                plataforma.getPublis().get(i).addComentario(listaFinal);
                                System.out.println("Publicacion compartida con exito!");
                                return;
                            }else {
                                System.out.println("no a otorgado ninguno de los 3 permisos antes mencionados");
                                return;
                            }
                        }
                    }
                    System.out.println("El usuario probablemente no cuenta con el permiso necesario :(");
                    return;
                }
            }
        }
        System.out.println("La publicacion con la ID "+id+" no fue encontrada en la plataforma :(");
    }








    /**
     * funcion que permite visualizar la plataforma
     * esta funcion no requiere parametros para ser utilizada
     */
    //funcion visualize
    public void visualize(){
        //esta funcion llama a las funciones snToString y a printSN
        PL plat = getPlataforma();
        String str = plat.snToString();
        System.out.println(str);
    }


}










