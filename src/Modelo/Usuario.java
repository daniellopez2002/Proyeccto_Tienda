/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Bases.Bases;
import java.util.ArrayList;

/**
 *
 * @author rayog
 */
public class Usuario {
     public int id;
     public String nombre;
     public String correo;
     public String contraseña;

    public Usuario(String nombre, String correo, String contraseña) {
        this.id = Set_Id();
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }
    
    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    //----------------------GENERAR_ID--------------------------------------------
    //El id del usuario es un concescutivo que generamos con este metodo
    public int Set_Id(){
        id = 0;
        Bases b = new Bases();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        boolean con = b.crear_conexion();
        if (con){
            usuarios = b.cargar_usuarios();
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario get = usuarios.get(i);
                if (get.id == id){
                    id +=1;
                }else{
                    return id;
                }

            }
            
            
        }
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }


    
     
}
