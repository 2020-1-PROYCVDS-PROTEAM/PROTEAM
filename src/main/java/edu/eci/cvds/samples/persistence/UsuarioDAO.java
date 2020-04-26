package edu.eci.cvds.samples.persistence;

import java.util.List;
import edu.eci.cvds.samples.entities.Usuario;


public interface UsuarioDAO {

	public Usuario consultarUsuario(String usuario)throws PersistenceException;
	public void registrarUsuario(String usuario,String passwd,String nombre,String apellido,String correo,String rol) throws PersistenceException;
	public List<Usuario> consultarUsuarios()throws PersistenceException;
	public void cambiarRol(String usuario, String Rol)throws PersistenceException;
	
}