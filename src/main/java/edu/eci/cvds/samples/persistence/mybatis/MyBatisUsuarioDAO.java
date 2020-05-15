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
        try {
            return usuarioMapper.consultarUsuario(usuario);
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar el usuario:" + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Usuario> consultarUsuarios() throws PersistenceException {
        try {
            return usuarioMapper.consultarUsuarios();
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar los usuarios:" + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void registrarUsuario(String usuario, String passwd, String nombre, String apellido, String correo, String rol) throws PersistenceException {
        try {
            usuarioMapper.registrarUsuario(usuario, passwd, correo, nombre, apellido, rol);
        } catch (Exception e) {
            throw new PersistenceException("Error al registrar el usuario: " + e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void cambiarRol(String usuario, String rol) throws PersistenceException {
        try {
            usuarioMapper.cambiarRol(usuario, rol);
        } catch (Exception e) {
            throw new PersistenceException("Error al modificar el rol del usuario: " + e.getLocalizedMessage(), e);
        }
    }

}
