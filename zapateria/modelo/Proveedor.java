/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zapateria.modelo;

/**
 *
 * @author ABAD
 */
public class Proveedor {
    private int id;
    private String nombre;
    private String apellidos;
    private int telefono;
    private int celular;
    private String direccion;
    private String email;
    private int cantidad;
    private String marca;
    private Zapato zapato;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos=apellidos;
    }
    public int getTelefono(){
        return telefono;
    }
    public void setTelefono(int telefono){
        this.telefono=telefono;
    }
    public int getCelular(){
        return celular;
    }
    public void setCelular(int celular){
        this.celular=celular;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getCantidad(){
        return cantidad;
    }
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
    public Zapato getZapato(){
        return zapato;
    }
    public void setZapato(Zapato zapato){
        this.zapato=zapato;
    }
}
