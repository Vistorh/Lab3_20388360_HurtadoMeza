package Model;

public class Versiones {
    //atributos
    private Integer idPubli;
    private String tituloPubli;
    private String cuerpoPubli;
    private String fechaPubli;
    private Usuario autorPubli;

    public Versiones(Integer idPubli, String tituloPubli, String cuerpoPubli, String fechaPubli, Usuario autorPubli) {
        this.idPubli = idPubli;
        this.tituloPubli = tituloPubli;
        this.cuerpoPubli = cuerpoPubli;
        this.fechaPubli = fechaPubli;
        this.autorPubli = autorPubli;
    }

    // Getter and Setters

    public Integer getIdPubli() {return idPubli; }
    public void setIdPubli(Integer idPubli) { this.idPubli = idPubli; }

    public String getTituloPubli() { return tituloPubli; }
    public void setTituloPubli(String tituloPubli) { this.tituloPubli = tituloPubli; }

    public String getCuerpoPubli() { return cuerpoPubli; }
    public void setCuerpoPubli(String cuerpoPubli) { this.cuerpoPubli = cuerpoPubli; }

    public String getFechaPubli() { return fechaPubli; }
    public void setFechaPubli(String fechaPubli) { this.fechaPubli = fechaPubli; }

    public Usuario getAutorPubli() { return autorPubli; }
    public void setAutorPubli(Usuario autorPubli) { this.autorPubli = autorPubli; }



}
