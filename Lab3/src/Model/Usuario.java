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
    public Integer getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Publicaciones> getPublicacionesRealizadas() {
        return publicacionesRealizadas;
    }
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


}