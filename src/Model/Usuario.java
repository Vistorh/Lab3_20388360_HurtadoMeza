package Model;

import java.util.ArrayList;
/**
 *Clase usuario pertenece al modelo
 *@author Victor Hurtado
 */

public class Usuario {
    //atributos
    private static Integer idUsuarios =0;
    private Integer idUser;
    private String username;
    private String password;
    private ArrayList<Publicaciones> publicacionesRealizadas;

    //constructor
    public Usuario(String username, String password) {
        idUsuarios +=1;
        this.idUser = idUsuarios;
        this.username = username;
        this.password = password;
        this.publicacionesRealizadas = new ArrayList<>();
    }

    //getters y setters
    /**
     * @return Integer con Id del usuario
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * @return String nombre del usuario
     */
    public String getUsername() {
        return username;
    }
    /**
     * @param Nombre en String del usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String pass del usuario
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param pass en String del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return ArrayList de publis
     */
    public ArrayList<Publicaciones> getPublicacionesRealizadas() {
        return publicacionesRealizadas;
    }
    /**
     * @param publicaciones ArrayList con publis
     */
    public void setPublicacionesRealizadas(ArrayList<Publicaciones> publicacionesRealizadas) {
        this.publicacionesRealizadas = publicacionesRealizadas;
    }


    //metodos

    /**
     * Metodo que permite agregar una publicacion
     * @param publi una publi
     */
    public void agregarPubliUser(Publicaciones publi){
        ArrayList<Publicaciones> listaPublisUser = getPublicacionesRealizadas();
        listaPublisUser.add(publi);
        setPublicacionesRealizadas(listaPublisUser);
    }

    //usuario a string
    public String userAstring(){
        return "Nombre:"+username+" Tienes un total de:"+publicacionesRealizadas.size()+"publicaciones realizadas\n";
    }

    /**
     * Agrega una publicacion a la lista de publicaciones del usuario
     * @param publicacion
     */
    public void addUserPost(Publicaciones publicacion){
        ArrayList<Publicaciones> list = getPublicacionesRealizadas();
        list.add(publicacion);
        setPublicacionesRealizadas(list);

    }


}