/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zapateria.modelo;

/**
 *
 * @author ABAD
 */
public class Cliente {
    private String rfc;
    private String nombre;
    private String ap;
    private String direccion;
    private int telefono;
    private String email;
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email=email;
    }

    public String getRFC(){
        return rfc;
    }

    public void setRFC(String rfc){
        this.rfc=rfc;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getApellidos(){
        return ap;
    }

    public void setApellidos(String ap){
        this.ap=ap;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public int getTelefono(){
        return telefono;
    }
    public void setTelefono(int telefono){
        this.telefono=telefono;
    }


}
