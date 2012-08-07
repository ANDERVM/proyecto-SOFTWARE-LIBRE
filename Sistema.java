/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zapateria.controlador;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import zapateria.modelo.*;
import zapateria.vista.formularioCorteCaja;

/**
 *
 * @author ABAD
 */
public class Sistema implements ISistema{

    public int agregarProveedor(Proveedor p) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement insertarNouevoProveedor;
        try{
            conexion=c.getConexion();
            insertarNouevoProveedor=conexion.prepareStatement("INSERT INTO proveedor VALUES(?,?,?,?,?,?,?,?,?)");
            insertarNouevoProveedor.setString(1,p.getNombre());
            insertarNouevoProveedor.setString(2,p.getApellidos());
            insertarNouevoProveedor.setInt(3,p.getTelefono());
            insertarNouevoProveedor.setInt(4,p.getCelular());
            insertarNouevoProveedor.setString(5,p.getDireccion());
            insertarNouevoProveedor.setString(6,p.getEmail());
            insertarNouevoProveedor.setString(7,p.getMarca());
            insertarNouevoProveedor.setInt(8,p.getCantidad());
            insertarNouevoProveedor.setInt(9,p.getZapato().getidZapato());
            insertarNouevoProveedor.executeUpdate();
            conexion.close();
            insertarNouevoProveedor.close();
            return 0;
            
        }catch(SQLException sqlerror){
            System.out.println(sqlerror.getMessage());
            return 1;
        }
    }
    

    public int añadirZapato(Zapato zapato) {
        //System.out.println(zapato.getidZapato()+zapato.getModelo()+zapato.getColor()+zapato.getTalla()+zapato.getMarca()+zapato.getCantidadz());
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement agregarZapato;
        try{
            
            conexion=c.getConexion();
            agregarZapato=conexion.prepareStatement("INSERT INTO zapato VALUES (?,?,?,?,?,?)");
            agregarZapato.setString(1,zapato.getModelo());
            agregarZapato.setFloat(2,zapato.getTalla());
            agregarZapato.setString(3,zapato.getColor());
            agregarZapato.setString(4,zapato.getMarca());
            agregarZapato.setInt(5,zapato.getCantidadz());
            agregarZapato.setFloat(6,zapato.getPrecio());
            agregarZapato.executeUpdate();
            conexion.close();
            agregarZapato.close();
            
            return 1;
            
        }catch(SQLException sqlex){
            return 0;
        }
    }

    public void añadirUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Usuario cuentaUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminarUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int nuevoCliente(Cliente cliente) {
        Conexion c=new Conexion();
        Connection conexion=c.getConexion();
        PreparedStatement insertarNouevoProveedor;
        try{
            insertarNouevoProveedor=conexion.prepareStatement("INSERT INTO cliente VALUES(?,?,?,?,?,?)");
            insertarNouevoProveedor.setString(1,cliente.getRFC());
            insertarNouevoProveedor.setString(2,cliente.getNombre());
            insertarNouevoProveedor.setString(3,cliente.getApellidos());
            insertarNouevoProveedor.setString(4,cliente.getDireccion());
            insertarNouevoProveedor.setString(5,cliente.getEmail());
            insertarNouevoProveedor.setInt(6,cliente.getTelefono());
            insertarNouevoProveedor.executeUpdate();
            conexion.close();
            insertarNouevoProveedor.close();
            return 0;
        }catch(SQLException sqlerror){
            return 1;
        }
        
    }
    public int actualizarCliente(Cliente cliente) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement modificarCliente;
        try{
            conexion=c.getConexion();
            modificarCliente=conexion.prepareStatement("UPDATE cliente SET nombre=?,apellidos=?,direccion=?,telefono=?,email=? WHERE rfc=?");
            modificarCliente.setString(1,cliente.getNombre());
            modificarCliente.setString(2,cliente.getApellidos());
            modificarCliente.setString(3,cliente.getDireccion());
            modificarCliente.setInt(4,cliente.getTelefono());
            modificarCliente.setString(5,cliente.getEmail());
            modificarCliente.setString(6,cliente.getRFC());
            modificarCliente.executeUpdate();
            conexion.close();
            modificarCliente.close();
            return 0;
        }catch(SQLException sqex){
            return 1;
        }
    }

    public Proveedor consultarProveedor(Proveedor proveedor) {
        Conexion c=new Conexion();
        Connection conexion=c.getConexion();
        PreparedStatement declaracion = null;
        ResultSet provee=null;
        
        try {
            declaracion= conexion.prepareStatement("Select * from proveedor where id_proveedor=?");
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
            try{
                declaracion.setInt(1,proveedor.getId());
                provee=declaracion.executeQuery();
                Proveedor p=new Proveedor();
                while(provee.next()){
                    p.setId(provee.getInt("id_proveedor"));
                    p.setNombre(provee.getString("nombre"));
                    p.setApellidos(provee.getString("apellidos"));
                    p.setTelefono(provee.getInt("telefono"));
                    p.setCelular(provee.getInt("telefono_cel"));
                    p.setDireccion(provee.getString("direccion"));
                    p.setEmail(provee.getString("email"));
                    p.setMarca(provee.getString("marca"));
                    Zapato z=new Zapato();
                    z.setidZapato(provee.getInt("id_zapato"));
                    p.setZapato(z); 
                }
                conexion.close();
                provee.close();
                declaracion.close();
                return p;
            }catch(SQLException e){
                    System.out.println(e.getMessage());
                    return null;
            }
    }

    public Zapato buscarZapato(Zapato zapato) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement consultarZapato;
        ResultSet resultado;
        
        try{
            conexion=c.getConexion();
            consultarZapato=conexion.prepareStatement("SELECT * FROM zapato WHERE id_zapato=?");
            consultarZapato.setInt(1,zapato.getidZapato());
            resultado=consultarZapato.executeQuery();
            Zapato zRes=new Zapato();
            while(resultado.next()){
                zRes.setidZapato(resultado.getInt("id_zapato"));
                zRes.setModelo(resultado.getString("modelo"));
                zRes.setTalla(resultado.getFloat("talla"));
                zRes.setColor(resultado.getString("color"));
                zRes.setMarca(resultado.getString("marca"));
                zRes.setCantidadz(resultado.getInt("cantidadz"));
                zRes.setPrecio(resultado.getFloat("precio"));
                
            }
             resultado.close();
             consultarZapato.close();
             conexion.close();
             return zRes;
            
        }catch(SQLException ex){
            return null;
        }
    }

    public int actualizarZapato(Zapato zapato) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement modificarZapato;
        try{
            conexion=c.getConexion();
            modificarZapato=conexion.prepareStatement("UPDATE zapato SET talla=?,color=?,cantidadz=?,precio=? WHERE id_zapato=?");
            modificarZapato.setFloat(1,zapato.getTalla());
            modificarZapato.setString(2,zapato.getColor());
            modificarZapato.setInt(3,zapato.getCantidadz());
            modificarZapato.setFloat(4,zapato.getPrecio());
            modificarZapato.setInt(5,zapato.getidZapato());
            modificarZapato.executeUpdate();
            conexion.close();
            modificarZapato.close();
            return 0;
        }catch(SQLException sqex){
            return 1;
        }
        
    }

    public int eliminarZapato(Zapato zapato) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement eliminarZapato;
        try{
            conexion=c.getConexion();
            eliminarZapato=conexion.prepareStatement("DELETE FROM zapato WHERE id_zapato=?");
            eliminarZapato.setInt(1,zapato.getidZapato());
            eliminarZapato.executeUpdate();
            conexion.close();
            eliminarZapato.close();
            return 0;
        }catch(SQLException sqlEx){
           return 1; 
        }
    }

    public Usuario cuentaUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void eliminarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Cliente consultarCliente(Cliente cliente) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement consultaCliente;
        ResultSet res=null;
        try{
            conexion=c.getConexion();
            consultaCliente=conexion.prepareStatement("SELECT * FROM cliente WHERE rfc=?");
            consultaCliente.setString(1,cliente.getRFC());
            res=consultaCliente.executeQuery();
            Cliente resCliente=new Cliente();
            while(res.next()){
                resCliente.setRFC(res.getString("rfc"));
                resCliente.setNombre(res.getString("nombre"));
                resCliente.setApellidos(res.getString("apellidos"));
                resCliente.setDireccion(res.getString("direccion"));
                resCliente.setEmail(res.getString("email"));
                resCliente.setTelefono(res.getInt("telefono"));
            }
            conexion.close();
            consultaCliente.close();
            res.close();
            //System.out.println(resCliente.getRFC());
            return resCliente;
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public int eliminarCliente(Cliente cliente) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement eliminarCliente;
        try{
            conexion=c.getConexion();
            eliminarCliente=conexion.prepareStatement("DELETE FROM cliente WHERE rfc=?");
            eliminarCliente.setString(1,cliente.getRFC());
            eliminarCliente.executeUpdate();
            conexion.close();
            eliminarCliente.close();
            return 0;
        }catch(SQLException sqlEx){
           return 1; 
        }
    }

    public int eliminarProveedor(Proveedor proveedor) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement eliminarProveedor;
        try{
            conexion=c.getConexion();
            eliminarProveedor=conexion.prepareStatement("DELETE FROM proveedor WHERE id_proveedor=?");
            eliminarProveedor.setInt(1,proveedor.getId());
            eliminarProveedor.executeUpdate();
            conexion.close();
            eliminarProveedor.close();
            return 0;
        }catch(SQLException sqlEx){
           return 1; 
        }
        
    }

    public int nuevaVenta(Venta venta) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement insertarVenta;
        String fechaV;
        try{
            conexion=c.getConexion();
            insertarVenta=conexion.prepareStatement("INSERT INTO venta VALUES (?,?,?,?,?)");
            insertarVenta.setInt(1,venta.getCantidad());
            fechaV=venta.obtenerFechaI();
            insertarVenta.setString(2,fechaV);
            insertarVenta.setFloat(3,venta.getTotalVenta());
            insertarVenta.setString(4,venta.getCliente().getRFC());
            insertarVenta.setInt(5,venta.getZapato().getidZapato());
            insertarVenta.executeUpdate();
            conexion.close();
            insertarVenta.close();
            return 0;
            
        }catch(SQLException sql){
            return 1;
        }
        
    }

    public int actualizarProveedor(Proveedor proveedor) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement actualizarProveedor;
        System.out.println(proveedor.getNombre()+proveedor.getApellidos());
        try{
            conexion=c.getConexion();
            actualizarProveedor=conexion.prepareStatement("UPDATE proveedor SET nombre=?,apellidos=?,telefono=?,telefono_cel=?,direccion=?,email=? WHERE id_proveedor=?");
            actualizarProveedor.setString(1,proveedor.getNombre());
            actualizarProveedor.setString(2,proveedor.getApellidos());
            actualizarProveedor.setInt(3,proveedor.getTelefono());
            actualizarProveedor.setInt(4,proveedor.getCelular());
            actualizarProveedor.setString(5,proveedor.getDireccion());
            actualizarProveedor.setString(6,proveedor.getEmail());
            System.out.println(proveedor.getId());
            actualizarProveedor.setInt(7,proveedor.getId());
            actualizarProveedor.execute();
            conexion.close();
            actualizarProveedor.close();
            return 0;
        }catch(SQLException es){
            System.out.println(es.getMessage());
            return 1;
        }
    }

    public Venta consultarVenta(Venta venta) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement consultarVenta;
        ResultSet ventaObtenida = null;
        //System.out.println(venta.getCliente().getRFC());
        try{
            conexion=c.getConexion();
            consultarVenta=conexion.prepareStatement("SELECT * FROM venta WHERE rfc=?");
            consultarVenta.setString(1,venta.getCliente().getRFC());
            ventaObtenida=consultarVenta.executeQuery();
            Venta vRes =new Venta();
            while(ventaObtenida.next()){
                vRes.setIdVenta(ventaObtenida.getInt("id_venta"));
                vRes.setCantidad(ventaObtenida.getInt("cantidadv"));
                vRes.obtenerFecha(ventaObtenida.getString("fecha"));
                vRes.setTotalVenta(ventaObtenida.getFloat("total"));
                Cliente cli=new Cliente();
                cli.setRFC(ventaObtenida.getString("rfc"));
                vRes.setCliente(cli);
                Zapato z=new Zapato();
                z.setidZapato(ventaObtenida.getInt("zapat"));
                vRes.setZapato(z);
                }
        conexion.close();
        ventaObtenida.close();    
        return vRes;
              
        }catch(SQLException sqEx){
            System.out.println(sqEx.getMessage());
            return null;
        }        
    }

    public int actualizarVenta(Venta venta) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int eliminarVenta(Venta venta) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement eliminarVenta;
        try{
            conexion=c.getConexion();
            eliminarVenta=conexion.prepareStatement("DELETE FROM venta WHERE rfc=?");
            eliminarVenta.setString(1,venta.getCliente().getRFC());
            eliminarVenta.executeUpdate();
            conexion.close();
            eliminarVenta.close();
            return 0;
        }catch(SQLException sqlEx){
           return 1; 
        }
    }

    public int cobrarVenta(Venta venta) {
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement cobrarVenta;
        String fechaV;
        fechaV=this.traerFechaVenta(venta);
        try{
            conexion=c.getConexion();
            cobrarVenta=conexion.prepareStatement("INSERT INTO caja VALUES (?,?,?,?)");
            cobrarVenta.setInt(1,venta.getIdVenta());
            cobrarVenta.setString(2, venta.getCliente().getRFC());
            cobrarVenta.setString(3,fechaV);
            cobrarVenta.setFloat(4,venta.getTotalVenta());
            cobrarVenta.executeUpdate();
            conexion.close();
            cobrarVenta.close();
            return 0;
            
        }catch(SQLException sql){
            return 1;
        }
    }

    public List<Caja> corteCaja() {
        int pos=0;
        Calendar fechaHoy=Calendar.getInstance();
        String consultarFecha=fechaHoy.get(Calendar.DAY_OF_MONTH)+"/"+(fechaHoy.get(Calendar.MONTH)+1)+"/"+fechaHoy.get(Calendar.YEAR);
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement ventasDia;
        ResultSet fechaRes;
        
        try{
            conexion=c.getConexion();
            ventasDia=conexion.prepareStatement("SELECT * FROM caja WHERE fecha=?");
            System.out.println(consultarFecha);
            ventasDia.setString(1,consultarFecha);
            fechaRes=ventasDia.executeQuery();
            Caja caja=new Caja();
            Cliente cliente=new Cliente();
            Venta v=new Venta();
            List listCaja=new ArrayList();
            while(fechaRes.next()){
                v.setIdVenta(fechaRes.getInt("id_venta"));
                caja.setVenta(v);
                cliente.setRFC(fechaRes.getString("rfcCliente"));
                caja.set(cliente);
                caja.setFecha(fechaRes.getString("fecha"));
                caja.setTotalVenta(fechaRes.getFloat("totalVenta"));
                listCaja.add(pos,caja.getVenta().getIdVenta());
                pos ++;
                listCaja.add(pos,caja.getCliente().getRFC());
                pos++;
                listCaja.add(pos,caja.getFecha());
                pos ++;
                listCaja.add(pos,caja.getTotalVenta());
                pos++;
            }
            conexion.close();
            ventasDia.close();
            fechaRes.close();
            //System.out.println(listCaja.size());
            new formularioCorteCaja().llenarAra(listCaja);
            return listCaja;
        }catch(SQLException es){
            System.out.println(es.getMessage());
            return null;
        }
        
    }
    public String traerFechaVenta(Venta venta){
        String fecha = null;
        Conexion c=new Conexion();
        Connection conexion;
        PreparedStatement consultarFecha;
        ResultSet fechaRes;
        try{
            conexion=c.getConexion();
            consultarFecha=conexion.prepareStatement("Select fecha FROM venta WHERE id_venta=?");
            consultarFecha.setInt(1,venta.getIdVenta());
            fechaRes=consultarFecha.executeQuery();
            while(fechaRes.next()){
                fecha=fechaRes.getString("fecha");
            }
            conexion.close();
            consultarFecha.close();
            fechaRes.close();
            return fecha;
        }catch(SQLException s){
            return null;
        }
        
    }
        
}
