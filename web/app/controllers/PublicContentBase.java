package controllers;


import helpers.HashUtils;
import models.User;
import play.mvc.Controller;

public class PublicContentBase extends Controller {

    public static void register(){
        render();
    }
    
    //Modificado por Angeles de Miguel para Modulo8 Tarea4, de forma que username y password han de tener 
    //al menos una longitud de 8 caracteres. Tambien se comprueba que username y password no sean iguales
    public static void processRegister(String username, String password, String passwordCheck, String type){
        if (username.length()>=8 && password.length()>=8 && !username.equalsIgnoreCase(password)){
            User u = new User(username, HashUtils.getMd5(password), type, -1);
            u.save();
            registerComplete();
        }
    }

    public static void registerComplete(){
        render();
    }
}
