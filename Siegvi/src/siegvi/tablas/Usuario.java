/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siegvi.tablas;

import java.io.Serializable;

/**
 *
 * @author jeanc
 */
public class Usuario implements Serializable{
    private int id;
    private String usuario;
    private String password;
    private String status;
    private String area;
    private boolean borrado = false;

    public Usuario(){        
    }
    
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
}
