package edu.eci.cvds.samples.Services;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Iniciativa;
import edu.eci.cvds.samples.entities.Usuario;


public interface ServicioProteam {
	
	
	public abstract Usuario consultarUsuario(String usuario)throws ServicesException;
	public abstract List<Usuario> consultarUsuarios()throws ServicesException;
	public abstract Iniciativa palabraClaveIniciativa(String palabraclave) throws ServicesException;	
	public abstract Iniciativa consultarIniciativa(int id)throws ServicesException;	
	public abstract List<Iniciativa> consultarIniciativas() throws ServicesException;
	public abstract void insertIniciativa(int id,int votos,String palabraClave,String nombre,String estado, String descripcion,String area,String usuario_i, String correo_i, Date fechar_ini) throws ServicesException;
	public abstract void registrarUsuario(String usuario,String passwd,String nombre,String apellido,String correo,String rol) throws ServicesException;
	public abstract void cambiarEstado(int id,String estado) throws ServicesException;
	public abstract void cambiarRol(String usuario, String rol) throws ServicesException;
}
