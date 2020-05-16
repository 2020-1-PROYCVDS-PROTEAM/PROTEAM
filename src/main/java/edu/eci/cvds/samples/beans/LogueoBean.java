package edu.eci.cvds.samples.beans;

import java.io.Serializable;
import java.util.logging.Level;

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
import javax.swing.JOptionPane;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "logeoBean")
@SessionScoped

public class LogueoBean implements Serializable {

    private static final Logger log = LoggerFactory.getLogger(LogueoBean.class);

    private String name;
    private String pass;
    public boolean logueado=false;

    public void doLogin() {
        //System.out.println("Si esta entrando acaaaaaaaaa");
        System.out.println("DoLOGIN() === name: " + name + " pass: " + pass);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getName(), new Sha256Hash(getPass()).toHex());
        try {
            currentUser.login(token);
            currentUser.getSession().setAttribute("correo", name);
            if (currentUser.hasRole("Administrador")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/administrador.xhtml");
            } else if (currentUser.hasRole("Proponente")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/perfil_usuario.xhtml");
            } else if (currentUser.hasRole("PMO")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/PMO.xhtml");
            } else {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/iniciativa.xhtml");
            }
			setLogueado(true);

        } catch (UnknownAccountException ex) {
            System.out.println("Unknown account");
            error("Unknown account");
            log.error(ex.getMessage(), ex);
        } catch (IncorrectCredentialsException ex) {
            System.out.println("Wrong password");
            error("Wrong password");
            log.error(ex.getMessage(), ex);
        } catch (LockedAccountException ex) {
            error("Locked account");
            System.out.println("Locked account");
            log.error(ex.getMessage(), ex);
        } catch (AuthenticationException ex) {
            error("Unknown error: "+ex.getMessage());
            System.out.println("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        } catch (IOException ex) {
            error("Unknown error: " + ex.getMessage());
            System.out.println("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);

        }
    }
    
     public void error(String message) {
        FacesContext.getCurrentInstance().addMessage("Shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "error"));
    }
	

    public String getName() {
        //System.out.println("ME PIDIERON EL NOMBRE EN LOGEOBEAN: "+name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        //System.out.println("ME PIDIERON LA CONTRA EN LOGUEOBEAN: "+pass);
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isLogueado() {
		System.out.println("ENTRA ADEMAS ESTA LOGUEADO?: "+logueado);
		if(!logueado){
			return false;
		}
		else{
			return logueado;
		}
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    public String action() {
        logueado = true;
        return "Usuario.xhtml?faces-redirect=true";
    }

    public void cerrarSesion() {
        System.out.println("Entra en cerrarSesion");
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml");
            System.out.println("Hizo el cierre de sesion");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(LogueoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redirect(String dr) {
        Subject s = SecurityUtils.getSubject();
        if (dr == "/faces/administrador.xhml" && s.hasRole("Administrador") || (dr != "/faces/administrador.xhml")) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(dr);
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(LogueoBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
