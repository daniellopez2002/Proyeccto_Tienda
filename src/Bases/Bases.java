/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bases;


import Modelo.Producto;
import Modelo.Usuario;
import Modelo.Venta;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Bases {
    Connection conexion;
    Statement st; 

    public Bases() {
    }
    //--------------------------------------------CREAR_CONECCION-----------------------------------------------------
    public boolean crear_conexion(){
        String nameDB = "proyecto_sr";
        String userDB = "root";
        String pwdDB = "root";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");                                      //user  //pass
            //conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/uao", "root", "root");
            String sourceURL = "jdbc:mysql:///" + nameDB;
            conexion = DriverManager.getConnection(sourceURL, userDB, pwdDB);
            //Objeto para manejo de sentencias SQL
            st = conexion.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            
            ex.printStackTrace();
            return false;
        }

        return true;
    }
    //--------------------------------------------CREAR_ELEMENTO----------------------------------------------------
    public boolean crear_usuario(String id, String nombre, String correo, String contrasena) {
        // String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
        String sql = "INSERT INTO usuario(id, nombre, correo, contrasena) VALUES(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, correo);
            ps.setString(4, contrasena);
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
                Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean crear_producto(String id, String nombre, String cantidad, String precio_unidad) {
        // String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
        String sql = "INSERT INTO producto(id, nombre, cantidad, precio_unidad) VALUES(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nombre);
            ps.setString(3, cantidad);
            ps.setString(3, precio_unidad);
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
                Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean crear_venta(String id_venta, String id_usuario, String id_producto,String cantidad) {
        String sql = "INSERT INTO venta(id_producto_venta, id_usuario_venta, cantidad_producto, id_venta) VALUES(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);
            ps = conexion.prepareStatement(sql);
            ps.setString(1, id_producto);
            ps.setString(2, id_usuario);
            ps.setString(3, cantidad);
            ps.setString(4, id_venta);
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
                Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    //---------------------------------------BUSCAR&CARGAR-------------------------------------------
    public Producto buscarCodigoProducto(String buscarpor) throws IOException {
        Producto pr = new Producto();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM producto WHERE id_producto=" + buscarpor + "");
            while (rs.next()) {
                String id_producto = rs.getObject("id_producto").toString();
                String nombre = rs.getObject("nombre").toString();
                String cantidad = rs.getObject("cantidad").toString();
                String precio_unidad = rs.getObject("precio_unidad").toString();

                pr.id_producto = Integer.parseInt(id_producto);
                pr.nombre = nombre;
                pr.cantidad = Integer.parseInt(cantidad);
                pr.precio_unidad = Float.parseFloat(precio_unidad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pr;
    }
  
    public Usuario buscarNombreUsuario(String buscarpor) throws IOException {
        Usuario ur = new Usuario();
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM usuario WHERE id=" + buscarpor + "");
            while (rs.next()) {
                String id = rs.getObject("id").toString();
                String nombre = rs.getObject("nombre").toString();
                String correo = rs.getObject("correo").toString();
                String contrasena = rs.getObject("contrasena").toString();
                
                ur.id = Integer.parseInt(id);                
                ur.nombre = nombre;
                ur.correo = correo;
                ur.contraseña = contrasena;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ur;
    }
    
    
    public ArrayList cargar_productos(){
        ArrayList<Producto> productos = new ArrayList<>();
        String Sql = "SELECT * FROM producto";
        try {
            ResultSet rs  = st.executeQuery(Sql);
            while (rs.next()){
                Producto p = new Producto();
                p.id_producto = Integer.parseInt(rs.getObject("id_producto").toString());
                p.nombre = rs.getObject("nombre").toString();
                p.cantidad = Integer.parseInt(rs.getObject("cantidad").toString());
                p.precio_unidad = Float.parseFloat(rs.getObject("precio_unidad").toString());
                productos.add(p);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return(productos);
    }
    
    public ArrayList cargar_usuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String Sql = "SELECT * FROM usuario";
        try {
            ResultSet rs  = st.executeQuery(Sql);
            while (rs.next()){
                Usuario u = new Usuario();
                u.id = Integer.parseInt(rs.getObject("id").toString());
                u.nombre = rs.getObject("nombre").toString();
                u.correo = rs.getObject("correo").toString();
                u.contraseña = rs.getObject("contrasena").toString();
                usuarios.add(u);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return(usuarios);
    }

    public ArrayList cargar_ventas(){
        ArrayList<Venta> ventas = new ArrayList<>();
        String Sql = "SELECT * FROM venta";
        try {
            ResultSet rs  = st.executeQuery(Sql);
            while (rs.next()){
                Venta v = new Venta();
                v.id_venta = Integer.parseInt(rs.getObject("id_venta").toString());
                v.total = Float.parseFloat(rs.getObject("valor").toString());
                ventas.add(v);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Bases.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return(ventas);
    }    
   
    //----------------------------------------EDITAR_UPDATEAR----------------------------------------------------
    public boolean UpdateUsuario(Usuario usuariomod) throws SQLException, IOException {
        boolean modificar = false;
        String update = "update usuario set nombre = ?,"
                + "correo=?,"
                + "contrasena=?,"
                + "imagenestudiante=? where nombre = ?";
        PreparedStatement preparedStmt = conexion.prepareStatement(update);
        preparedStmt.setString(1, usuariomod.getNombre());
        preparedStmt.setString(2, usuariomod.getCorreo());
        preparedStmt.setString(3, usuariomod.getContraseña());
        preparedStmt.setString(4, usuariomod.getNombre());
        
        preparedStmt.executeUpdate();
        preparedStmt.close();
        modificar = true;

        return modificar;
    }
    
    public boolean UpdateProducto(Producto producMod) throws SQLException, IOException {
        boolean modificar = true;
        String update = "update producto set id_producto = ?,"
                + "nombre=?,"
                + "cantidad=?,"
                + "precio_unidad=? where id_producto = ?";
        PreparedStatement preparedStmt = conexion.prepareStatement(update);
        preparedStmt.setString(1, String.valueOf(producMod.getId_producto()));
        preparedStmt.setString(2, producMod.getNombre());
        preparedStmt.setString(3, String.valueOf(producMod.getCantidad()));
        preparedStmt.setString(4, String.valueOf(producMod.getPrecio_unidad()));
        preparedStmt.setString(5, String.valueOf(producMod.getId_producto()));
        
        
        preparedStmt.executeUpdate();
        preparedStmt.close();

        return modificar;
    }
        
    //----------------------------------------ELIMINAR----------------------------------------
    public boolean EliminarUsuario(String nombre) {
        String sql = "DELETE FROM usuario WHERE nombre = "+nombre;
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
    
    public boolean EliminarProduccto(int id) {
        String sql = "DELETE FROM producto WHERE id_producto = "+String.valueOf(id);
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }
    
}
