package main;

public class ParadigmadocsUser {
    private Integer id;
    private String nombre;
    private String pass;
    private String fecha;
    //private ArrayList<Post> publicaciones;


    public ParadigmadocsUser(Integer id, String nombre, String pass, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.pass = pass;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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



}
