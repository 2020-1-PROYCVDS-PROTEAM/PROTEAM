package edu.eci.cvds.samples.persistence;

import java.util.List;
import edu.eci.cvds.samples.entities.Usuario;


public interface UsuarioDAO {

	public Usuario consultarUsuario(String usuario, String passw)throws PersistenceException;
	public List<Usuario> consultarUsuarios()throws PersistenceException;
}