package main;

public class Main {
    public static void main(String[] args){
        Socialnetwork redSocial = new Paradigmadocs("LMAOBOOK");

        Controller controlador = new Conntrolador(plataforma);

        Menu menu = new Menu(controlador);

        menu.ejecutarMenu();

    }
    
}