package main;


import Classes.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Agustin");
        Usuario usuario2 = new Usuario("Ailen");
        System.out.println(usuario1.getId());
        System.out.println(usuario2.getId());
        System.out.println(usuario1.getMaxId());
        
    }
}