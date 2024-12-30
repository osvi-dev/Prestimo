package prestimo.controllers;

import prestimo.models.local.Usuarios;

public class MainController {
    public static void main(String[] args) {
        Usuarios usuarios = new Usuarios();
        usuarios.insertarUsuario("Osvaldo", "Constantino", "Bautista", "osvi2", "hola3@hola.com");

    }
}
