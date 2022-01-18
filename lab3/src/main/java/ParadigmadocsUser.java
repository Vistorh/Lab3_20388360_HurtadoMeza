package main.java;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class ParadigmadocsUser {
    private static Integer idGlobalUs = 0;
    private Integer id;
    private String nombre;
    private String pass;
    private String fecha;

    private ArrayList<Post> publicaciones;


    public ParadigmadocsUser(String nombre, String pass) {
        idGlobalUs = idGlobalUs + 1;
        this.id = idGlobalUs;
        this.nombre = nombre;
        this.pass = pass;
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipoFecha.format(tempDate);

        ArrayList<String> empty = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Post> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Post> publicaciones) {
        this.publicaciones = publicaciones;
    }



}




