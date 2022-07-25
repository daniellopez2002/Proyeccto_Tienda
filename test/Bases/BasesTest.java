/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Bases;

import Modelo.Producto;
import Modelo.Usuario;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author LENOVO
 */
public class BasesTest {
    
    public BasesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of crear_conexion method, of class Bases.
     */
    @Test
    public void testCrear_conexion() {
        System.out.println("crear_conexion");
        Bases instance = new Bases();
        boolean expResult = false;
        boolean result = instance.crear_conexion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crear_usuario method, of class Bases.
     */
    @Test
    public void testCrear_usuario() {
        System.out.println("crear_usuario");
        String id = "";
        String nombre = "";
        String correo = "";
        String contrasena = "";
        Bases instance = new Bases();
        boolean expResult = false;
        boolean result = instance.crear_usuario(id, nombre, correo, contrasena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crear_producto method, of class Bases.
     */
    @Test
    public void testCrear_producto() {
        System.out.println("crear_producto");
        String id = "";
        String nombre = "";
        String cantidad = "";
        String precio_unidad = "";
        Bases instance = new Bases();
        boolean expResult = false;
        boolean result = instance.crear_producto(id, nombre, cantidad, precio_unidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crear_venta method, of class Bases.
     */
    @Test
    public void testCrear_venta() {
        System.out.println("crear_venta");
        String id_venta = "";
        String id_usuario = "";
        String id_producto = "";
        String cantidad = "";
        Bases instance = new Bases();
        boolean expResult = false;
        boolean result = instance.crear_venta(id_venta, id_usuario, id_producto, cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCodigoProducto method, of class Bases.
     */
    @Test
    public void testBuscarCodigoProducto() throws Exception {
        System.out.println("buscarCodigoProducto");
        String buscarpor = "";
        Bases instance = new Bases();
        Producto expResult = null;
        Producto result = instance.buscarCodigoProducto(buscarpor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarNombreUsuario method, of class Bases.
     */
    @Test
    public void testBuscarNombreUsuario() throws Exception {
        System.out.println("buscarNombreUsuario");
        String buscarpor = "";
        Bases instance = new Bases();
        Usuario expResult = null;
        Usuario result = instance.buscarNombreUsuario(buscarpor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarNombreUsuario_inicio method, of class Bases.
     */
    @Test
    public void testBuscarNombreUsuario_inicio() throws Exception {
        System.out.println("buscarNombreUsuario_inicio");
        String buscarpor = "";
        Bases instance = new Bases();
        Usuario expResult = null;
        Usuario result = instance.buscarNombreUsuario_inicio(buscarpor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargar_productos method, of class Bases.
     */
    @Test
    public void testCargar_productos() {
        System.out.println("cargar_productos");
        Bases instance = new Bases();
        ArrayList expResult = null;
        ArrayList result = instance.cargar_productos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargar_usuarios method, of class Bases.
     */
    @Test
    public void testCargar_usuarios() {
        System.out.println("cargar_usuarios");
        Bases instance = new Bases();
        ArrayList expResult = null;
        ArrayList result = instance.cargar_usuarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cargar_ventas method, of class Bases.
     */
    @Test
    public void testCargar_ventas() {
        System.out.println("cargar_ventas");
        Bases instance = new Bases();
        ArrayList expResult = null;
        ArrayList result = instance.cargar_ventas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateUsuario method, of class Bases.
     */
    @Test
    public void testUpdateUsuario() throws Exception {
        System.out.println("UpdateUsuario");
        Usuario usuariomod = null;
        Bases instance = new Bases();
        boolean expResult = false;
        boolean result = instance.UpdateUsuario(usuariomod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateProducto method, of class Bases.
     */
    @Test
    public void testUpdateProducto() throws Exception {
        System.out.println("UpdateProducto");
        Producto producMod = null;
        Bases instance = new Bases();
        boolean expResult = false;
        boolean result = instance.UpdateProducto(producMod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarUsuario method, of class Bases.
     */
    @Test
    public void testEliminarUsuario() {
        System.out.println("EliminarUsuario");
        String id = "";
        Bases instance = new Bases();
        boolean expResult = false;
        boolean result = instance.EliminarUsuario(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of EliminarProduccto method, of class Bases.
     */
    @Test
    public void testEliminarProduccto() {
        System.out.println("EliminarProduccto");
        int id = 0;
        Bases instance = new Bases();
        boolean expResult = false;
        boolean result = instance.EliminarProduccto(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
