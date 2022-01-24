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

    public Publicaciones(String titulo, String texto, Usuario autor, ArrayList<String> escritura, ArrayList<String> lectura, ArrayList<String> comentario, ArrayList<Versiones> versionesAnteriores){
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
        this.version = versionesAnteriores;
    }


    public Publicaciones(Integer id,String titulo, String texto, Usuario autor, ArrayList<String> escritura, ArrayList<String> lectura, ArrayList<String> comentario, ArrayList<Versiones> versionesAnteriores){
        this.idPubli =id;
        this.autorPubli = autor;
        this.tituloPubli = titulo;
        this.cuerpoPubli = texto;
        SimpleDateFormat tipoFecha = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fechaPubli = tipoFecha.format(tempDate);
        this.escritura = escritura;
        this.lectura = lectura;
        this.comentario = comentario;
        this.version = versionesAnteriores;
    }

    //to string de una publicacion
    public String publicacionAstring(){
        //falta agregar los comentarios luego
        return  "Autor: "+autorPubli.getUsername()+" ID publicacion: "+ idPubli+" fecha:"+fechaPubli+"\n"+" titulo:"+tituloPubli+"\n cuerpo:"+cuerpoPubli+"\n Permiso escritura:"+escritura+"\n"+"Permiso lectura:"+lectura+"\n"+"Permiso comentario:"+comentario+"\n"+"Cantidad de Versiones: "+(getVersion().size())+"\n";


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



    // metodos

    /**
     * agrega un usuario a la lista de escritura
     * @param escritura
     */
    public void addEscritura(ArrayList<String> escritura){
      ArrayList<String> listEscritura = getEscritura();
      ArrayList<String> listLectura = getLectura();
      ArrayList<String> listComentario = getComentario();
      Integer comprobar = 0;

      for(int i = 0; i < escritura.size(); i++){
          for(int j = 0; j < listLectura.size(); j++){
              if (escritura.get(i).equals(listLectura.get(j))){
                  listLectura.remove(j);
              }
          }
      }

        for(int i = 0; i < escritura.size(); i++){
            for(int j = 0; j < listComentario.size(); j++){
                if (escritura.get(i).equals(listComentario.get(j))){
                    listComentario.remove(j);
                }
            }
        }

        for(int i = 0; i < escritura.size(); i++){
            for(int j = 0; j < listEscritura.size(); j++){
                if (escritura.get(i).equals(listEscritura.get(j))){
                    comprobar = 1;
                    continue;
                }
            }
            if(comprobar!=1){
                listEscritura.add(escritura.get(i));
            }
        }
        setEscritura(listEscritura);
    }

    /**
     * agrega un usuario a la lista de lectura
     * @param lectura
     */
    public void addLectura(ArrayList<String> lectura){
        ArrayList<String> listEscritura = getEscritura();
        ArrayList<String> listLectura = getLectura();
        ArrayList<String> listComentario = getComentario();
        Integer comprobar = 0;

        for(int i = 0; i < lectura.size(); i++){
            for(int j = 0; j < listEscritura.size(); j++){
                if (lectura.get(i).equals(listEscritura.get(j))){
                    listEscritura.remove(j);
                }
            }
        }

        for(int i = 0; i < lectura.size(); i++){
            for(int j = 0; j < listComentario.size(); j++){
                if (lectura.get(i).equals(listComentario.get(j))){
                    listComentario.remove(j);
                }
            }
        }

        for(int i = 0; i < lectura.size(); i++){
            for(int j = 0; j < listLectura.size(); j++){
                if (lectura.get(i).equals(listLectura.get(j))){
                    comprobar = 1;
                    continue;
                }
            }
            if(comprobar!=1){
                listLectura.add(lectura.get(i));
            }
        }
        setLectura(listLectura);
    }

    /**
     * agrega un usuario a la lista de comentarios
     * @param comentario
     */
    public void addComentario(ArrayList<String> comentario){
        ArrayList<String> listEscritura = getEscritura();
        ArrayList<String> listLectura = getLectura();
        ArrayList<String> listComentario = getComentario();
        Integer comprobar = 0;

        for(int i = 0; i < comentario.size(); i++){
            for(int j = 0; j < listLectura.size(); j++){
                if (comentario.get(i).equals(listLectura.get(j))){
                    listLectura.remove(j);
                }
            }
        }

        for(int i = 0; i < comentario.size(); i++){
            for(int j = 0; j < listComentario.size(); j++){
                if (comentario.get(i).equals(listComentario.get(j))){
                    listComentario.remove(j);
                }
            }
        }

        for(int i = 0; i < comentario.size(); i++){
            for(int j = 0; j < listComentario.size(); j++){
                if (comentario.get(i).equals(listComentario.get(j))){
                    comprobar = 1;
                    continue;
                }
            }
            if(comprobar!=1){
                listComentario.add(comentario.get(i));
            }
        }
        setComentario(listComentario);
    }

    /**
     * agrega una publicacion a la lista de versiones
     * @param version
     */
    public void addPostVersion(Versiones version){
        ArrayList<Versiones> list = getVersion();
        list.add(version);
        setVersion(list);
    }




}
