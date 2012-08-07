/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zapateria.controlador;

import java.sql.*;
import zapateria.modelo.Proveedor;

/**
 *
 * @author ABAD
 */
public class Conexion {
    public Connection getConexion(){
        Connection  conexion=null;
        String Url="jdbc:sqlserver://localhost;databaseName=ZAPATERIA;";
        
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                
            }catch(ClassNotFoundException noencontrado){
                System.out.println("Driver no encontrado");
            }
            try{
                conexion=DriverManager.getConnection(Url,"sa","");
            }catch(SQLException sqlerror){
                System.out.println(sqlerror.getMessage());
            }
            return conexion;
    }
    public boolean actualizar(String instruccion){
        Connection conexion=getConexion();
        Statement declaracion;
        try{
            declaracion= conexion.createStatement();
            declaracion.executeUpdate(instruccion);
            declaracion.close();
            return true;
        }catch(SQLException sqlerror){
            System.out.println("Error:"+sqlerror.getMessage());
            return false;
        }}
    public ResultSet consultar (String consulta){
        Connection conexion=getConexion();
        Statement declaracion;
        /**String nombre_persona = null;
        String RFC = null;
        String APELLIDOS = null;**/
        try{
            declaracion= conexion.createStatement();
            ResultSet resultado=declaracion.executeQuery(consulta);
            System.out.println(resultado);
            /**while(resultado.next()){
                RFC=resultado.getString("rfc");
                nombre_persona  = resultado.getString("Nombre");
                APELLIDOS=resultado.getString("apellidos");
            }**/
            
            return resultado;
            
        }catch(SQLException sqlerror){
            System.out.println("Error:"+sqlerror.getMessage());
            return null;
        }
        
      
    }
}
