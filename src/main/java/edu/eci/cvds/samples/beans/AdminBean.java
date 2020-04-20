package edu.eci.cvds.samples.beans;

import edu.eci.cvds.samples.entities.Rol;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;
import edu.eci.cvds.samples.entities.Iniciativa;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

import java.sql.Date;



@ManagedBean(name="UsersBean")
@ApplicationScoped
public class AdminBean extends BasePageBean {

    @Inject
    private ServicioProteam servicioProteam;
    private Usuario selectedUsuario;
	//private long costo;
	
    public List<Usuario> consultarClientes(){
        List<Usuario> usuarios = null;
        try{
        	usuarios=servicioProteam.consultarUsuarios();
        } catch (ServicesException e) {
            setErrorMessage(e);
        }
        return usuarios;
    }
    public Usuario consultarCliente(String Usuario){
    	Usuario usuario=null;
        try {
            usuario=servicioProteam.consultarUsuario(Usuario);
        } catch (Exception e) {
            setErrorMessage(e);
        }
        return usuario;
    }
	
	public Usuario getSelectedUsuario(){
		return selectedUsuario;
	}
	
	public void setSelectedUsuario(Usuario usuario){
		selectedUsuario=usuario;
	}
    
    /*
    public void registrarCliente(long doc,String nombre,String telefono, String direccion,String mail){
        try{
            serviciosAlquiler.registrarCliente(new Cliente(nombre,doc,telefono,direccion,mail));
        } catch (Exception e) {
            setErrorMessage(e);
        }
    }

    public void setSelectedCliente(Cliente cliente){this.selectedCliente = cliente;}

    public Cliente getSelectedCliente(){
        return selectedCliente;
    }
	
	
	public long consultarMulta(Item it) {
		long multa = 0;
		try{
			multa= serviciosAlquiler.consultarMultaAlquiler(it.getId(),new Date(System.currentTimeMillis()));
		}
		catch(ExcepcionServiciosAlquiler e){
            setErrorMessage(e);
        }
		return multa;
    }
	
	
	public void registrarAlquilerCliente(int id,int numDiasAlquilar){
        try{
            Item item = serviciosAlquiler.consultarItem(id);
            serviciosAlquiler.registrarAlquilerCliente(new Date(System.currentTimeMillis()),selectedCliente.getDocumento(),item,numDiasAlquilar);
        }catch(ExcepcionServiciosAlquiler e){
            setErrorMessage(e);
        }
    }
	
	public void consultarCosto(int id, int numDiasAlquilar){
        try {
            costo = serviciosAlquiler.consultarCostoAlquiler(id, numDiasAlquilar);
        } catch (ExcepcionServiciosAlquiler e){
            setErrorMessage(e);
        }
    }
	
	public long getCosto(){
        return costo;
    }
*/
    private void setErrorMessage(Exception e){
        String message = e.getMessage();
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

}