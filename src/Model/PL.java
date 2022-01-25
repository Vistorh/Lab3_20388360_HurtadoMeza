package Model;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *Clase plataforma pertenece al modelo
 *@author Victor Hurtado
 */
public class PL {
    //Atributos
    private ArrayList<Usuario> users;
    private ArrayList<Publicaciones> publis;
    private String name;
    private Usuario userOn;
    private boolean conectado = false;

    //constructor
    /*
     * constructor de la RS, no necesita parametros para inicializarce
     *
     */
    public PL() {
        //creo la RS con sus 3 arrays
        this.publis = new ArrayList<>();
        //this.Vers=new ArrayList<>();
        this.users = new ArrayList<>();
    }

    //getters
    /**
     * @return ArrayList de publis
     */
    public ArrayList<Publicaciones> getPublis() {
        return publis;
    }

    /**
     * @return ArrayList de users
     */
    public ArrayList<Usuario> getUsers() {
        return users;
    }

    /**
     * @return el Usuario conectado
     */
    public Usuario getUserOn() {
        return userOn;
    }

    /**
     * @return boolean si alguien esta online
     */
    public boolean isConectado() {
        return conectado;
    }

    //setters
    /**
     * @param publicaciones ArrayList con publis
     */
    public void setPublis(ArrayList<Publicaciones> publis) {
        this.publis = publis;
    }

    /**
     * @param users ArrayList
     */
    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }

    /**
     * @param usuario online
     */
    public void setUserOn(Usuario userOn) {
        this.userOn = userOn;
    }

    /**
     * @param saber si alguien esta online
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }


    /**
     * agrega una publicacion a la lista de publicaciones
     * @param publicacion
     */
    public void addPostPL(Publicaciones publicacion){
        ArrayList<Publicaciones> list = getPublis();
        list.add(publicacion);
        setPublis(list);
    }

    /**
     * Creacion del string que se mostrara al realizar la funcion visualizar
     * @return String con los datos.
     */
    //metodo que permite visualizar la totalidad de la PL paradigmadocstostring
    public String plToString(){
        //esta funcion genera dos tipos de Strings, el primero con un usuario logeado y el segundo sin el usuario logeado
        int i;
        int j;
        //usuario logeado
        if(conectado){//si hay alguien conectado entonces entrego solo lo correspondiente a este usuario
            //vista personal
            String strFinal="### Bienvenido a Google Docs ###\n"+"##Registrado como: "+ userOn.getUsername()+ " ##\n"+"###Tus publicaciones ###\n";
            for(i=0;i<userOn.getPublicacionesRealizadas().size();i++){
                strFinal=strFinal+userOn.getPublicacionesRealizadas().get(i).publicacionAstring()+"\n\n";
            }
            for(Publicaciones P:getPublis()){
                if(PermisoEscritura(userOn.getUsername(),getPublis())){
                    strFinal = strFinal + P.publicacionAstring();
                }
                if(PermisoLectura(userOn.getUsername(),getPublis())){
                    strFinal = strFinal + P.publicacionAstring();
                }
                if(PermisoComentario(userOn.getUsername(),getPublis())){
                    strFinal = strFinal + P.publicacionAstring();
                }
            }
            return strFinal;
        }//usuario sin logear
        else{//si no hay nadie conectado entonces entrego una vista general de la RS
            //
            String strFinal2;
            strFinal2="### Bienvenido a Google Docs ###\n"+"### Actualmente contamos con "+(getUsers().size())+" usuarios registrados ###\n";
            //en caso de que la cantidad de publicaciones sea mayor que 0 entonces las mostrare
            if(getPublis().size() > 0){
                strFinal2=strFinal2+"### Mira lo ultimo que se ha publicado ###\n";
                for(i=0;i<getPublis().size();i++){
                    strFinal2=strFinal2+getPublis().get(i).publicacionAstring()+"\n";
                }
            }
            if(getPublis().size() == 0) {
                strFinal2 = strFinal2 + "### Aun no existen documentos en la plataforma ###\n";
            }
            return strFinal2;
        }

    }

    /**
     * comprobacion de que exista en la lista de escritura
     * @return true o false
     */
    private boolean PermisoEscritura(String user,ArrayList<Publicaciones> publica){
        for(int i =0;i < publica.size(); i++){
            if( publica.get(i).getEscritura().contains(user)){
                return true;
            }
        }
        return false;
    }

    /**
     * comprobacion de que exista en la lista de lectura
     * @return true o false
     */
    private boolean PermisoLectura(String user,ArrayList<Publicaciones> publica){
        for(int i =0;i < publica.size(); i++){
            if( publica.get(i).getLectura().contains(user)){
                return true;
            }
        }
        return false;
    }

    /**
     * comprobacion de que exista en la lista de comentario
     * @return true o false
     */
    private boolean PermisoComentario(String user,ArrayList<Publicaciones> publica){
        for(int i =0;i < publica.size(); i++){
            if( publica.get(i).getComentario().contains(user)){
                return true;
            }
        }
        return false;
    }



}










