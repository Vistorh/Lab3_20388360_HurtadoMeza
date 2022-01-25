package Model;
import java.util.ArrayList;

/**
 *Clase Versiones pertenece al modelo y es el encargado del historial
 *@author Victor Hurtado
 */

public class Versiones extends ArrayList<Versiones> {
    //atributos
    private Integer idPubli;
    private String tituloPubli;
    private String cuerpoPubli;
    private String fechaPubli;
    private Usuario autorPubli;
    private ArrayList<String> escritura;
    private ArrayList<String> lectura;
    private ArrayList<String> comentario;

    public Versiones(Integer idPubli, String tituloPubli, String cuerpoPubli, String fechaPubli, Usuario autorPubli, ArrayList<String> escritura, ArrayList<String> lectura, ArrayList<String> comentario){
        this.idPubli = idPubli;
        this.tituloPubli = tituloPubli;
        this.cuerpoPubli = cuerpoPubli;
        this.fechaPubli = fechaPubli;
        this.autorPubli = autorPubli;
        this.escritura = escritura;
        this.lectura = lectura;
        this.comentario = comentario;
    }



    // Getter and Setters

    public Integer getIdPubli() {return idPubli; }
    public void setIdPubli(Integer idPubli) { this.idPubli = idPubli; }

    public String getTituloPubli() { return tituloPubli; }
    public void setTituloPubli(String tituloPubli) { this.tituloPubli = tituloPubli; }

    public String getCuerpoPubli() { return cuerpoPubli; }
    public void setCuerpoPubli(String cuerpoPubli) { this.cuerpoPubli = cuerpoPubli; }

    public String getFechaPubliV() { return fechaPubli; }
    public void setFechaPubliV(String fechaPubli) { this.fechaPubli = fechaPubli; }

    public Usuario getAutorPubli() { return autorPubli; }
    public void setAutorPubli(Usuario autorPubli) { this.autorPubli = autorPubli; }

    public ArrayList<String> getEscritura() {return escritura;}
    public void setEscritura(ArrayList<String> escritura) {this.escritura = escritura;}

    public ArrayList<String> getLectura() {return lectura;}
    public void setLectura(ArrayList<String> lectura) {this.lectura = lectura;}

    public ArrayList<String> getComentario() {return comentario;}
    public void setComentario(ArrayList<String> comentario) {this.comentario = comentario;}



}
