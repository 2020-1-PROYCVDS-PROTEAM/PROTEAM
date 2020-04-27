package edu.eci.cvds.samples.beans;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Comentario;
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
import java.io.Serializable;

import java.sql.Date;


@SuppressWarnings("serial")
@ManagedBean(name = "UserBean")
@ApplicationScoped
public class UserBean extends BasePageBean implements Serializable{
	
	private boolean skip;
	private String idPag;
	private Iniciativa selectedi;
	
    @Inject
    private ServicioProteam servicioPT;
    private List<Iniciativa> iniciativas;
	private List<Comentario> comentarios;
    
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
	
	public void setIdPag(String iniciativaId){
		System.out.println("Entra en setIdPag User Bean: "+iniciativaId);
		idPag = iniciativaId;
	}
	
	public String getIdPag(){
		return idPag;
	}
	
	
	public List<Comentario> consultarComentarios(){
        try{
            this.comentarios = servicioPT.consultarComentarios();
        }
        catch(ServicesException e){
        	System.out.println("no consulta comentarios");

        }
        return this.comentarios;
    }
	
	
	public List<Comentario> consultarComentariosIniciativa(String idIniciativa){
        try{
			int id = Integer.parseInt(idIniciativa);
            this.comentarios = servicioPT.consultarComentariosIniciativa(id);
        }
        catch(ServicesException e){
        	System.out.println("no consulta comentario iniciativa ");

        }
        return this.comentarios;
    }
	
	
	public Iniciativa consultarIniciativa(String id){
		try{
			int idd=Integer.parseInt(id);
			return servicioPT.consultarIniciativa(idd);
		}catch(ServicesException e){
			System.out.println("CAPTURADO EN USERBEAN consultarIniciativa x id");
		}
		return null;
	}
	

	

	public List<Iniciativa> getIniciativas() {
		if (iniciativas == null) {
			System.out.println("esnull");
			consultarIniciativas();
		}
		return iniciativas;
	}
	
	public void insertarComentario(String idUsuario, String idIniciativa, String contenido, String fecha){//Aqui debe ir un casteo de atributos a Date int ...
        System.out.println("Aparece en pantallaUserBean");
        try{
            int idIni= Integer.parseInt(idIniciativa);
			int idd = servicioPT.consultarComentariosIniciativa(idIni).size()+1;
			System.out.println("CHOTO MATEEEEEEE id iniciativa: "+idd);
            //int voto = Integer.parseInt(votos);
            Date date=Date.valueOf(fecha);
            servicioPT.insertarComentario(idd,idUsuario,idIni,contenido,date);
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean registrarIniciativa");
        }
    }
	
	public void setselectedi(Iniciativa selectIniciativa){
		selectedi=selectIniciativa;
	}
	
	public Iniciativa getSelectedi(){
		return selectedi;
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