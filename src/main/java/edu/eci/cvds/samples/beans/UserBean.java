package edu.eci.cvds.samples.beans;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;
import edu.eci.cvds.samples.entities.Iniciativa;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import java.util.List;

import java.sql.Date;


@SuppressWarnings("serial")
@ManagedBean(name = "UserBean")
@ApplicationScoped
public class UserBean extends BasePageBean {
	
	private boolean skip;
	
    @Inject
    private ServicioProteam servicioPT;
    private List<Iniciativa> iniciativas;
    
    private void setErrorMessage(Exception e){
        String message = e.getMessage();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }
    
    
    public List<Iniciativa> consultarIniciativas(){
        try{
            this.iniciativas = servicioPT.consultarIniciativas();
        }
        catch(ServicesException e){
        	System.out.println("no funciona");

        }
        return this.iniciativas;
    }

	public List<Iniciativa> getIniciativas() {
		if (iniciativas == null) {
			System.out.println("esnull");
			consultarIniciativas();
		}
		return iniciativas;
	}

	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}

	public ServicioProteam getServicioPT() {
		return servicioPT;
	}

	public void setServicioPT(ServicioProteam servicioPT) {
		this.servicioPT = servicioPT;
	}
    
    
}