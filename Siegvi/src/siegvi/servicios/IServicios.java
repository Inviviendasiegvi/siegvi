/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siegvi.servicios;

import java.util.List;
import siegvi.tablas.Usuario;

/**
 *
 * @author jeanc
 */
public interface IServicios {
    public boolean registrar(Usuario user);
    public boolean actualizar(Usuario user);
    public List<Usuario> obtener();
    public boolean eliminar(Usuario user);
    public boolean consultar(String user, String pass);
}
