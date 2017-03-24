/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siegvi.control;

import java.util.ArrayList;
import java.util.List;
import siegvi.servicios.IServicios;
import siegvi.servicios.Servicios_Usuario;
import siegvi.tablas.Usuario;
import siegvi.vistas.VistaUsuarios;

/**
 *
 * @author jeanc
 */
public class ControlUsuario {
    private VistaUsuarios vista = new VistaUsuarios();
    
    public ControlUsuario() {
	}
	
	//llama al DAO para guardar un cliente
	public void registrar(Usuario user ) {
		IServicios dao= new  Servicios_Usuario();
		dao.registrar(user);
	}
	
	//llama al DAO para actualizar un cliente
	public void actualizar(Usuario user) {
		IServicios dao= new  Servicios_Usuario();
		dao.actualizar(user);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Usuario user) {
		IServicios dao= new  Servicios_Usuario();
		dao.eliminar(user);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		IServicios dao= new  Servicios_Usuario();
		usuarios=dao.obtener();
		vista.verClientes(usuarios);
	}
        
        public boolean verificar(String user, String pass){
            IServicios dao = new Servicios_Usuario();
            System.out.println("Verificar :" + user + " -- " + pass);
            return dao.consultar(user, pass);
        }
}