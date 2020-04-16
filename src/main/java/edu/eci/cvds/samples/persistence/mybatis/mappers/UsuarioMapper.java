package edu.eci.cvds.samples.persistence.mybatis.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Usuario;


public interface UsuarioMapper {

	public Usuario consultarUsuario(@Param("us") String usuario,@Param("pass") String passw);
	public List<Usuario> consultarUsuarios();
	public void insertarUsuario(@Param("usuario") int usuario,@Param("passw") String passw,@Param("correo") String correo,@Param("nombre") String nombre,@Param("apellido") String apellido);
}