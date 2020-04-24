package edu.eci.cvds.samples.beans;

import java.io.Serializable;
//import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.LoggerFactory;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="logeoBean")
@SessionScoped

public class LogueoBean implements Serializable{
	
        private static final Logger log = LoggerFactory.getLogger(LogueoBean.class);
       
	private String name;
	private String pass;
	public boolean logueado;
	
	//public LogueoBean(){
	//}
        
        
        public void doLogin() {
        Subject currentUser  = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getName(), getPass());
        //UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");

        try {
            System.out.println("INTENTA HACER EL LOGEO");
            currentUser.login(token);
            currentUser.getSession().setAttribute("correo",name);
            if (currentUser.hasRole("admin")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/administrador.xhtml");
            }else{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Usuario.xhtml");
            }

        }
        catch (UnknownAccountException ex) {
            System.out.println("Unknown account");
            log.error(ex.getMessage(), ex);
        }
        catch (IncorrectCredentialsException ex) {
            System.out.println("Wrong password");
            log.error(ex.getMessage(), ex);
        }
        catch (LockedAccountException ex) {
            System.out.println("Locked account");
            log.error(ex.getMessage(), ex);
        }
        catch (AuthenticationException ex) {
            System.out.println("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
        catch (IOException ex){
            System.out.println("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);

        }
    }

    public String getName() {
        System.out.println("ME PIDIERON EL NOMBRE EN LOGEOBEAN: "+name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        System.out.println("ME PIDIERON LA CONTRA EN LOGUEOBEAN: "+pass);
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