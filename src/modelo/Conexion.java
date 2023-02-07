package modelo;

import java.sql.Connection;
import com.mysql.jdbc.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
/**
 *
 * @author Antonio Yances
 */
public class Conexion {    
    // Se crean constantes para la conexion
    private final String base = "estacion_espacial";
    private final String user="ryffqejwrux749ovhz5l";
    private final String contraseña = "pscale_pw_acMQdWnYI5NMDxpSV6mHX8Ueti4CpRmOjdouV9YdmAH";
    private final String url="jdbc:mysql://us-east.connect.psdb.cloud/" + base;
    public Connection con = null;// obtiene la conexion y la guarda para luego retornarla
    
    // Se crea metodo conexion para conectar a la base de datos.    
    public Connection getConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Ruta del diver ára la conexion.
            con = (Connection) DriverManager.getConnection(this.url,this.user,this.contraseña);// Se iguala la variable a la conexion
        } catch (SQLException e) {
            System.err.println(e);
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return con;
    }
    
}
    
    

