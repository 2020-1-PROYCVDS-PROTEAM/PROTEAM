package edu.eci.cvds.samples.persistence.mybatis;

import java.util.List;
import java.sql.Date;
import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.persistence.PersistenceException;
import edu.eci.cvds.samples.persistence.UsuarioDAO;
import edu.eci.cvds.samples.persistence.mybatis.mappers.UsuarioMapper;

public class MyBatisUsuarioDAO implements UsuarioDAO {
	
    @Inject
    private UsuarioMapper usuarioMapper;
	
	
	@Override
	public Usuario consultarUsuario(String usuario) throws PersistenceException {
		try{
                    System.out.println("A VER CUANDO CONSULTA AL USUARIO EN PERSISTENCE MYBATISDAOUSUARIO");
                    return usuarioMapper.consultarUsuario(usuario);

            //return usuarioMapper.consultarUsuario(usuario);
        }catch(Exception e){
            throw new PersistenceException("Error al consultar el usuario:"+e.getLocalizedMessage(), e);   
        }
	}

	@Override
	public List<Usuario> consultarUsuarios() throws PersistenceException {
		try{
			
            return usuarioMapper.consultarUsuarios(); //aqui se muere
        }catch(Exception e){
            throw new PersistenceException("Error al consultar los usuarios:"+e.getLocalizedMessage(), e);   
        }
	}

}
