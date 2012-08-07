/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zapateria.modelo;

/**
 *
 * @author ABAD
 */
public class Zapato {
    private int idZapato;
    private String modelo;
    private float talla;
    private String color;
    private String marca;
    private int cantidadz;
    private float precio;
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio(float precio){
        this.precio=precio;
    }
    
    public Zapato(){

    }
    public int getidZapato(){
        return idZapato;
    }
    public void setidZapato(int idZapato){
        this.idZapato=idZapato;
    }
    public String getModelo() {
		return modelo;
    }

    public void setModelo(String modelo) {
		this.modelo=modelo;
    }

    public float getTalla(){
        return talla;
    }

    public void setTalla(float talla){
        this.talla=talla;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color=color;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }
    
    public int getCantidadz(){
        return cantidadz;
    }
    public void setCantidadz(int cantidadz){
        this.cantidadz=cantidadz;
    }

}
