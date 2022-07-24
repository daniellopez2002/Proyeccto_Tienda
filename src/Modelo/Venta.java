/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Bases.Bases;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class Venta {
    
    public int id_venta;
    public float total;

    public Venta() {
    }

    public Venta(int id_venta, float total) {
        this.id_venta = id_venta;
        this.total = total;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
     //Este metodo calcula el total de una venta y actualixa los productos dentro de la base de datos
    public float calcular_total(ArrayList<Producto> pr){
        Bases b = new Bases();
        
        for (int i = 0; i < pr.size(); i++) {
            Producto get = pr.get(i);
            boolean conec = b.crear_conexion();
            if (conec){
                ArrayList<Producto> p = b.cargar_productos();
                for (int j = 0; j < p.size(); j++) {
                    Producto get1 = p.get(j);
                    if (get.id_producto == get1.id_producto){
                        try {
                            Producto update = new Producto(get.id_producto, get.nombre, (get1.cantidad-get.cantidad), get.precio_unidad);
                            Boolean upt = b.UpdateProducto(update);
                        } catch (SQLException ex) {
                            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
                        }     
                    }
                }
            }
            float coste = (get.precio_unidad*get.cantidad);
            total += coste;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", total=" + total + '}';
    }
    
    
}
