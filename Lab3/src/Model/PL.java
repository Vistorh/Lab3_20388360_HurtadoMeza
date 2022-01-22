package Model;

import java.util.ArrayList;

public class PL {
    //Atributos
    private ArrayList<Usuario> users;
    private ArrayList<Publicaciones> publis;
    //private ArrayList<Versiones> Vers;
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


}










