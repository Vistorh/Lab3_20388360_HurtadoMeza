package main;

import java.util.ArrayList;
import java.util.List;

public class Paradigmadocs{

    private List<ParadigmadocsUser> users;
    private String name;
   // private String fecha;
    //private User UsuarioOnline;

    public Paradigmadocs(String name) {
        this.users = new ArrayList<>();
        this.name = name;
        //this.fecha;
    }

    public List<ParadigmadocsUser> getUsers() {
        return users;
    }

    public void setUsers(List<ParadigmadocsUser> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    */
    @Override
    public String toString() {
        return "Paradigmadocs{" +
                "users=" + users +
                ", name='" + name + '\'' +
                '}';
    }







}
