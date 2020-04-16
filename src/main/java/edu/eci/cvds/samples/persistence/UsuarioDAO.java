package edu.eci.cvds.samples.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Usuario;


public interface UsuarioMapper {

	public Usuario consultarUsuario(String usuario, String passw)throws PersistenceException;
	public List<Usuario> consultarUsuarios()throws PersistenceException;
	public void insertarUsuario(nt usuario,String passw,String correo,String nombre, apellido)throws PersistenceException;
}