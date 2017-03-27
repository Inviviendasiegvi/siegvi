/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siegvi.conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import siegvi.vistas.Login;

/**
 *
 * @author jeanc
 */
public class Conexion {
    private static Connection conexion = null;

    public static Connection conectar() {
       String password = "si_invivienda";;
       String usuario = "usr_invivienda";
       String url = "jdbc:mysql://10.0.0.253/si_inviviendadb";
        try {
            conexion = (Connection) DriverManager.getConnection(url,usuario,password);
            if (conexion != null)System.out.println("Conectado");
        } catch (SQLException e) {
		System.out.println("No se pudo conectar al servidor");
		e.printStackTrace();
        }
        return conexion;
    }
    
    public static void desconectar() throws SQLException {
      if (conexion != null) {
         conexion.close();
      }
    }
   
    //Arranque de aplicación conectandose a servidor   
    public static void main(String args[]) {
        Login log = new Login();
        log.setVisible(true);
    }
}
