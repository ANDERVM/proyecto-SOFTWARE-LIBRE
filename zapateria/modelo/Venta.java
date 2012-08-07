/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zapateria.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ABAD
 */
public class Venta {
    private int id;
    private Calendar fecha;
    private Cliente cliente;
    private Zapato zapato;
    private int cantidad;
    private float totalVenta;

    public int getIdVenta(){
        return id;
    }
    public void setIdVenta(int id){
        this.id=id;
    } 
    public Calendar getFecha(){
        return fecha;
    }
    public void setFecha(Calendar fecha){
        this.fecha=fecha;
    }
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    public Zapato getZapato(){
        return zapato;
    }
    public void setZapato(Zapato zapato){
        this.zapato=zapato;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public float getTotalVenta(){
        return totalVenta;
    }
    public void setTotalVenta(float totalVenta){
        this.totalVenta=totalVenta;
    }
    public String obtenerFechaI() {
		return this.fecha.get(Calendar.DAY_OF_MONTH) + "/"
				+ (this.fecha.get(Calendar.MONTH) + 1) + "/"
				+ this.fecha.get(Calendar.YEAR);
    }
    public Calendar obtenerFecha(String str_date){
        //str_date="MM/dd/yyyy";
        DateFormat myDateFormat = new SimpleDateFormat(str_date);
        Date myDate = new Date();
        Calendar myGDate=new GregorianCalendar();
        try{
           myDate = myDateFormat.parse(str_date);
            return myGDate; 
        }catch(ParseException pe){
            return null;
        }
    }
}



