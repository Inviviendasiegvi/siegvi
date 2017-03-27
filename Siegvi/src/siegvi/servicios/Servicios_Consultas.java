/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siegvi.servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import siegvi.conexion.Conexion;

 
 
/**
 *
 * @author jeanc
 */

public class Servicios_Consultas implements IServicios {	
	
	@Override
	public boolean ejecutar_Consulta(String sql) {
		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
//	Actualizar	String sql="UPDATE CLIENTE SET usuario='"+user.getUsuario()+"', password='"+user.getPassword()+"', area='"+user.getArea()+"'" +" WHERE ID="+user.getId()
		try {			
			con = Conexion.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase Servicios, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
 
	@Override
	public List<String> obtener(String sql) {
		Connection con =null;
		Statement stm= null;
		ResultSet rs=null;
		
                
		//String sql="SELECT * FROM tbl_usrs ORDER BY ID";
		
		List<String> lista= new ArrayList<String>();
		
		try {			
			con = Conexion.conectar();
			stm = con.createStatement();
			rs=stm.executeQuery(sql);
                        
                        
			while (rs.next()) {
                          //LLENAR LISTA DE CADENAS 
			}
			stm.close();
			rs.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return lista;
	}

        public boolean verificar(String sql) {
                boolean entrar = false;
                int identificador = 0;
                Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
                
		try {			
			con = Conexion.conectar();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			rs.next();
                        identificador = rs.getRow();
                        rs.close();
                        if(identificador != 0) entrar = true;
                        con.close();
		} catch (SQLException e) {
			System.out.println("Error: Consultar");
			e.printStackTrace();
		}
                    
            return entrar;
        }
}