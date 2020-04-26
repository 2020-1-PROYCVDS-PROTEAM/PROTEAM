package edu.eci.cvds.samples.beans;

import java.sql.Date;
import java.util.List;
//import java.text.SimpleDateFormat;
import java.text.ParseException;


import java.sql.Date;
import java.util.List;
import java.text.ParseException;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.Services.*;
import java.io.Serializable;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import org.primefaces.event.FlowEvent;
import org.primefaces.event.RowEditEvent;


@ManagedBean(name="AdministradorBean")
@ApplicationScoped
public class AdministradorBean extends BasePageBean implements Serializable{
	
	
	private boolean skip;
	private final static String[] rolez;
	private final static String[] ideas;
	static{rolez= new String[4]; 
	rolez[0]="Administrador";
	rolez[1]="PMO";
	rolez[2]="Proponente";
	rolez[3]="Publico";
	}
	static{
		ideas=new String[4];
		ideas[0]="En espera de revisión";
		ideas[1]="En revisión";
		ideas[2]="Proyecto";
		ideas[3]="Solucionado";
	}
	
	
	
	@Inject
	private ServicioProteam servicioPT;
	private Usuario usuario;
	
	
		
	public List<String> getRolez(){
		System.out.println("ADMINISTRADOR GETROLEZ");
		return Arrays.asList(rolez);
	}
	
	public List<String> getIdeas(){
		System.out.println("Administrador getIdeas");
		return Arrays.asList(ideas);
	}
	
        
    public Usuario consultarUsuario(String usuario){
        try{
            return servicioPT.consultarUsuario(usuario);
        }
        catch(ServicesException e){
            System.out.println("Entra en excepcion UsuarioUnico");    
        }
        return null; //esto puede fallar pero vamos a intentar
    }
    
    
    public void registrarIniciativa(String id,String votos,String palabraClave, String nombre,String estado,String descripcion, String area, String usuario_i,String correo_i,String fecha_ini){//Aqui debe ir un casteo de atributos a Date int ...
        System.out.println("Aparece en pantalla");
        try{
            int idd = Integer.parseInt(id);
            int voto = Integer.parseInt(votos);
            Date date=Date.valueOf(fecha_ini);//converting string into sql date
            servicioPT.insertIniciativa(idd,voto,palabraClave,nombre,estado,descripcion,area,usuario_i,correo_i,date);
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean registrarIniciativa");
        }
    }
	
	public void registrarUsuario(String usuario,String passwd,String passwdC, String nombre,String apellido,String correo){
        System.out.println("Registrar usuario AdministradoBean");
        try{
            if(!passwd.equals(passwdC)){
				System.out.println("son iguales las claves, validar que lo sean");
			}
            servicioPT.registrarUsuario(usuario,passwd,nombre,apellido,correo,"Publico");
			System.out.println("Registro de usuario ok, pero falta redireccionar");
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean registrarIniciativa");
        }catch(Exception e){
			System.out.println(e.getMessage());
		}
    }
	
    
    public List<Iniciativa> consultarIniciativas(){
        List<Iniciativa> iniciativas = null;
        try{
            System.out.println("AdministradorBEAN INICIATIVA");
            iniciativas = servicioPT.consultarIniciativas();
        }
        catch(ServicesException e){
            System.out.println("Entra en excepcion bean");

        }
        System.out.println("CONSULTAR INICIATIVAS ESPERO QUE NO PASE POR ACA");
        return iniciativas;
    }
	

    public List<Usuario> consultarUsuarios(){
        List<Usuario> usuarios = null;
        try{
            usuarios=servicioPT.consultarUsuarios();
            System.out.println("Entra correctamente en ConsultarUsuarioBean");
            
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean");
        }
        //System.out.println("usuarios= "+usuarios);
        return usuarios;
    }
	
		public void cambiarRol(String usuario,String rol){ //Mirar si toca usar los enum de ROL 
		try{
			System.out.println("ENTRA EN MODIFICAR ROL|| usuario: "+usuario+" rol: "+rol);
			System.out.println("Usuario val: "+this.usuario);
			servicioPT.cambiarRol(usuario,rol);
		}
		catch(ServicesException e){
			System.out.println("Excepcion MODIFICANDO administradorBean");
		}
	}
	
	public void cambiarEstado(int id, String estado){
		try{
			System.out.println("ENTRA EN canmbiar INICIATIVA || id: "+id +"estado: "+estado);
			servicioPT.cambiarEstado(id,estado);
		}catch(ServicesException e){
			System.out.println("Excepcion CAMBIANDO iniciativa administradorBean");
		}
	}
	
	
	
	public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
	
	public boolean getSkip(){
		return skip;
	}
	
	public void setSkip(boolean skip){
		this.skip=skip;
	}
	
	public Usuario getUsuario(){
		System.out.println("AdministradorBean Usuario solicitado: "+usuario);
		return usuario;
	}
	
	public void setSelectedUsuario(Usuario usuario){
		this.usuario=usuario;
	}
	
}