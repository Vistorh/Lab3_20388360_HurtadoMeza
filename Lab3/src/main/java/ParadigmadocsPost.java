package main.java;

import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Post {
    // attributes
    private static Integer idGlobal = 0;
    private Integer id;
    private String tipo;
    private String texto;
    private String fecha;
    private ParadigmadocsUser autor;

    private ArrayList<ParadigmadocsUser> Shared;

    // constructor
    public Post(String tipo, String texto){
        idGlobal = idGlobal + 1;
        this.id = idGlobal;
        this.tipo = tipo;
        this.texto = texto;
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipoFecha.format(tempDate);

        ArrayList<String> empty = new ArrayList<>();
        this.Shared = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ParadigmadocsUser getAutor() {
        return autor;
    }

    public void setAutor(ParadigmadocsUser autor) {
        this.autor = autor;
    }

    public ArrayList<ParadigmadocsUser> getShared() {
        return Shared;
    }

    public void setShared(ArrayList<ParadigmadocsUser> shared) {
        Shared = shared;
    }



    // methods



}