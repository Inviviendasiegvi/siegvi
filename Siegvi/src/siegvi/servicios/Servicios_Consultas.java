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
	public boolean registrar(String sql) {
		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
		try {			
			con=Conexion.conectar();
			stm= con.createStatement();
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
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
                
		//String sql="SELECT * FROM tbl_usrs ORDER BY ID";
		
		List<String> lista= new ArrayList<String>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
                        
                        
			while (rs.next()) {
                          
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return lista;
	}
 
	@Override
	public boolean actualizar(String sql) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
//		String sql="UPDATE CLIENTE SET usuario='"+user.getUsuario()+"', password='"+user.getPassword()+"', area='"+user.getArea()+"'" +" WHERE ID="+user.getId();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	@Override
	public boolean eliminar(String sql) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		//String sql="DELETE FROM tbl_usrs WHERE ID="+user.getId();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			 
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
        
        public boolean consultar(String sql) {
                boolean entrar = false;
                int identificador = 0;
                Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
                
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			rs.next();
                        identificador = rs.getRow();
                        rs.close();
                        if(identificador != 0) entrar = true;
		} catch (SQLException e) {
			System.out.println("Error: Consultar");
			e.printStackTrace();
		}
                    
                    return entrar;
                }

   
}