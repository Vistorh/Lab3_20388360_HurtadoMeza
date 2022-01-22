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
     *metodo para desconectar a un usuario de la red social
     */
    //funcion logut (parte de authentication)
    public void logout(){
        PL plat = getPlataforma();
        plat.setConectado(false);
        //al cambiar este booleano a false, simboliza que no hay nadie conectado, sin embargo la var
        //userOn seguira manteniendo al ultimo usuario que se logeo
    }

    /**
     * funcion que permite crear una publicacion
     * @param titulo String que simboliza el titulo del documento
     * @param contenido contenido de la publicacion
     */
    //funcion post
    public void post(String titulo, String contenido){
        PL plat = getPlataforma();
        //creo la publicacion
        Usuario autor = plat.getUserOn();
        Publicaciones publi = new Publicaciones(contenido, autor, titulo);
        //agrego la publicacion al usuario online
        autor.getPublicacionesRealizadas().add(publi);
        //agrego la publicacion a la lista de publicaciones totales de  la RS
        plat.getPublis().add(publi);
        //entrego un mensaje para que el usuario sepa que su publicacion fue agregada
        System.out.println("Publicado\n");
    }

    /**
     * funcion que permite compartir una publicacion
     * @param idPost id del post que se quiere compartir
     * @param etiquetados lista de gente con la que se comparte, como los etiquetados en facebook
     */
    //funcion share
    public void share(Integer idPost,ArrayList<String> etiquetados){
        RS redS = getRedSocial();
        Usuario online= redS.getUserOn();
        int i;
        for (i = 0; i < redS.getPublis().size();i++){
            if(redS.getPublis().get(i).getIdPubli()==idPost) {
                //modifico la publicacion haciendo cantCompartidas+1
                Publicaciones publi = redS.getPublis().get(i);
                publi.aumentarComp();
                redS.getPublis().set(i,publi);
                //la agrego a la lista de compartidos del usuario
                online.agregarCompartidaUser(publi, etiquetados);
                redS.getUsers().set((online.getIdUser()-1), online);
                System.out.println("Publicacion compartida\n");
                return;//utilizo el return para cerrar el ciclo
            }
        }
        //si no encuentro el user entonces no hago nada
        System.out.println("Publicacion inexistente\n");
    }





