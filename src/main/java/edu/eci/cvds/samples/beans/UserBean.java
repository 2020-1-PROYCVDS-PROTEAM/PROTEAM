package edu.eci.cvds.samples.beans;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.entities.Comentario;
import edu.eci.cvds.samples.entities.Voto;
import edu.eci.cvds.samples.entities.PalabraClave;

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
import java.util.ArrayList;
import java.util.Calendar;


@SuppressWarnings("serial")
@ManagedBean(name = "UserBean")
@ApplicationScoped
public class UserBean extends BasePageBean implements Serializable{
	
	private boolean skip;
	private String idPag;
	private Date date;
	private Iniciativa selectedi;
	private List<Iniciativa> selectsi;
	
    @Inject
    private ServicioProteam servicioPT;
    private List<Iniciativa> iniciativas;
    private List<Comentario> comentarios;
    private List<PalabraClave> palabraClave;
    private List<Voto> votos;
    
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
	public Iniciativa consultarIniciativaPalabraCLave(String palabraClave){
		try{
			return servicioPT.palabraClaveIniciativa(palabraClave);
		}catch(ServicesException e){
			System.out.println("CAPTURADO EN USERBEAN consultarIniciativa x id");
		}
		return null;
	}
	
	
	public void insertarComentario(String idUsuario, String idIniciativa, String contenido){//Aqui debe ir un casteo de atributos a Date int ...
        System.out.println("Aparece en pantallaUserBean");
        try{
            int idIni= Integer.parseInt(idIniciativa);
            int idd = servicioPT.consultarComentariosIniciativa(idIni).size()+1;
            Date datex = new Date(Calendar.getInstance().getTime().getTime());			
            System.out.println("FECHA DEL REGISTRO COMENTARIO: "+datex);
            System.out.println("CHOTO MATEEEEEEE id iniciativa: "+idd);
            //int voto = Integer.parseInt(votos);
            //Date date=Date.valueOf(fecha);
            servicioPT.insertarComentario(idd,idUsuario,idIni,contenido,datex);
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean registrarIniciativa");
        }
    }
	
	
	
	
	public void registrarVoto(String idUsuario, String idIniciativa){
                int idd = Integer.parseInt(idIniciativa);
				try{
                    System.out.println("Al bean User llega esto: "+idUsuario+" ini: "+idIniciativa);
                    Voto voto = servicioPT.consultarVoto(idUsuario,idd);
					if(voto==null)
						servicioPT.registrarVoto(idUsuario, idd);		
					else
						servicioPT.borrarVoto(idUsuario,idd);
					
			
            //servicioPT.registrarVoto(idUsuario, idd);
				}catch(ServicesException e){
			/*
                        try{
                            servicioPT.borrarVoto(idUsuario,idd);
                        }
                        catch(ServicesException ex){
                            System.out.println("Entra en excepcion 2userbean VotarIniciativa");
                        }*/
				System.out.println("Entra en excepcion userBean VotarIniciativa");
		}
	}
	
	public void setSelectedi(Iniciativa selectIniciativa){
		selectedi=selectIniciativa;
	}
	
	public Iniciativa getSelectedi(){
		return selectedi;
	}

	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}
	
	public List<Iniciativa> getIniciativas() {
		if (iniciativas == null) {
			System.out.println("esnull");
			consultarIniciativas();
		}
		return iniciativas;
	}
        
        public List<String> consultarPalabrasClaveIniciativa(int idIniciaitva){
            try{
                System.out.println("Entrando con consultar palabras clave");
                List<PalabraClave> palabrasclave = servicioPT.consultarPalabrasClaveIniciativa(idIniciaitva);
                List<String> palabra=new ArrayList<String>();
                for(PalabraClave p:palabrasclave){
                    palabra.add(p.getPalabraClave());
                }
                return palabra;
                //return servicioPT.consultarPalabrasClaveIniciativa(idIniciaitva);
            }catch(ServicesException e){
                System.out.println("Entra en excepcion userBean GETPALABRASCLAVE");
            }
                return null;
        }
	
	


	public ServicioProteam getServicioPT() {
		return servicioPT;
	}

	public void setServicioPT(ServicioProteam servicioPT) {
		this.servicioPT = servicioPT;
	}


	public List<Iniciativa> getSelectsi() {
		return selectsi;
	}


	public void setSelectsi(List<Iniciativa> selectsi) {
		this.selectsi = selectsi;
	}
	
	public Date getDate(){
		Date date = new Date(Calendar.getInstance().getTime().getTime());
		return date;
	}
	
	public void setDate(Date date){
		this.date=date;
	}
	
	
    
    
}