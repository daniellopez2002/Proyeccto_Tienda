    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Bases;

import Modelo.Usuario;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class Main_BD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Bases objBases = new Bases();
        boolean conexion;
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        //Establecer la conexión
        conexion = objBases.crear_conexion();
        
        if (conexion) {
            System.out.println(" ¡Conexión exitosa! ");
            Usuario un = new Usuario("lo", "lo", "lo");
            System.out.println(String.valueOf(un.id));
            boolean crea = objBases.crear_usuario(String.valueOf(un.id) ,"daniel", "pedro.lopez@gmail.com", "panAjo89");
            if (crea){
                System.out.println("Si");
            }else{
                System.out.println("no");
            }
            usuarios = objBases.cargar_usuarios();
            for (Usuario u:usuarios){
                System.out.println(u.toString());
            }
        } else {
            System.out.println(" ¡Conexión fallida! ");
        }
    
}
}