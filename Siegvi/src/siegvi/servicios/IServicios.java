/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siegvi.servicios;

import java.util.List;


/**
 *
 * @author jeanc
 */
public interface IServicios {
    public boolean registrar(String sql);
    public boolean actualizar(String sql);
    public List<String> obtener(String sql);
    public boolean eliminar(String sql);
    public boolean consultar(String sql);
}
