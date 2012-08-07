/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zapateria.modelo;

import java.util.Calendar;

/**
 *
 * @author ABAD
 */
public class Caja {
    private Venta venta;
    private float totalVenta;
    private Cliente cliente;
    private String fecha;
    
    public Venta getVenta(){
        return venta;
    }
    public void setVenta(Venta venta){
        this.venta=venta;
    }
    
    public float getTotalVenta(){
        return totalVenta;
    }
    public void setTotalVenta(float totalVenta){
        this.totalVenta=totalVenta;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    public void set(Cliente cliente){
        this.cliente=cliente;
    }
    
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }
            
}
