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
	

        
    public Usuario consultarUsuario(String usuario){
        try{
            return servicioPT.consultarUsuario(usuario);
        }
        catch(ServicesException e){
            System.out.println("Entra en excepcion UsuarioUnico");    
        }
        return null; //esto puede fallar pero vamos a intentar
    }
    
    
    public void registrarIniciativa(int id,int votos,String palabraClave, String nombre,String estado,String descripcion, String area, String usuario_i,String correo_i,Date fecha_ini){
        try{
            servicioPT.insertIniciativa(id,votos,palabraClave,nombre,estado,descripcion,area,usuario_i,correo_i,fecha_ini);
        } catch (ServicesException e) {
            System.out.println("Entra en excepcion bean");
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