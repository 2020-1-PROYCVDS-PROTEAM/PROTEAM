package edu.eci.cvds.samples.beans;

import java.sql.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.Services.*;


@ManagedBean(name="AdministradorBean")
@ApplicationScoped
public class AdministradorBean extends BasePageBean {
	
	@Inject
	private ServicioProteam servicioPT;
	private Usuario usuario;
	

    public List<Usuario> consultarUsuarios(){
        List<Usuario> usuarios = null;
        try{
            usuarios=servicioPT.consultarUsuarios();
            System.out.println("Entra correctamente en ConsultarUsuarioBean");
            
        } catch (ServicesException e) {
            //setErrorMessage(e);
            System.out.println("Entra en excepcion bean");
        }
        System.out.println("usuarios= "+usuarios);
        return usuarios;
    }
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setSelectedUsuario(Usuario usuario){
		this.usuario=usuario;
	}
	
}