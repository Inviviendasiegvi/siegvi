/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siegvi.vistas;

import java.util.List;
import siegvi.tablas.Usuario;

/**
 *
 * @author jeanc
 */
public class VistaUsuarios {
    
    public void verUsuario(Usuario user) {
		System.out.println("Datos del Cliente: "+user);
	}
	
	public void verClientes(List<Usuario> usuarios) {
		for (Usuario user : usuarios) {
			System.out.println("Datos del Cliente: "+usuarios);
		}		
	}
}
