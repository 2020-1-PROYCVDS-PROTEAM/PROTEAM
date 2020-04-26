 package edu.eci.cvds.samples.Services.impl;

import java.sql.Date;
import java.util.List;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.IniciativaDAO;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.Services.ServicesException;
import edu.eci.cvds.samples.Services.ServicioProteam;

@Singleton
public class ServicioProteamImpl implements ServicioProteam {
	
	
	@Inject
    private UsuarioDAO daoUsuario;
    @Inject
    private IniciativaDAO daoIniciativa;

    
    @Override
    public Usuario consultarUsuario(String usuario)throws ServicesException{
    	try{
            Usuario u = daoUsuario.consultarUsuario(usuario);
            if(u == null) {
            	throw new ServicesException("El usuario no existe");
            }else {
            	return u;
            }
            
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
            System.out.println("ServicioProTeamIMPL INICIATIVA");
            return daoIniciativa.consultarIniciativas();
        }catch(PersistenceException ex){
            throw new ServicesException("No hay iniciativas",ex);
        }
	}
        
    
    @Override
	public void insertIniciativa(int id,int votos,String palabraClave,String nombre,String estado, String descripcion,String area,String usuario_i, String correo_i, Date fechar_ini) throws ServicesException{
    	try{
            System.out.println("insertarIniciativaServiciosProTeam");
            System.out.println("id: "+id);
            System.out.println("votos: "+votos);
            System.out.println("palabraClave: "+palabraClave);
            System.out.println("nombre: "+nombre);
            System.out.println("estado: "+estado);
            System.out.println("descripcion: "+descripcion);
            System.out.println("area: "+area);
            System.out.println("usuario_i: "+usuario_i);
            System.out.println("correo_i: "+correo_i);
            System.out.println("ferchar_ini: "+fechar_ini);

            daoIniciativa.insertIniciativa(id, votos,palabraClave ,nombre, estado, descripcion, area, usuario_i, correo_i, fechar_ini);
        }catch(PersistenceException ex){
            throw new ServicesException("No fue posible agregar la nueva iniciativa",ex);
        }
	}
	
	@Override
	public void registrarUsuario(String usuario,String passwd,String nombre,String apellido,String correo,String rol) throws ServicesException{
			try{
				System.out.println("RegistrarUsuarioServiciosProTeam");
				System.out.println("usuario: "+usuario);
				System.out.println("passwd: "+passwd);
				System.out.println("nombre: "+nombre);
				System.out.println("apellido: "+apellido);
				System.out.println("correo: "+correo);				
				System.out.println("correo: "+rol);	
				daoUsuario.registrarUsuario(usuario,passwd,nombre,apellido,correo,rol);
			}
			catch(PersistenceException ex){
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
	
    @Override
	public void cambiarRol(String usuario,String rol) throws ServicesException{
    	try{
			System.out.println("ENTRA EN SERVICIOSPT CAMBIARROL");
            daoUsuario.cambiarRol(usuario, rol);
        }catch(PersistenceException ex){
            throw new ServicesException("No fue posible modificar el rol",ex);
        }
	}


}
