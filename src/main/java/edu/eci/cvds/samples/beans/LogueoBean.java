package edu.eci.cvds.samples.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name="logeo")
@SessionScoped

public class LogueoBean implements Serializable{
	
	private String name;
	private String pass;
	public boolean logueado;
	
	public LogueoBean(){
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }
	
    
    public String action(){
        logueado=true;
        return "Usuario.xhtml?faces-redirect=true";
    }
    
}