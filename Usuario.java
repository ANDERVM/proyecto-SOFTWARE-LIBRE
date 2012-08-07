/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package zapateria.modelo;

/**
 *
 * @author ABAD
 */
public class Usuario {
    private int id;
    private String nombre;
    private String app;
    private String apm;
    private String puesto;
    private String ciudad;
    private String calle;
    private int numero;
    private int telefono;
    private String contraseña;
    
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
    public String getApp(){
        return app;
    }
    public void setApp(String app){
        this.app=app;
    }
    public String getApm(){
        return apm;
    }
    public void setApm(String apm){
        this.apm=apm;
    }
    public String getPuesto(){
        return puesto;
    }
    public void setPuesto(String puesto){
        this.puesto=puesto;
    }
    public String getCiudad(){
        return ciudad;
    }
    public void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    public String getCalle(){
        return calle;
    }
    public void setCalle(String calle){
        this.calle=calle;
    }
    public int getNumero(){
        return numero;
    }
    public void setNumero(int numero){
        this.numero=numero;
    }
    public int getTelefono(){
        return telefono;
    }
    public void setTelefono(int telefono){
        this.telefono=telefono;
    }
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña(String contraseña){
        this.contraseña=contraseña;
    }

}
