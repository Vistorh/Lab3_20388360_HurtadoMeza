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
    private ArrayList<String> escritura;
    private ArrayList<String> lectura;
    private ArrayList<String> comentario;
    private ArrayList<Versiones> version;
     /*
    //constructor
    public Publicaciones(String cuerpo, Usuario autor,String titulo,ArrayList<Permisos> compartidos) {
        idPublicaciones +=1;
        this.idPubli =idPublicaciones;
        this.compartidos = compartidos;
        this.version = new ArrayList<>();
        this.cuerpoPubli = cuerpo;
        this.autorPubli = autor;
        this.tituloPubli = titulo;
        //OBTENER LA FECHA CON UTIL.DATE
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        this.fechaPubli = tipoFecha.format(date);
    }*/

    // constructor
    public Publicaciones(String titulo, String texto, Usuario autor){
        idPublicaciones +=1;
        this.idPubli =idPublicaciones;
        this.autorPubli = autor;
        this.tituloPubli = titulo;
        this.cuerpoPubli = texto;
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fechaPubli = tipoFecha.format(tempDate);
        this.escritura = new ArrayList<>();
        this.lectura = new ArrayList<>();
        this.comentario = new ArrayList<>();
        this.version = new ArrayList<>();

    }

    public Publicaciones(String titulo, String texto, Usuario autor, ArrayList<String> escritura, ArrayList<String> lectura, ArrayList<String> comentario){
        idPublicaciones +=1;
        this.idPubli =idPublicaciones;
        this.autorPubli = autor;
        this.tituloPubli = titulo;
        this.cuerpoPubli = texto;
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fechaPubli = tipoFecha.format(tempDate);
        this.escritura = escritura;
        this.lectura = lectura;
        this.comentario = comentario;
        this.version = new ArrayList<>();
    }


    //to string de una publicacion
    public String publicacionAstring(){
        //falta agregar los comentarios luego
        return  "Autor: "+autorPubli.getUsername()+" ID publicacion: "+ idPubli+" fecha:"+fechaPubli+"\n"+" titulo:"+tituloPubli+"\n cuerpo:"+cuerpoPubli+"\n Permiso escritura:"+escritura+"\n"+"Permiso lectura:"+lectura+"\n"+"Permiso comentario:"+comentario+"\n";


    }

    // Getters and Setters

    public String getCuerpoPubli() { return cuerpoPubli; }
    public void setCuerpoPubli(String cuerpoPubli) { this.cuerpoPubli = cuerpoPubli; }

    public String getFechaPubli() { return fechaPubli; }
    public void setFechaPubli(String fechaPubli) { this.fechaPubli = fechaPubli; }

    public Usuario getAutorPubli() { return autorPubli; }
    public void setAutorPubli(Usuario autorPubli) { this.autorPubli = autorPubli; }

    public Integer getIdPubli() { return idPubli; }
    public void setIdPubli(Integer idPubli) { this.idPubli = idPubli; }

    public String getTituloPubli() { return tituloPubli; }
    public void setTituloPubli(String tipoPubli) { this.tituloPubli = tituloPubli; }

    public ArrayList<String> getEscritura() { return escritura; }
    public void setEscritura(ArrayList<String> escritura) { this.escritura = escritura; }

    public ArrayList<String> getLectura() { return lectura; }
    public void setLectura(ArrayList<String> lectura) { this.lectura = lectura; }

    public ArrayList<String> getComentario() { return comentario; }
    public void setComentario(ArrayList<String> comentario) { this.comentario = comentario; }

    public ArrayList<Versiones> getVersion() { return version; }
    public void setVersion(ArrayList<Versiones> version) { this.version = version; }


    /**
     * agrega un usuario a la lista de escritura
     * @param escritura
     */
    public void addEscritura(ArrayList<String> escritura){
        /*
        ArrayList<String> list = getEscritura();
        ArrayList<String> listLectura = getLectura();
        ArrayList<String> listComentario = getComentario();

        for(int i = 0; i < escritura.size(); i++){

            for(int j = 0; j < list.size(); j++) {

                if(escritura.get(i).equals(list.get(j))){
                    break;
                }
            }

        }
        for(int i = 0; i < escritura.size(); i++) {
            for (int j = 0; j < listLectura.size(); j++) {
                if(escritura.get(i).equals(listLectura.get(j))){
                    listLectura.remove(j);
                }else{
                    list.add(escritura.get(i));
                }
            }
        }

        for(int i = 0; i < escritura.size(); i++) {
            for (int j = 0; j < listComentario.size(); j++) {
                if(escritura.get(i).equals(listComentario.get(j))){
                    listLectura.remove(j);
                }else{
                    list.add(escritura.get(i));
                }
            }
        }
        */

        ArrayList<String> list = getEscritura();
        for(int i = 0; i < escritura.size(); i++){
            list.add(escritura.get(i));
        }

        setEscritura(list);
    }

    /**
     * agrega un usuario a la lista de lectura
     * @param lectura
     */
    public void addLectura(ArrayList<String> lectura){
        ArrayList<String> list = getLectura();
        for(int i = 0; i < lectura.size(); i++){
            list.add(lectura.get(i));
        }
        setLectura(list);
    }

    /**
     * agrega un usuario a la lista de comentarios
     * @param comentario
     */
    public void addComentario(ArrayList<String> comentario){
        ArrayList<String> list = getComentario();
        for(int i = 0; i < comentario.size(); i++){
            list.add(comentario.get(i));
        }
        setComentario(list);
    }




}
