    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Bases;

import Modelo.Producto;
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
        ArrayList<Producto> productos = new ArrayList<>();
        
        //Establecer la conexión
        conexion = objBases.crear_conexion();
        
        if (conexion) {
            System.out.println(" ¡Conexión exitosa! ");
////            boolean crea = objBases.crear_usuario(String.valueOf(un.id) ,"daniel", "pedro.lopez@gmail.com", "panAjo89");
//            boolean crea = objBases.crear_producto("4", "maracuya", "30", "2000");
//            if (crea){
//                System.out.println("Si");
//            }else{
//                System.out.println("no");
//            }
//            productos = objBases.cargar_productos();
//            for (Producto p:productos){
//                System.out.println(p.toString());
//            }
        } else {
            System.out.println(" ¡Conexión fallida! ");
        }
    
}
}