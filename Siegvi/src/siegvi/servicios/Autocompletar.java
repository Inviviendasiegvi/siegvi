/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siegvi.servicios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import siegvi.conexion.Conexion;

/**
 *
 * @author jeanc
 */
public class Autocompletar extends javax.swing.JFrame{
    
    Conexion con = new Conexion();
    javax.swing.JTextField campo;
    String sql;
    int num;
    
    public Autocompletar(javax.swing.JTextField campo, String sql, int num){
        this.campo = campo;
        this.sql = sql;
        this.num = num;
        sugerencias();
    }
    
    private void sugerencias(){
        
        // SELECT nombre, paterno, materno FROM usuarios WHERE nombre = 'Juan'
        try{
            PreparedStatement ver = con.conectar().prepareStatement(sql);
            ResultSet  sugerencia = ver.executeQuery();
            
            while(sugerencia.next()){
                if(num == 1) campo.setText(sugerencia.getString(1));
                if(num == 2) campo.setText(sugerencia.getString(1) + " " + sugerencia.getString(2));
                if(num == 3) campo.setText(sugerencia.getString(1) + " " + sugerencia.getString(2) + " " + sugerencia.getString(3));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Autocompletar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
