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
import siegvi.tablas.Usuario;
 
 
/**
 *
 * @author jeanc
 */

public class Servicios_Usuario implements IServicios {	
	
	@Override
	public boolean registrar(Usuario user) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO tbl_usrs values (NULL,'"+user.getUsuario()+"','"+user.getPassword()+"','"+user.getArea()+"')";
		
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
	public List<Usuario> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM tbl_usrs ORDER BY ID";
		
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Usuario c=new Usuario();
				c.setUsuario(rs.getString(1));
				c.setArea(rs.getString(4));
				listaUsuarios.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaUsuarios;
	}
 
	@Override
	public boolean actualizar(Usuario user) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE CLIENTE SET usuario='"+user.getUsuario()+"', password='"+user.getPassword()+"', area='"+user.getArea()+"'" +" WHERE ID="+user.getId();
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
	public boolean eliminar(Usuario user) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM tbl_usrs WHERE ID="+user.getId();
		try {
			connect=Conexion.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
        
        public boolean consultar(String usuario, String pass) {
                boolean entrar = false;
                int identificador = 0;
                Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		System.out.println("Aqui");
		String sql="SELECT id FROM tbl_usrs WHERE usuario='" + usuario + "' AND password='"+ pass + "'";
		
		try {			
			co= Conexion.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			rs.next();
                        identificador = rs.getRow();
                        rs.close();
                        if(identificador != 0) entrar = true;
		} catch (SQLException e) {
			System.out.println("Error: Clase verificar");
			e.printStackTrace();
		}
                    
                    return entrar;
                }

   
}