
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;



public class conexion {
   
    
    
    private final String baseDatos = "usuario";
    private final int port= 3306;
    private final String servidor ="jdbc:mysql://localhost:"+ port +"/"+  baseDatos;
    private final String usuario = "root";
    private final String clave = "Andres80";
            
    public Connection conectar(){
        Connection con= null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(servidor, usuario, clave);
         } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return con;
    }
}
