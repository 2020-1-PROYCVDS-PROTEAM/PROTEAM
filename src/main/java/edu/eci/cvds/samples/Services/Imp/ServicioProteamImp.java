package edu.eci.cvds.samples.Services.Imp;

import java.sql.Date;
import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;

public class ServicioProteamImp implements ServicioProteam {
	
	
	@Inject
    private UsuarioDAO daoUsuario;
    @Inject
    private IniciativaDAO daoIniciativa;

    
    @Override
    public Usuario consultarUsuario(String usuario, String passw)throws ServicesException{
    	try{
            return daoUsuario.consultarUsuario(usuario,passw);
        }catch(PersistenceException ex){
            throw new ServicesException("No fue posible consultar el usuario ",ex);
        }
    }
    
    @Override
	public List<Usuario> consultarUsuarios()throws ServicesException{
    	try{
            return daoUsuario.consultarUsuarios();
        }catch(PersistenceException ex){
            throw new ServicesException("No existen usuarios",ex);
        }
	}
    
    @Override
	public Iniciativa palabraClaveIniciativa(String palabraclave) throws ServicesException{
		try{
            return daoIniciativa.palabraClaveIniciativa(palabraclave);
        }catch(PersistenceException ex){
            throw new ServicesException("No fue posible consultar la palabra clave",ex);
        }
	}
	
    @Override
	public Iniciativa consultarIniciativa(int id)throws ServicesException{
    	try{
            return daoIniciativa.consultarIniciativa(id);
        }catch(PersistenceException ex){
            throw new ServicesException("No fue posible consultar la iniciativa",ex);
        }
	}
    
    @Override
	public List<Iniciativa> consultarIniciativas() throws ServicesException{
    	try{
            return daoIniciativa.consultarIniciativas();
        }catch(PersistenceException ex){
            throw new ServicesException("No hay iniciativas",ex);
        }
	}
    
    @Override
	public void insertIniciativa(int id,int votos,String nombre,String estado, String descripcion,String area,String usuario_i, String correo_i, Date fechar_ini) throws ServicesException{
    	try{
            daoIniciativa.insertIniciativa(id, votos, nombre, estado, descripcion, area, usuario_i, correo_i, fechar_ini);
        }catch(PersistenceException ex){
            throw new ServicesException("No fue posible agregar la nueva iniciativa",ex);
        }
	}
    
    @Override
	public void cambiarEstado(int id,String estado) throws ServicesException{
    	try{
            daoIniciativa.cambiarEstado(id, estado);
        }catch(PersistenceException ex){
            throw new ServicesException("No fue posible cambiar el estado",ex);
        }
	}
	
    

}
