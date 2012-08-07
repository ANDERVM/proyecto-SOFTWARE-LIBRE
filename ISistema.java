/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zapateria.controlador;

import java.util.List;
import zapateria.modelo.*;

/**
 *
 * @author ABAD
 * DECLARACION DE LOS METODOS DEL SISTEMA
 */
public interface ISistema {
    //Metodos para la clase PROVEEDOR
    int agregarProveedor(Proveedor proveedor);
    Proveedor consultarProveedor(Proveedor proveedor);
    int eliminarProveedor (Proveedor proveedor);
    int actualizarProveedor(Proveedor proveedor);
    // Metodos para la clase ZAPATO
    int añadirZapato(Zapato zapato);
    Zapato buscarZapato(Zapato zapato);
    int actualizarZapato(Zapato zapato);
    int eliminarZapato(Zapato zapato);
    // Metodos para la clase USUARIO
    void añadirUsuario(Usuario usuario);
    Usuario cuentaUsuario(Usuario usuario);
    void eliminarUsuario(Usuario usuario);
    void cerrarSesion();
    // Metodos para la clase CLIENTE
    int nuevoCliente(Cliente cliente);
    Cliente consultarCliente(Cliente cliente);
    int actualizarCliente(Cliente cliente);
    int eliminarCliente(Cliente cliente);
    // Metodos para la clase VENTA
    int nuevaVenta(Venta venta);
    Venta consultarVenta(Venta venta);
    int actualizarVenta(Venta venta);
    int eliminarVenta(Venta venta);

    // Metodos para la clase CAJA
    int cobrarVenta(Venta venta);
    List <Caja> corteCaja();
}
