package Model;

import java.util.ArrayList;

public class Permisos extends ArrayList<Permisos> {

    //atributos
    private Usuario permitido;
    // 0 = escritura, 1 = lectura, 2 = comentario
    private Integer permiso;


    public Permisos(Usuario permitido, Integer permiso) {
        this.permitido = permitido;
        this.permiso = permiso;
    }



    // Getters y Setters

    public Usuario getPermitido() {
        return permitido;
    }

    public void setPermitido(Usuario permitido) {
        this.permitido = permitido;
    }

    public Integer getPermiso() {
        return permiso;
    }

    public void setPermiso(Integer permiso) {
        this.permiso = permiso;
    }

}
