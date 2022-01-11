package model;

public class usuario {
    // attributes
    private static Integer idGlobal = 0;
    private Integer id;
    private String nombre;
    private String pass;
    private String fecha;
    private ArrayList<Post> publicaciones;

    // constructor
    public usuario(String nombre, String pass){
        idGlobal = idGlobal + 1;
        this.id = idGlobal;
        this.nombre = nombre;
        this.pass = pass;
        SimpleDateFormat tipo = new SimpleDateFormat("dd/MM/yyyy");
        Date tempDate = new Date();
        this.fecha = tipo.format(tempDate);
        this.publicaciones = new ArrayList<>();

    }
    /**
     * return La id del usuario
     */

    public static Integer getIdGlobal() {
        return idGlobal;
    }


    public static void setIdGlobal(Integer idGlobal) {
        usuario.idGlobal = idGlobal;
    }


    /**
     * return La id del usuario
     */
    public int getId() {
        return id;
    }
    /**
     * param id La id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * return El nombre de usuario
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * param nombre el nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * return La contraseña del usuario
     */
    public String getPPass() {
        return Pass;
    }
    /**
     * param Pass La contraseña
     */

    public void setPass(String Pass) {
        this.Pass = Pass;
    }
    /**
     * return La fecha de creacion del usuario
     */

    public String getFecha() {
        return fecha;
    }
    /**
     * param fecha la fecha de creacion del usuario
     */

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * return publicaciones del usuario
     */

    public ArrayList<Post> getPublicaciones() {
        return publicaciones;
    }
    /**
     * param publicaciones publicaciones del usuario
     */

    public void setPublicaciones(ArrayList<Post> publicaciones) {
        this.publicaciones = publicaciones;
    }

}