package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *Clase Publicacion pertenece a model
 *@author Victor Hurtado
 */
public class Publicaciones {
    //atributos
    private static Integer idPublicaciones=0;//ID AUTOINCREMENTAL
    private Integer idPubli;
    private String tituloPubli;
    private String cuerpoPubli;
    private String fechaPubli;
    private Usuario autorPubli;
    private ArrayList<Permisos> compartidos;
    private ArrayList<Versiones> version;

    //constructor
    public Publicaciones(String cuerpo, Usuario autor,String titulo) {
        this.compartidos= new ArrayList<>();
        this version = new ArrayList<>();
        this.cuerpoPubli = cuerpo;
        this.autorPubli = autor;
        this.tituloPubli = titulo;
        idPublicaciones +=1;
        this.idPubli =idPublicaciones;
        //OBTENER LA FECHA CON UTIL.DATE
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.fechaPubli = tipoFecha.format(date);
    }
    //to string de una publicacion
    public String publicacionAstring(){
        //falta agregar los comentarios luego
        return  "Autor: "+autorPubli.getUsername()+" ID publicacion: "+ idPubli+" fecha:"+fechaPubli+"\n"+" cuerpo:"+cuerpoPubli+"\n";

    }

    // Getters and Setters

    public String getCuerpoPubli() {
        return cuerpoPubli;
    }
    public void setCuerpoPubli(String cuerpoPubli) {
        this.cuerpoPubli = cuerpoPubli;
    }

    public String getFechaPubli() {
        return fechaPubli;
    }
    public void setFechaPubli(String fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    public Usuario getAutorPubli() {
        return autorPubli;
    }
    public void setAutorPubli(Usuario autorPubli) {
        this.autorPubli = autorPubli;
    }

    public Integer getIdPubli() {
        return idPubli;
    }
    public void setIdPubli(Integer idPubli) {
        this.idPubli = idPubli;
    }

    public String getTituloPubli() {
        return tituloPubli;
    }
    public void setTituloPubli(String tipoPubli) {
        this.tituloPubli = tituloPubli;
    }

    public ArrayList<Permisos> getCompartidos() { return compartidos; }
    public void setCompartidos(ArrayList<Permisos> compartidos) { this.compartidos = compartidos; }

    public ArrayList<Versiones> getVersion() { return version; }
    public void setVersion(ArrayList<Versiones> version) { this.version = version; }


}
