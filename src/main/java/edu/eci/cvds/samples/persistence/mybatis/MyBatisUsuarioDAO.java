package edu.eci.cvds.samples.persistence.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.persistence.mybatis.mappers.UsuarioMapper;

public class MyBatisUsuarioDAO implements UsuarioDAO {
    @Inject
    UsuarioMapper usuarioMapper;
	@Override
	public Usuario consultarUsuario(String usuario, String passw) throws PersistenceException {
		try{
            return usuarioMapper.consultarUsuario(usuario,passw);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el usuario:"+e.getLocalizedMessage(), e);   
        }
	}

	@Override
	public List<Usuario> consultarUsuarios() throws PersistenceException {
		try{
            return usuarioMapper.consultarUsuarios();
        }catch(Exception e){
            throw new PersistenceException("Error al consultar los usuarios:"+e.getLocalizedMessage(), e);   
        }
	}

}
